package edu.citytech.cst.game.TicTacToe;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class TicTacToeMain extends Application {

    public static void main(String[] args) {
        Application.launch(TicTacToeMain.class, args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        Parent root =  FXMLLoader.load(getClass().getResource("TicTacToeView.fxml"));

             stage.setTitle("TicTacToe, Author: Rahman, Sumyia");
     stage.setScene(new Scene(root));
     stage.show();
    }






}
