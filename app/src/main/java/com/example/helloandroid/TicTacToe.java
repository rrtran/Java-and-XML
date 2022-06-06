package com.example.helloandroid;

import com.example.datastructures.SinglyLinkedList;

public class TicTacToe {
    public static final int SIDE = 3;
    private int[][] game;
    private int turn;
    public SinglyLinkedList rows;
    public SinglyLinkedList columns;
    static final int PLAYER_ONE = 1;
    static final int PLAYER_TWO = 2;

    // TicTacToe - initializes the game board and calls the resetGame() function
    public TicTacToe()
    {
        rows = new SinglyLinkedList();
        columns = new SinglyLinkedList();
        game = new int[SIDE][SIDE]; // Initialize a 2D array representing the game board
        resetGame(); // Clears the board and sets the turn to player 1
    }

    // play - Marks an empty spot if the move is legal
    // @param int - the row index
    // @param int - the column index
    // @return int - the old value of turn
    public int play(int row, int column)
    {
        // Get the status of whether the row is on the board or off the board
        boolean rowIndexWithinRange = false;
        if (0 <= row) {
            if (row < SIDE)
                rowIndexWithinRange = true;
            else
                return 0;
        }
        else {
            return 0;
        }

        // Get the status of whether column on the board or off the board
        boolean columnIndexWithinRange = false;
        if (0 <= column) {
            if (column < SIDE)
                columnIndexWithinRange = true;
            else
                return 0;
        }
        else {
            return 0;
        }

        // Get the status of the move legality by checking if the row and column of the move
        // is on the board or not and whether the tile at row and column is clear
        boolean moveLegalityState = false;
        if (rowIndexWithinRange == true) {
            if (columnIndexWithinRange == true) {
                if (game[row][column] == 0) // the move is legal if the tile is clear
                    moveLegalityState = true;
            }
            else {
                return 0;
            }
        }
        else {
            return 0;
        }

        // Check if the move is legal, and if it is, mark the tile at row and column with the player number
        int currentTurn = turn;
        if (moveLegalityState == true) {
            game[row][column] = turn;
            if (turn == 1) turn = 2;
            else turn = 1;

            rows.insertBack(row);
            columns.insertBack(column);

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
        // Check each of the 3 rows if the first player is the winner or the second player is the winner
        for (int row = 0; row < SIDE; row++) {
            int firstColumnOfCurrentRow = game[row][0]; // Current row, first column
            int secondColumnOfCurrentRow = game[row][1]; // Current row, second column
            int thirdColumnOfCurrentRow = game[row][2]; // Current row, third column
            boolean firstColumnIsPlayerOne = false;
            boolean secondColumnIsPlayerOne = false;
            boolean thirdColumnIsPlayerOne = false;

            // Get the status of whether player 1 marked the tile at the first column of the current row
            if (firstColumnOfCurrentRow == PLAYER_ONE) {
                firstColumnIsPlayerOne = true;
            }
            else {
                firstColumnIsPlayerOne = false;
            }

            // Get the status of whether player 1 marked the tile at the second column of the current row
            if (firstColumnIsPlayerOne == true) {
                if (secondColumnOfCurrentRow == PLAYER_ONE)
                    secondColumnIsPlayerOne = true;
                else
                    secondColumnIsPlayerOne = false;
            }
            else {
                secondColumnIsPlayerOne = false;
            }

            // Get the status of whether player 1 marked the tile at the third column of the current row
            if (secondColumnIsPlayerOne == true) {
                if (thirdColumnOfCurrentRow == PLAYER_ONE)
                    thirdColumnIsPlayerOne = true;
                else
                    thirdColumnIsPlayerOne = false;
            }
            else {
                thirdColumnIsPlayerOne = false;
            }

            // Check if the first, second, and third columns of the current row is marked by player 1,
            // and return player 1's number in order to process that player 1 is the winner
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
            // Get the status of whether the first column of the current row is marked by player two
            if (firstColumnOfCurrentRow == PLAYER_TWO) {
                firstColumnIsPlayerTwo = true;
            }
            else {
                firstColumnIsPlayerTwo = false;
            }

            // Get the status of whether the second column of the current row is marked by player two
            if (firstColumnIsPlayerTwo == true) {
                if (secondColumnOfCurrentRow == PLAYER_TWO)
                    secondColumnIsPlayerTwo = true;
                else
                    secondColumnIsPlayerTwo = false;
            }
            else {
                secondColumnIsPlayerTwo = false;
            }

            // Get the status of whether the third column of the current row is marked by player two
            if (secondColumnIsPlayerTwo == true) {
                if (thirdColumnOfCurrentRow == PLAYER_TWO)
                    thirdColumnIsPlayerTwo = true;
                else
                    thirdColumnIsPlayerTwo = false;
            }
            else {
                thirdColumnIsPlayerTwo = false;
            }

            // Check if the first, second, and third column of the current row is marked by player two,
            // and return player two's number to process that player two is the winner
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

            // Get the player one's status on the first row of the current column
            if (firstRowOfCurrentColumn == PLAYER_ONE) {
                firstRowOfCurrentColumnIsPlayerOne = true;
            }
            else {
                firstRowOfCurrentColumnIsPlayerOne = false;
            }

            // Get player one's status on the second row of the current column
            if (firstRowOfCurrentColumnIsPlayerOne == true) {
                if (secondRowOfCurrentColumn == PLAYER_ONE)
                    secondRowOfCurrentColumnIsPlayerOne = true;
                else
                    secondRowOfCurrentColumnIsPlayerOne = false;
            }
            else {
                secondRowOfCurrentColumnIsPlayerOne = false;
            }

            // Get player one's status on the third row of the current column
            if (secondRowOfCurrentColumnIsPlayerOne = true) {
                if (thirdRowOfCurrentColumn == PLAYER_ONE)
                    thirdRowOfCurrentColumnIsPlayerOne = true;
                else
                    thirdRowOfCurrentColumnIsPlayerOne = false;
            }
            else {
                thirdRowOfCurrentColumnIsPlayerOne = false;
            }

            // Check the player one's status on the first, second, and third row of the current column,
            // and return player one's number if player one marked the tile
            if (firstRowOfCurrentColumnIsPlayerOne == true) {
                if (secondRowOfCurrentColumnIsPlayerOne == true) {
                    if (thirdRowOfCurrentColumnIsPlayerOne == true)
                        return PLAYER_ONE;
                }
            }

            boolean firstRowOfCurrentColumnIsPlayerTwo = false;
            boolean secondRowOfCurrentColumnIsPlayerTwo = false;
            boolean thirdRowOfCurrentColumnIsPlayerTwo = false;

            // Get player two's status on the first row of the current column
            if (firstRowOfCurrentColumn == PLAYER_TWO) {
                firstRowOfCurrentColumnIsPlayerTwo = true;
            }
            else {
                firstRowOfCurrentColumnIsPlayerTwo = false;
            }

            // Get player two's status on the second row of the current column
            if (firstRowOfCurrentColumnIsPlayerTwo == true) {
                if (secondRowOfCurrentColumn == PLAYER_TWO)
                    secondRowOfCurrentColumnIsPlayerTwo = true;
                else
                    secondRowOfCurrentColumnIsPlayerTwo = false;
            }
            else {
                secondRowOfCurrentColumnIsPlayerTwo = false;
            }

            // Get player two's status on the third row of the current column
            if (secondRowOfCurrentColumnIsPlayerTwo == true) {
                if (thirdRowOfCurrentColumn == PLAYER_TWO)
                    thirdRowOfCurrentColumnIsPlayerTwo = true;
                else
                    thirdRowOfCurrentColumnIsPlayerTwo = false;
            }
            else {
                thirdRowOfCurrentColumnIsPlayerTwo = false;
            }

            // Check the status of the first, second, and third row of the current column to see if player two marked it,
            // and if player two marked all 3 spots, return player two's number
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

        // Check one of the diagonals if player one is the winner
        // 1|_|_
        // _|1|_
        //  | |1
        boolean firstTileOfDiagonal1IsPlayerOne = false;
        boolean secondTileOfDiagonal1IsPlayerOne = false;
        boolean thirdTileOfDiagonal1IsPlayerOne = false;

        // Get player one's status on the first row and first column
        if (firstTileOfDiagonal1 == PLAYER_ONE) {
            firstTileOfDiagonal1IsPlayerOne = true;
        }
        else {
            firstTileOfDiagonal1IsPlayerOne = false;
        }

        // Get player one's status on the second row and second column
        if (firstTileOfDiagonal1IsPlayerOne == true) {
            if (secondTileOfDiagonal1 == PLAYER_ONE)
                secondTileOfDiagonal1IsPlayerOne = true;
            else
                secondTileOfDiagonal1IsPlayerOne = false;
        }
        else {
            secondTileOfDiagonal1IsPlayerOne = false;
        }

        // Get player one's status on the third row and third column
        if (secondTileOfDiagonal1IsPlayerOne == true) {
            if (thirdTileOfDiagonal1 == PLAYER_ONE)
                thirdTileOfDiagonal1IsPlayerOne = true;
            else
                thirdTileOfDiagonal1IsPlayerOne = false;
        }
        else {
            thirdTileOfDiagonal1IsPlayerOne = false;
        }

        // Check if the first row and first column is marked by player one,
        // the second row and second column is marked by player one,
        // the third row and third column is marked by player one,
        // and then return player one's number if the entire diagonal is marked by player one
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

        // Check player two's status on the tile at first row and first column
        if (firstTileOfDiagonal1 == PLAYER_TWO) {
            firstTileOfDiagonal1IsPlayerTwo = true;
        }
        else {
            firstTileOfDiagonal1IsPlayerTwo = false;
        }

        // Check player two's status on the tile at second row and second column
        if (firstTileOfDiagonal1IsPlayerTwo == true) {
            if (secondTileOfDiagonal1 == PLAYER_TWO)
                secondTileOfDiagonal1IsPlayerTwo = true;
            else
                secondTileOfDiagonal1IsPlayerTwo = false;
        }
        else {
            secondTileOfDiagonal1IsPlayerTwo = false;
        }

        // Check player two's status on the tile at the third row and third column
        if (secondTileOfDiagonal1IsPlayerTwo == true) {
            if (thirdTileOfDiagonal1 == PLAYER_TWO)
                thirdTileOfDiagonal1IsPlayerTwo = true;
            else
                thirdTileOfDiagonal1IsPlayerTwo = false;
        }
        else {
            thirdTileOfDiagonal1IsPlayerTwo = false;
        }

        // Check if the first row and first column is marked by player two,
        // the second row and second column is marked by player two,
        // and the third row and third column is marked by player two
        // and return player two's number if the entire diagonal is marked by player two
        if (firstTileOfDiagonal1IsPlayerTwo == true) {
            if (secondTileOfDiagonal1IsPlayerTwo == true) {
                if (thirdTileOfDiagonal1IsPlayerTwo == true)
                    return PLAYER_TWO;
            }
        }


        int firstTileOfDiagonal2 = game[2][0];
        int secondTileOfDiagonal2 = game[1][1];
        int thirdTileOfDiagonal2 = game[0][2];

        // Check the other diagonal if player one is the winner
        // _|_|1
        // _|1|_
        // 1| |
        boolean firstTileOfDiagonal2IsPlayerOne = false;
        boolean secondTileOfDiagonal2IsPlayerOne = false;
        boolean thirdTileOfDiagonal2IsPlayerOne = false;

        // Get player one's status on the tile at the third row and first column
        if (firstTileOfDiagonal2 == PLAYER_ONE) {
            firstTileOfDiagonal2IsPlayerOne = true;
        }
        else {
            firstTileOfDiagonal2IsPlayerOne = false;
        }

        // Get player one's status on the tile at the second row and second column
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

        // Get player one's status on the tile at the first row and third column
        if (secondTileOfDiagonal2IsPlayerOne == true) {
            if (thirdTileOfDiagonal2 == PLAYER_ONE)
                thirdTileOfDiagonal2IsPlayerOne = true;
            else
                thirdTileOfDiagonal2IsPlayerOne = false;
        }
        else {
            thirdTileOfDiagonal2IsPlayerOne = false;
        }

        // Check if the third row and first column is marked by player one,
        // the second row and second column is marked by player one,
        // the first row and third column is marked by player two,
        // and return player one's number if the entire diagonal is marked by player one
        if (firstTileOfDiagonal2IsPlayerOne == true) {
            if (secondTileOfDiagonal2IsPlayerOne == true) {
                if (thirdTileOfDiagonal2IsPlayerOne == true)
                    return PLAYER_ONE;
            }
        }

        // Check the other diagonal if player one is the winner
        // _|_|2
        // _|2|_
        // 2| |
        boolean firstTileOfDiagonal2IsPlayerTwo = false;
        boolean secondTileOfDiagonal2IsPlayerTwo = false;
        boolean thirdTileOfDiagonal2IsPlayerTwo = false;

        // Get player two's status on the tile at the third row and first column
        if (firstTileOfDiagonal2 == PLAYER_TWO) {
            firstTileOfDiagonal2IsPlayerTwo = true;
        }
        else {
            firstTileOfDiagonal2IsPlayerTwo = false;
        }

        // Get player two's status on the tile at the second row and second column
        if (firstTileOfDiagonal2IsPlayerTwo == true) {
            if (secondTileOfDiagonal2 == PLAYER_TWO)
                secondTileOfDiagonal2IsPlayerTwo = true;
            else
                secondTileOfDiagonal2IsPlayerTwo = false;
        }
        else {
            secondTileOfDiagonal2IsPlayerTwo = false;
        }

        // Get player two's status on the tile at the first row and third column
        if (secondTileOfDiagonal2IsPlayerTwo == true) {
            if (thirdTileOfDiagonal2 == PLAYER_TWO)
                thirdTileOfDiagonal2IsPlayerTwo = true;
            else
                thirdTileOfDiagonal2IsPlayerTwo = false;
        }
        else {
            thirdTileOfDiagonal2IsPlayerTwo = false;
        }

        // Check player two's status if the diagonal at the third row and first column, second row and second column,
        // first row and third column is marked by player two,
        // and return player two's number if it is
        if (firstTileOfDiagonal2IsPlayerTwo == true) {
            if (secondTileOfDiagonal2IsPlayerTwo == true) {
                if (thirdTileOfDiagonal2IsPlayerTwo == true)
                    return PLAYER_TWO;
            }
        }
        return 0;
    }

    public boolean cannotPlay() {
        boolean result = true; // Make an initial assumption that the game cannot be played
        // Loop through the board
        for (int row = 0; row < SIDE; row++) {
            for (int col = 0; col < SIDE; col++) {
                if (game[row][col] == 0) // If we find an empty board tile, that means the game can still be played
                    result = false; // Set the results to false to indicate the game can still be played
            }
        }
        return result;
    }

    // gameOver - A function to determine if the game is over
    // @return boolean - Returns true if the game is over, false otherwise
    public boolean isGameOver()
    {
        // If we have a winner, then the game is over
        if (whoWon() > 0)
            return true;

        // If the game board is completely filled, then the game is over
        if (cannotPlay() == true) {
            return true;
        }

        // The game is not over
        return false;
    }

    // resetGame - Clears the board and sets turn to 1
    public void resetGame()
    {
        // Loop through the board
        for (int row = 0; row < SIDE; row++) { // Loop through the rows of the board
            for (int col = 0; col < SIDE; col++) { // Loop through the rows of the column
                game[row][col] = 0; // Clears the board
            }
        }
        turn = 1; // Sets turn to 1
    }

    // result - the status of the game as a string
    // @return string - the status of the game
    public String result() {
        if (whoWon() > 0)
            return "Player " + whoWon() + " won";
        else if (cannotPlay())
            return "Tie Game";
        else
            return "PLAY !!";
    }
}