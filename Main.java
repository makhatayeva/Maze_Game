package Maze_Game;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("proNamaMaze.fxml"));
        primaryStage.setTitle("Walk with Salta");
        primaryStage.setScene(new Scene(root, 512, 512));
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
