package com.example.helloandroid;

public class TicTacToe {
    public static final int SIDE = 3;
    private int[][] game;
    private int turn;

    // TicTacToe - initializes the game board and calls the resetGame() function
    public TicTacToe()
    {
        game = new int[SIDE][SIDE];
        resetGame();
    }

    // play - Marks an empty spot if the move is legal
    // @param int - the row index
    // @param int - the column index
    // @return int - the old value of turn
    public int play(int row, int column)
    {
        boolean rowIndexWithinRange = false;
        if (0 <= row) {
            if (row <= SIDE - 1)
                rowIndexWithinRange = true;
            else
                return 0;
        }
        else {
            return 0;
        }

        boolean columnIndexWithinRange = false;
        if (0 <= column) {
            if (column <= SIDE - 1)
                columnIndexWithinRange = true;
            else
                return 0;
        }
        else {
            return 0;
        }

        boolean moveLegalityState = false;
        if (rowIndexWithinRange == true) {
            if (columnIndexWithinRange == true) {
                if (game[row][column] == 0)
                    moveLegalityState = true;
            }
            else {
                return 0;
            }
        }
        else {
            return 0;
        }

        int currentTurn = turn;
        if (moveLegalityState == true) {
            game[row][column] = turn;
            if (turn == 1) turn = 2;
            else turn = 1;
            return currentTurn;
        }
        else {
            return 0;
        }
    }

    // canStillPlay - Returns true if there is still at least one cell not taken on the board; otherwise, returns false
    // @return boolean - returns true if the game is not over/there are still unmarked spots on the board
    public boolean canStillPlay()
    {
        return false;
    }

