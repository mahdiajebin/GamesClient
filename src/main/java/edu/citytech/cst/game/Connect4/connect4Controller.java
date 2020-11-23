package edu.citytech.cst.game.Connect4;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.layout.FlowPane;

import java.net.URL;
import java.util.ResourceBundle;

public class connect4Controller implements Initializable {
    @FXML
    private FlowPane fpSlots;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        for(int i = 0; i<42; i++){
            Label l = new Label("test" + i);
            fpSlots.getChildren().add(l);
        }




    }



}

