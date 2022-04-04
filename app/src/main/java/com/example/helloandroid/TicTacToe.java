package com.example.helloandroid;

public class TicTacToe {
    public static final int SIDE = 3;
    private int[][] game;
    private int turn;

    // TicTacToe - initializes the game board and calls the resetGame() function
    public TicTacToe()
    {
    }

    // play - Marks an empty spot if the move is legal
    // @param int - the row index
    // @param int - the column index
    // @return int - the old value of turn
    int play(int row, int column)
    {
        return 0;
    }

    // canStillPlay - Returns true if there is still at least one cell not taken on the board; otherwise, returns false
    // @return boolean - returns true if the game is not over/there are still unmarked spots on the board
    boolean canStillPlay()
    {
        return false;
    }

    // whoWon - A function to determine who won the game
    // @return int Returns i if player i won, 0 if nobody has won yet
    int whoWon()
    {
        return 0;
    }

    // gameOver - A function to determine if the game is over
    // @return boolean - Returns true if the game is over, false otherwise
    boolean gameOver()
    {
        return false;
    }

    // resetGame - Clears the board and sets turn to 1
    void resetGame()
    {

    }
}
