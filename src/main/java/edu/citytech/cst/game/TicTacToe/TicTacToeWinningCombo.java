package edu.citytech.cst.game.TicTacToe;

public class TicTacToeWinningCombo {


    public final int w1,w2,w3;

    public TicTacToeWinningCombo(int w1, int w2, int w3) {
        this.w1 = w1;
        this.w2 = w2;
        this.w3 = w3;
    }

    @Override
    public String toString() {
        return "TicTacToeWinningCombo{" +
                "w1=" + w1 +
                ", w2=" + w2 +
                ", w3=" + w3 +
                '}';
    }
}
