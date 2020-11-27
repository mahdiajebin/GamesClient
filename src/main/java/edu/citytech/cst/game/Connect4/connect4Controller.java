package edu.citytech.cst.game.Connect4;

import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.FlowPane;

import java.net.URL;
import java.util.ResourceBundle;

public class connect4Controller implements Initializable {



    @FXML
    private FlowPane fpSlots;





    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
    //counter




        int size = 42;
        for(int i = 0; i<size; i++){
            Label l = new Label("?" );
            l.getStyleClass().add("larger-label");
//
//            if (size > 78){
//                l.getStyleClass().add("smaller2-label");
//            }
//            else if ( size> 38 ){
//                l.getStyleClass().add("larger-label"); l.getStyleClass().add("smaller-label");
//            }else {
//
//            }
//
//            if( i % 10 ==0){
//                l.getStyleClass().add("highlight");

//            }


            //which label was clicked
//            l.setOnMouseClicked(e-> {
//            Label label =(Label) e.getSource();
//                label.getStyleClass().add("highlight");
//                System.out.println(e);
//            });


            fpSlots.getChildren().add(l);
        }








    }
    //instance variable
//
//    String move = "";
//
//    @FXML
//    void nextMove(MouseEvent event) {
//
//
//
//       // String[] moves = new String[42];
//        ObservableList<Node> children = fpSlots.getChildren();
//
//
//
//    }



}

