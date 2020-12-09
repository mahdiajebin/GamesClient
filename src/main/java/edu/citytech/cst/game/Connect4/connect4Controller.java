package edu.citytech.cst.game.Connect4;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.effect.Bloom;
import javafx.scene.effect.Glow;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.FlowPane;
import org.hibernate.tool.schema.internal.exec.ScriptTargetOutputToUrl;

import java.net.URL;
import java.util.ResourceBundle;

public class connect4Controller implements Initializable {

    @FXML
    private Button btnReset;
    @FXML
    private FlowPane fpSlots;

    @FXML
    private Label lblMessage;

    @FXML
    private Label lblTurn;

    private boolean isX = true;


    private Label[] labels = new Label[42];
    int count = 0;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        for (int i = 0; i <= 41; i++) {
            Label l = new Label("?");
            labels[i] = l;
            // l.setStyle("-fx-margin-right: 500px;");
            l.getStyleClass().add("custom-label");
            l.setUserData(i);

//
            l.setOnMouseClicked((MouseEvent e) -> this.clickedEvent(e)


            );

//            l.setOnMouseClicked(e-> {
//            Label label =(Label) e.getSource();
//                label.getStyleClass().add("highlight");
//                System.out.println(e);
//            });

            fpSlots.getChildren().add(l);

        }



    }



    private void clickedEvent(MouseEvent e) {
        Label l = (Label) e.getSource();
        String XorO = "";


        ObservableList<Node> children = fpSlots.getChildren();

        int index = 0;






            String[] moves = new String[42];

            for (int i = 0; i < labels.length; i++) {

                moves[i] = labels[i].getText();

            }

            int cellNumber = (int) l.getUserData();

        	System.out.println(cellNumber);

            String newMove = l.getText();

            moves[cellNumber] = "?";
            l.setText("?");
        int nextMove = Connect4Service.getValidCellMoves(moves, cellNumber);
        labels[nextMove].setText(newMove);

        lblMessage.setText("Clicked in" + cellNumber + "next valid move is " + nextMove);





            lblTurn.setText("");

        if ((!l.getText().equals("?") || (!labels[nextMove].getStyleClass().add("XorO")))) {
            String value = "illegal move, Cheater!";
            lblTurn.setText(value);
            return;


        }



            if (isX) {
                XorO = "X";

            } else {
                XorO = "O";
            }

            isX = !isX;
            labels[nextMove].getStyleClass().add(XorO);
            l.setText(XorO);



        }












    @FXML
    void reset(ActionEvent event) {

        for (Label label : labels) {
            label.setText("?");
            label.getStyleClass().removeIf(e -> e.equals("X") || e.equals("O"));
        }
        isX = true;
        lblMessage.setText("");

    }


}





  //  @Override
   // public void initialize(URL url, ResourceBundle resourceBundle) {
        //counter
//
//        int size = 42;
//        for(int i = 0; i <size; i++){
//            Label l = new Label("?" );
//            l.getStyleClass().add("larger-label"); l.getStyleClass().add("smaller-label");
////
////            if (size > 78){
////                l.getStyleClass().add("smaller2-label");
////            }
////            else if ( size> 38 ){
////                l.getStyleClass().add("larger-label"); l.getStyleClass().add("smaller-label");
////            }else {
////
////            }
//////
////            if( i % 10 ==0){
////                l.getStyleClass().add("highlight");
////
////            }
//
//
//        //    which label was clicked
//            l.setOnMouseClicked(e-> {
//            Label label =(Label) e.getSource();
//                label.getStyleClass().add("highlight");
//                System.out.println(e);
//            });
//
//
//            fpSlots.getChildren().add(l);
//        }
//
//    }

    //instance variable
//
//    String move = "";
//




//}

