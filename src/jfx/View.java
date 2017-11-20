package jfx;

import async.impl.Channel;
import async.impl.Display;
import async.impl.GeneratorImpl;
import async.impl.strategies.Sequential;
import async.interfaces.Generator;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * View
 */
public class View {

    ScheduledExecutorService service;
    Generator generator;
    @FXML
    private Label labelDisplay1;
    @FXML
    private Label labelDisplay2;
    @FXML
    private Label labelDisplay3;
    @FXML
    private Label labelDisplay4;

    @FXML
    private void initialize(){
        generator = new GeneratorImpl(new Sequential());
        service = new ScheduledThreadPoolExecutor(15);
        Channel channel1 = new Channel(generator, service, 100);
        Channel channel2 = new Channel(generator, service, 200);
        Channel channel3 = new Channel(generator, service, 300);
        Channel channel4 = new Channel(generator, service, 400);
        Display display1 = new Display(labelDisplay1);
        Display display2 = new Display(labelDisplay2);
        Display display3 = new Display(labelDisplay3);
        Display display4 = new Display(labelDisplay4);
        channel1.attach(display1);
        channel2.attach(display2);
        channel3.attach(display3);
        channel4.attach(display4);
        ((GeneratorImpl) generator).addAsyncObserver(channel1);
        ((GeneratorImpl) generator).addAsyncObserver(channel2);
        ((GeneratorImpl) generator).addAsyncObserver(channel3);
        ((GeneratorImpl) generator).addAsyncObserver(channel4);
    }

    @FXML
    private void start(){
        service.scheduleAtFixedRate(()-> generator.generate(), 0, 1000, TimeUnit.MILLISECONDS);
    }

    @FXML
    private void stop(){
        if(!service.isShutdown()) {
            service.shutdown();
        }
    }
}
