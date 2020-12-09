package edu.citytech.cst.game.Connect4;

public class connect4WinningCombo {


    public final int w1;
    public final int w3;
    public final int w2;
    public final int w4;
    public connect4WinningCombo(int w1, int w2, int w3, int w4) {
        this.w1 = w1;
        this.w2 = w2;
        this.w3 = w3;
        this.w4 = w4;
    }
    @Override
    public String toString() {
        return "connect4WinningCombo [w1=" + w1 + ", w3=" + w3 + ", w2=" + w2 + ", w4=" + w4 + "]";
    }
}
