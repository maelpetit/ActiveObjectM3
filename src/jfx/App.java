package jfx;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * App
 */
public class App extends Application{

    /**
     * Override function start
     * @param primaryStage
     * @throws Exception
     */
    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("view.fxml"));
        primaryStage.setTitle("ActiveObject");
        primaryStage.setScene(new Scene(root, 600, 400));
        primaryStage.show();
    }


    /**
     * function main
     * @param args
     */
    public static void main(String[] args) {
        launch(args);
    }
}
