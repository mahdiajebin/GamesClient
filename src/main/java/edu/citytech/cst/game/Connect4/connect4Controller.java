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
    //counter
        for(int i = 0; i<42; i++){
            Label l = new Label("" + i);
            if(i>20){
                l.getStyleClass().add("highlight");
            }
            //which label was clicked
            l.setOnMouseClicked(e-> {
            Label label =(Label) e.getSource();
                label.getStyleClass().add("highlight");
                System.out.println(e);
            });


            fpSlots.getChildren().add(l);
        }




    }



}

