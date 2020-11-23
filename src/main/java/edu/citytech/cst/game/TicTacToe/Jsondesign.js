/*
WHAT WE PASSING
 input:WHICH SLOT YOU CLICKED AND WHAT IT IS X OR O;
 http://localhost:9416/games/tictactoe?moves=xoxo?????



*/

//Output

//Webservice example: http://localhost:9416/games/tictactoe
// below represents the output from JSON webservice
{

isWinner: true ,
position:[0,1,2],
whoWon: "X"

}

//Below is a tie result
{

isWinner: false,
position:[],
whoWon: "?"

}
