package edu.citytech.cst.game.cities;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class CitiesMain extends Application {

    public static void main(String[] args) {
        Application.launch(CitiesMain.class, args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        Parent root =  FXMLLoader.load(getClass().getResource("CitiesView.fxml"));

        stage.setTitle("City List: Rahman, Sumyia");
        stage.setScene(new Scene(root));
        stage.show();
    }
}
