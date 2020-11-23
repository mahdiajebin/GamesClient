package edu.citytech.cst.game.Connect4;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class connect4Main extends Application {

    public static void main(String[] args) {
        Application.launch(connect4Main.class, args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        Parent root =  FXMLLoader.load(getClass().getResource("connect4View.fxml"));

        stage.setTitle("Connect4, Author: Rahman, Sumyia");
        stage.setScene(new Scene(root));
        stage.show();
    }
}
