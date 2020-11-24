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
        int size = 100;
        for(int i = 0; i<size; i=i+5){
            Label l = new Label("" + i);


            if (size > 78){
                l.getStyleClass().add("smaller2-label");
            }
            else if ( size> 38 ){
                l.getStyleClass().add("smaller-label");
            }else {
                l.getStyleClass().add("larger-label");
            }

            if( i % 10 ==0){
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

