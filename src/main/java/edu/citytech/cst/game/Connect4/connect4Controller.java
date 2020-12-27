package edu.citytech.cst.game.Connect4;

import com.google.gson.internal.$Gson$Types;
import com.jbbwebsolutions.http.utility.URLUtility;
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
import java.util.Arrays;
import java.util.ResourceBundle;
import java.util.StringJoiner;

public class connect4Controller implements Initializable {
    @FXML
    private Label urllabel;
    @FXML
    private Button btnReset;
    @FXML
    private FlowPane fpSlots;

    @FXML
    private Label lblMessage;

    @FXML
    private Label lblTurn;

    @FXML
    private Label scoreYellow;

    @FXML
    private Label scoreRed;

    private int RcurrentScore=0;
    private int YcurrentScore=0;
    private int scoreYellowC =0;
    private int scoreRedC=0;

    private boolean isX = false;
    private boolean winner = false;


    private Label[] labels = new Label[42];
   // int count = 1;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        for (int i = 0; i <= 41; i++) {
            Label l = new Label("?");
            labels[i] = l;
            // l.setStyle("-fx-margin-right: 500px;");
            l.getStyleClass().add("custom-label");
            l.setUserData(i);

            l.setOnMouseClicked((MouseEvent e) -> this.clickedEvent(e)


            );



            fpSlots.getChildren().add(l);

        }


    }

    private Connect4Status winner(String moves) {
        final String url = "http://localhost:9416/game/connect4?moves=NNN";
        String newURL = url.replace("NNN", moves);
       urllabel.setText(newURL);
        return URLUtility.get(newURL,Connect4Status.class);
    }



    private void clickedEvent(MouseEvent e) {

        String[] moves = new String[42];
        Label l = (Label) e.getSource();
        String XorO = "";




        for (int i = 0; i < labels.length; i++) {

            moves[i] = labels[i].getText();

        }

        int cellNumber = (int) l.getUserData();

        System.out.println(cellNumber);

        String newMove = l.getText();

        moves[cellNumber] = "?";
        l.setText("?");




        int nextMove = getValidCellMoves(moves, cellNumber);

        //which one was selected
        labels[nextMove].setText(newMove);


        // lblMessage.setText("Clicked in" + cellNumber + "next valid move is " + nextMove);

        lblTurn.setText("");



        if ((!l.getText().equals("?") || (!labels[nextMove].getStyleClass().add("XorO")))) {
            String value = "illegal move";
            lblTurn.setText(value);
            return;

        }


        if (isX) {
            XorO = "X";

        } else {
            XorO = "O";
        }


        StringJoiner joiner = new StringJoiner("");


        for (String s : moves) {
            joiner.add(s);
        }
        String combo = joiner.toString();

        Connect4Status winner = winner(combo);
        System.out.println(" winner stat " + winner.winner);


        System.out.println(Arrays.toString(moves));


            if (winner.winner == true && (isX == true)) {

                scoreYellow.setText("");
                lblMessage.setText("The winner is: Yellow");
                lblTurn.setText("Please reset to start again");


                 scoreYellowC ++;

                scoreYellow.setText("Yellow Score: " + scoreYellowC);


            } else if (winner.winner == true && (isX == false)) {

                scoreRed.setText("");
                lblMessage.setText("The winner is: Red ");
                lblTurn.setText("Please reset to start again");


                  scoreRedC ++;


                scoreRed.setText("Red Score: " + scoreRedC);





        }



        if(! winner.winner) {

            isX = !isX;
            labels[nextMove].getStyleClass().add(XorO);

            l.setText(XorO);


        }


    }


    @FXML
    void reset(ActionEvent event) {


        for (Label label : labels) {
            label.setText("?");
            label.getStyleClass().removeIf(e -> e.equals("X") || e.equals("O"));
        }
        winner = false;
        isX = false;
        lblMessage.setText("");
        lblTurn.setText("");

    }


    public  int getValidCellMoves(String[] moves, int i) {
        int p = i;
        while(p < moves.length)
        {
            boolean status = moves[p].equals("?");
            if(status)
            {
                p+=7;
            }
            else
            {
                break;
            }
        }
        p-=7;
        return p;
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

