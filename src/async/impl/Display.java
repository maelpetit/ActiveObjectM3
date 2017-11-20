package async.impl;

import async.interfaces.*;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.text.Text;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

/**
 * Concrete observer
 */
public class Display  implements Observer<AsyncGenerator> {

    private Label label;

    /**
     * Constructor
     * @param label
     */
    public Display(Label label){
        this.label = label;
    }

    /**
     * update asyncGenerator
     * @param asyncGenerator
     */
    @Override
    public void update(AsyncGenerator asyncGenerator) {
        try {
            Integer value = asyncGenerator.getValue().get();
            System.out.println(value);
            Platform.runLater(() -> label.setText(value + ""));
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }

}
