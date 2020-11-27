package edu.citytech.cst.game.TicTacToe;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;

import java.lang.reflect.Array;

public class TicTacToeController {

    @FXML
    private Label slot1;

    @FXML
    private Label slot2;

    @FXML
    private Label slot3;

    @FXML
    private Label slot4;

    @FXML
    private Label slot5;

    @FXML
    private Label slot6;

    @FXML
    private Label slot7;

    @FXML
    private Label slot8;

    @FXML
    private Label slot9;

    @FXML
    private Button btnReset;

    @FXML
    private Label lblMessage;

    @FXML
    private GridPane gpGame;

    private boolean isWinner = false;
    private boolean isTie = false;

    @FXML
    void resetGame(ActionEvent event) {

        //getting children inside grid pane
        ObservableList<Node> children = gpGame.getChildren();
//node child

        for (Node child :
                children) {
            //downcasting node to a label cx node dont have access to label
            Label label = (Label) child;
            label.setText("?");

        }


        lblMessage.setText("");
        isWinner = false;
        isTie=false;
    }

    //instance variable
    String move = "";


    @FXML
    void nextMove(MouseEvent event) {

        if (!isTie) {

            if (!isWinner && !isTie) {
                //   System.out.println(event);
                //event.get source is going to return where it was clicked and return an object so we have to downcast it.
                Object o = event.getSource();
                //when we downcast it we get info out of the box(object); take advan of the attribute
                Label l = (Label) o;

                lblMessage.setText("");
                lblMessage.getStyleClass().remove("winner");
                lblMessage.getStyleClass().remove("error");


                if (!l.getText().equals("?")) {
                    lblMessage.setText(" you are attempting an illegal move");
                    lblMessage.getStyleClass().add("error");
                    return;
                }


                move = move.equals("X") ? "O" : "X";
                l.setText(move);



                boolean hcomb1 = slot1.getText().equals("X") && slot2.getText().equals("X") && slot3.getText().equals("X");
                boolean hcomb2 = slot1.getText().equals("O") && slot2.getText().equals("O") && slot3.getText().equals("O");
                boolean hcomb3 = slot4.getText().equals("X") && slot5.getText().equals("X") && slot6.getText().equals("X");
                boolean hcomb4 = slot4.getText().equals("O") && slot5.getText().equals("O") && slot6.getText().equals("O");
                boolean hcomb5 = slot7.getText().equals("X") && slot8.getText().equals("X") && slot9.getText().equals("X");
                boolean hcomb6 = slot7.getText().equals("O") && slot8.getText().equals("O") && slot9.getText().equals("O");

                boolean vcomb1 = slot1.getText().equals("X") && slot4.getText().equals("X") && slot7.getText().equals("X");
                boolean vcomb2 = slot1.getText().equals("X") && slot4.getText().equals("X") && slot7.getText().equals("X");
                boolean vcomb3 = slot2.getText().equals("X") && slot5.getText().equals("X") && slot8.getText().equals("X");
                boolean vcomb4 = slot2.getText().equals("O") && slot5.getText().equals("O") && slot8.getText().equals("O");
                boolean vcomb5 = slot3.getText().equals("X") && slot6.getText().equals("X") && slot9.getText().equals("X");
                boolean vcomb6 = slot3.getText().equals("O") && slot6.getText().equals("O") && slot9.getText().equals("O");

                boolean dcomb1 = slot1.getText().equals("X") && slot5.getText().equals("X") && slot9.getText().equals("X");
                boolean dcomb2 = slot1.getText().equals("O") && slot5.getText().equals("O") && slot9.getText().equals("O");
                boolean dcomb3 = slot3.getText().equals("X") && slot5.getText().equals("X") && slot7.getText().equals("X");
                boolean dcomb4 = slot3.getText().equals("O") && slot5.getText().equals("O") && slot7.getText().equals("O");


//Tie


                isWinner = (hcomb1 || hcomb2 || hcomb3 || hcomb4 || hcomb5 || hcomb6 || vcomb1 || vcomb2 || vcomb3 || vcomb4 || vcomb5 || vcomb6 || dcomb1 || dcomb2 || dcomb3 || dcomb4);


                isTie = ((!slot1.getText().equals("?")
                        && !slot2.getText().equals("?")
                        && !slot3.getText().equals("?")
                        && !slot4.getText().equals("?")

                        && !slot5.getText().equals("?")
                        && !slot6.getText().equals("?")
                        && !slot7.getText().equals("?")
                        && !slot8.getText().equals("?")
                        && !slot9.getText().equals("?")
                )
                        && !isWinner);


                if (isTie) {
                    lblMessage.setText("Its a Tie ");
                    return;
                }


                if (isWinner) {
                    lblMessage.setText(("Winner is ") + move);
                    lblMessage.getStyleClass().add("winner");


                }


            }else {
                lblMessage.setText("Sorry, ["+ move + "] already won");
            }

        } // is tie

    }

   }







//



//boolean[] winner = new boolean[]{
//        slot1.getText().equals("X") && slot2.getText().equals("X") && slot3.getText().equals("X"),
//        slot1.getText().equals("X") && slot2.getText().equals("X") && slot3.getText().equals("X"),
//        slot4.getText().equals("X") && slot5.getText().equals("X") && slot6.getText().equals("X"),
//        slot4.getText().equals("O") && slot5.getText().equals("O") && slot6.getText().equals("O"),
//        slot7.getText().equals("X") && slot8.getText().equals("X") && slot9.getText().equals("X"),
//        slot7.getText().equals("O") && slot8.getText().equals("O") && slot9.getText().equals("O")
//};



