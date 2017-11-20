package jfx;

import async.impl.Channel;
import async.impl.Display;
import async.impl.GeneratorImpl;
import async.impl.strategies.Atomic;
import async.impl.strategies.Sequential;
import async.interfaces.Generator;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;

import java.util.concurrent.Executors;
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
    private RadioButton seqButton;
    @FXML
    private RadioButton atomButton;
    @FXML
    private Button startButton;
    @FXML
    private Button stopButton;
    @FXML
    private Button pauseButton;


    private Atomic atomic = new Atomic();
    private Sequential sequential = new Sequential();

    @FXML
    private void initialize(){
        generator = new GeneratorImpl(sequential);
        seqButton.setSelected(true);
        atomButton.setSelected(false);
        stopButton.setDisable(true);
        pauseButton.setDisable(true);
        service = Executors.newScheduledThreadPool(Integer.MAX_VALUE);
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
        service = Executors.newScheduledThreadPool(Integer.MAX_VALUE);
        service.scheduleAtFixedRate(() -> generator.generate(), 0, 100, TimeUnit.MILLISECONDS);
        startButton.setDisable(true);
        stopButton.setDisable(false);
        pauseButton.setDisable(false);
    }

    @FXML
    private void stop(){
        if(!service.isShutdown()) {
            service.shutdown();
            ((GeneratorImpl) generator).reset();
            startButton.setDisable(false);
            stopButton.setDisable(true);
            pauseButton.setDisable(true);
        }
    }

    @FXML
    private void pause(){
        if(!service.isShutdown()) {
            service.shutdown();
            startButton.setDisable(false);
            stopButton.setDisable(true);
            pauseButton.setDisable(true);
        }
    }

    @FXML
    private void changeStratToSeq(){
        ((GeneratorImpl) generator).changeStrategy(sequential);
        atomButton.setSelected(false);
        seqButton.setSelected(true);
    }

    @FXML
    private void changeStratToAtom(){
        ((GeneratorImpl) generator).changeStrategy(atomic);
        atomButton.setSelected(true);
        seqButton.setSelected(false);
    }
}
