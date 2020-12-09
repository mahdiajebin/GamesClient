package edu.citytech.cst.game.Connect4;

public class Connect4Service {	public static int getValidCellMoves(String[] moves, int i) {
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