    // whoWon - A function to determine who won the game
    // @return int Returns i if player i won, 0 if nobody has won yet
    public int whoWon()
    {
        final int PLAYER_ONE = 1;
        final int PLAYER_TWO = 2;

        // Check each of the 3 rows if the first player is the winner or the second player is the winner
        for (int row = 0; row <= SIDE - 1; row++) {
            int firstColumnOfCurrentRow = game[row][0];
            int secondColumnOfCurrentRow = game[row][1];
            int thirdColumnOfCurrentRow = game[row][2];

            boolean firstColumnIsPlayerOne = false;
            boolean secondColumnIsPlayerOne = false;
            boolean thirdColumnIsPlayerOne = false;
            if (firstColumnOfCurrentRow == PLAYER_ONE) {
                firstColumnIsPlayerOne = true;
            }
            else {
                firstColumnIsPlayerOne = false;
            }

            if (firstColumnIsPlayerOne == true) {
                if (secondColumnOfCurrentRow == PLAYER_ONE)
                    secondColumnIsPlayerOne = true;
                else
                    secondColumnIsPlayerOne = false;
            }
            else {
                secondColumnIsPlayerOne = false;
            }

            if (secondColumnIsPlayerOne == true) {
                if (thirdColumnOfCurrentRow == PLAYER_ONE)
                    thirdColumnIsPlayerOne = true;
                else
                    thirdColumnIsPlayerOne = false;
            }
            else {
                thirdColumnIsPlayerOne = false;
            }

            if (firstColumnIsPlayerOne) {
                if (secondColumnIsPlayerOne) {
                    if (thirdColumnIsPlayerOne) {
                        return PLAYER_ONE;
                    }
                }
            }

            boolean firstColumnIsPlayerTwo = false;
            boolean secondColumnIsPlayerTwo = false;
            boolean thirdColumnIsPlayerTwo = false;
            if (firstColumnOfCurrentRow == PLAYER_TWO) {
                firstColumnIsPlayerTwo = true;
            }
            else {
                firstColumnIsPlayerTwo = false;
            }

            if (firstColumnIsPlayerTwo == true) {
                if (secondColumnOfCurrentRow == PLAYER_TWO)
                    secondColumnIsPlayerTwo = true;
                else
                    secondColumnIsPlayerTwo = false;
            }
            else {
                secondColumnIsPlayerTwo = false;
            }

            if (secondColumnIsPlayerTwo == true) {
                if (thirdColumnOfCurrentRow == PLAYER_TWO)
                    thirdColumnIsPlayerTwo = true;
                else
                    thirdColumnIsPlayerTwo = false;
            }
            else {
                thirdColumnIsPlayerTwo = false;
            }

            if (firstColumnIsPlayerTwo == true) {
                if (secondColumnIsPlayerTwo == true) {
                    if (thirdColumnIsPlayerTwo == true) {
                        return PLAYER_TWO;
                    }
                }
            }
        }

        // Check the columns if player one is the winner or player two is the winner
        for (int column = 0; column <= SIDE - 1; column++) {
            int firstRowOfCurrentColumn = game[0][column];
            int secondRowOfCurrentColumn = game[1][column];
            int thirdRowOfCurrentColumn = game[2][column];
            boolean firstRowOfCurrentColumnIsPlayerOne = false;
            boolean secondRowOfCurrentColumnIsPlayerOne = false;
            boolean thirdRowOfCurrentColumnIsPlayerOne = false;
            if (firstRowOfCurrentColumn == PLAYER_ONE) {
                firstRowOfCurrentColumnIsPlayerOne = true;
            }
            else {
                firstRowOfCurrentColumnIsPlayerOne = false;
            }

            if (firstRowOfCurrentColumnIsPlayerOne == true) {
                if (secondRowOfCurrentColumn == PLAYER_ONE)
                    secondRowOfCurrentColumnIsPlayerOne = true;
                else
                    secondRowOfCurrentColumnIsPlayerOne = false;
            }
            else {
                secondRowOfCurrentColumnIsPlayerOne = false;
            }

            if (secondRowOfCurrentColumnIsPlayerOne = true) {
                if (thirdRowOfCurrentColumn == PLAYER_ONE)
                    thirdRowOfCurrentColumnIsPlayerOne = true;
                else
                    thirdRowOfCurrentColumnIsPlayerOne = false;
            }
            else {
                thirdRowOfCurrentColumnIsPlayerOne = false;
            }

            if (firstRowOfCurrentColumnIsPlayerOne == true) {
                if (secondRowOfCurrentColumnIsPlayerOne == true) {
                    if (thirdRowOfCurrentColumnIsPlayerOne == true)
                        return PLAYER_ONE;
                }
            }

            boolean firstRowOfCurrentColumnIsPlayerTwo = false;
            boolean secondRowOfCurrentColumnIsPlayerTwo = false;
            boolean thirdRowOfCurrentColumnIsPlayerTwo = false;
            if (firstRowOfCurrentColumn == PLAYER_TWO) {
                firstRowOfCurrentColumnIsPlayerTwo = true;
            }
            else {
                firstRowOfCurrentColumnIsPlayerTwo = false;
            }

            if (firstRowOfCurrentColumnIsPlayerTwo == true) {
                if (secondRowOfCurrentColumn == PLAYER_TWO)
                    secondRowOfCurrentColumnIsPlayerTwo = true;
                else
                    secondRowOfCurrentColumnIsPlayerTwo = false;
            }
            else {
                secondRowOfCurrentColumnIsPlayerTwo = false;
            }

            if (secondRowOfCurrentColumnIsPlayerTwo == true) {
                if (thirdRowOfCurrentColumn == PLAYER_TWO)
                    thirdRowOfCurrentColumnIsPlayerTwo = true;
                else
                    thirdRowOfCurrentColumnIsPlayerTwo = false;
            }
            else {
                thirdRowOfCurrentColumnIsPlayerTwo = false;
            }

            if (firstRowOfCurrentColumnIsPlayerTwo == true) {
                if (secondRowOfCurrentColumnIsPlayerTwo == true) {
                    if (thirdRowOfCurrentColumnIsPlayerTwo == true)
                        return PLAYER_TWO;
                }
            }
        }

        int firstTileOfDiagonal1 = game[0][0];
        int secondTileOfDiagonal1 = game[1][1];
        int thirdTileOfDiagonal1 = game[2][2];
        boolean firstTileOfDiagonal1IsPlayerOne = false;
        boolean secondTileOfDiagonal1IsPlayerOne = false;
        boolean thirdTileOfDiagonal1IsPlayerOne = false;

        // Check one of the diagonals if player one is the winner
        // 1|_|_
        // _|1|_
        //  | |1
        if (firstTileOfDiagonal1 == PLAYER_ONE) {
            firstTileOfDiagonal1IsPlayerOne = true;
        }
        else {
            firstTileOfDiagonal1IsPlayerOne = false;
        }

        if (firstTileOfDiagonal1IsPlayerOne == true) {
            if (secondTileOfDiagonal1 == PLAYER_ONE)
                secondTileOfDiagonal1IsPlayerOne = true;
            else
                secondTileOfDiagonal1IsPlayerOne = false;
        }
        else {
            secondTileOfDiagonal1IsPlayerOne = false;
        }

        if (secondTileOfDiagonal1IsPlayerOne == true) {
            if (thirdTileOfDiagonal1 == PLAYER_ONE)
                thirdTileOfDiagonal1IsPlayerOne = true;
            else
                thirdTileOfDiagonal1IsPlayerOne = false;
        }
        else {
            thirdTileOfDiagonal1IsPlayerOne = false;
        }

        if (firstTileOfDiagonal1IsPlayerOne == true) {
            if (secondTileOfDiagonal1IsPlayerOne == true) {
                if (thirdTileOfDiagonal1IsPlayerOne == true)
                    return PLAYER_ONE;
            }
        }

        // Check one of the diagonals if player one is the winner
        // 2|_|_
        // _|2|_
        //  | |2
        boolean firstTileOfDiagonal1IsPlayerTwo = false;
        boolean secondTileOfDiagonal1IsPlayerTwo = false;
        boolean thirdTileOfDiagonal1IsPlayerTwo = false;
        if (firstTileOfDiagonal1 == PLAYER_TWO) {
            firstTileOfDiagonal1IsPlayerTwo = true;
        }
        else {
            firstTileOfDiagonal1IsPlayerTwo = false;
        }

        if (firstTileOfDiagonal1IsPlayerTwo == true) {
            if (secondTileOfDiagonal1 == PLAYER_TWO)
                secondTileOfDiagonal1IsPlayerTwo = true;
            else
                secondTileOfDiagonal1IsPlayerTwo = false;
        }
        else {
            secondTileOfDiagonal1IsPlayerTwo = false;
        }

        if (secondTileOfDiagonal1IsPlayerTwo == true) {
            if (thirdTileOfDiagonal1 == PLAYER_TWO)
                thirdTileOfDiagonal1IsPlayerTwo = true;
            else
                thirdTileOfDiagonal1IsPlayerTwo = false;
        }
        else {
            thirdTileOfDiagonal1IsPlayerTwo = false;
        }

        if (firstTileOfDiagonal1IsPlayerTwo == true) {
            if (secondTileOfDiagonal1IsPlayerTwo == true) {
                if (thirdTileOfDiagonal1IsPlayerTwo == true)
                    return PLAYER_TWO;
            }
        }


        int firstTileOfDiagonal2 = game[2][0];
        int secondTileOfDiagonal2 = game[1][1];
        int thirdTileOfDiagonal2 = game[0][2];
        boolean firstTileOfDiagonal2IsPlayerOne = false;
        boolean secondTileOfDiagonal2IsPlayerOne = false;
        boolean thirdTileOfDiagonal2IsPlayerOne = false;

        // Check the other diagonal if player one is the winner
        // _|_|1
        // _|1|_
        // 1| |
        if (firstTileOfDiagonal2 == PLAYER_ONE) {
            firstTileOfDiagonal2IsPlayerOne = true;
        }
        else {
            firstTileOfDiagonal2IsPlayerOne = false;
        }

        if (firstTileOfDiagonal2IsPlayerOne == true) {
            if (secondTileOfDiagonal2 == PLAYER_ONE)
                secondTileOfDiagonal2IsPlayerOne = true;
            else
                secondTileOfDiagonal2IsPlayerOne = false;
        }
        else
        {
            secondTileOfDiagonal2IsPlayerOne = false;
        }

        if (secondTileOfDiagonal2IsPlayerOne == true) {
            if (thirdTileOfDiagonal2 == PLAYER_ONE)
                thirdTileOfDiagonal2IsPlayerOne = true;
            else
                thirdTileOfDiagonal2IsPlayerOne = false;
        }
        else {
            thirdTileOfDiagonal2IsPlayerOne = false;
        }

        if (firstTileOfDiagonal2IsPlayerOne == true) {
            if (secondTileOfDiagonal2IsPlayerOne == true) {
                if (thirdTileOfDiagonal2IsPlayerOne == true)
                    return PLAYER_ONE;
            }
        }

        boolean firstTileOfDiagonal2IsPlayerTwo = false;
        boolean secondTileOfDiagonal2IsPlayerTwo = false;
        boolean thirdTileOfDiagonal2IsPlayerTwo = false;

        // Check the other diagonal if player one is the winner
        // _|_|2
        // _|2|_
        // 2| |
        if (firstTileOfDiagonal2 == PLAYER_TWO) {
            firstTileOfDiagonal2IsPlayerTwo = true;
        }
        else {
            firstTileOfDiagonal2IsPlayerTwo = false;
        }

        if (firstTileOfDiagonal2IsPlayerTwo == true) {
            if (secondTileOfDiagonal2 == PLAYER_TWO)
                secondTileOfDiagonal2IsPlayerTwo = true;
            else
                secondTileOfDiagonal2IsPlayerTwo = false;
        }
        else {
            secondTileOfDiagonal2IsPlayerTwo = false;
        }

        if (secondTileOfDiagonal2IsPlayerTwo == true) {
            if (thirdTileOfDiagonal2 == PLAYER_TWO)
                thirdTileOfDiagonal2IsPlayerTwo = true;
            else
                thirdTileOfDiagonal2IsPlayerTwo = false;
        }
        else {
            thirdTileOfDiagonal2IsPlayerTwo = false;
        }

        if (firstTileOfDiagonal2IsPlayerTwo == true) {
            if (secondTileOfDiagonal2IsPlayerTwo == true) {
                if (thirdTileOfDiagonal2IsPlayerTwo == true)
                    return PLAYER_TWO;
            }
        }
        return 0;
    }

    public boolean cannotPlay() {
        boolean result = true;
        for (int row = 0; row < SIDE; row++) {
            for (int col = 0; col < SIDE; col++) {
                if (game[row][col] == 0)
                    result = false;
            }
        }
        return result;
    }

    // gameOver - A function to determine if the game is over
    // @return boolean - Returns true if the game is over, false otherwise
    public boolean gameOver()
    {
        if (whoWon() > 0) {
            return true;
        }
        if (cannotPlay() == true)
            return true;
        else
            return false;
    }

    // resetGame - Clears the board and sets turn to 1
    public void resetGame()
    {
        for (int row = 0; row < SIDE; row++) {
            for (int col = 0; col < SIDE; col++) {
                game[row][col] = 0;
            }
        }
        turn = 1;
    }
}