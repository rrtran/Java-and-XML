package com.example.helloandroid;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.graphics.Color;
import android.graphics.Point;
import android.os.Bundle;
import android.util.Log;
import android.view.Display;
import android.view.Gravity;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.GridLayout;
import android.widget.TextView;

public class MainActivity2 extends AppCompatActivity {
    private TicTacToe ticTacToeGame;
    private Button[][] buttons;
    private TextView status;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ticTacToeGame = new TicTacToe();
        buildGuiByCode(); // Build the GUI programatically
    }

    // buildGuiByCode - constructs the GUI with Java code
    public void buildGuiByCode() {
        // Get width of the screen
        Point size = new Point();
        WindowManager windowManager = getWindowManager();
        Display display = windowManager.getDefaultDisplay();
        display.getSize(size);
        int w = size.x / TicTacToe.SIDE; // Divide the width of the screen by 3 to use for the button size

        // Create Layout manager as a GridLayout
        GridLayout gridLayout = new GridLayout(this); // Define a GridLayout
        gridLayout.setColumnCount(TicTacToe.SIDE); // Specify the Gridlayout to have 3 rows
        gridLayout.setRowCount(TicTacToe.SIDE + 1); // Specify the Gridlayout to have 4 rows

        buttons = new Button[TicTacToe.SIDE][TicTacToe.SIDE]; // Define a 2D array with 3 rows and 3 columns
        ButtonHandler buttonHandler = new ButtonHandler(); // Define a button handler that executes the update() method when a button is clicked
        for (int row = 0; row < TicTacToe.SIDE; row++) { // Loop through each position on the Grid and add a button
            for (int column = 0; column < TicTacToe.SIDE; column++) {
                buttons[row][column] = new Button(this); // Define a new button
                buttons[row][column].setTextSize((int)(w * .2)); // Set the text size to be 1/5 the size of the button size
                buttons[row][column].setOnClickListener(buttonHandler); // Register the button handler to this button
                gridLayout.addView(buttons[row][column], w, w); // Add the button to the GridLayout
            }
        }

        status = new TextView(this); // Define the status Text View to display game state like winners or tie game
        GridLayout.Spec rowSpec = GridLayout.spec(3, 1); // Specify the rows in the Grid Layout where the status should be added
        GridLayout.Spec columnSpec = GridLayout.spec(0,3);  // Specify the columns in the Grid Layout where status should be added
        GridLayout.LayoutParams statusLayoutParams = new GridLayout.LayoutParams(rowSpec, columnSpec); // Define a GridLayout.LayoutParams with the specified row and column specifications
        status.setLayoutParams(statusLayoutParams); // Set the layout parameter for the status Text View so that when we add it to the Grid, it will be placed in row 3 and and columns 0 to 2

        // set up status' characteristics
        status.setWidth(size.x); // Set the width of status to be the width of the screen
        status.setHeight(w); // Set the height of status to be the same as the height of a button
        status.setGravity(Gravity.CENTER); // Center the contents of the status, which is the text like PLAY !!, winner and tie game
        status.setBackgroundColor(Color.GREEN); // Set the background color of status Text View to Green
        status.setTextSize((int)(w * .15)); // Set the text size to some arbitrary size
        status.setText(ticTacToeGame.result()); // Set the text to display the state of the game, which initially should be "PLAY !!"
        gridLayout.addView(status); // Add the status to the Grid Layout in the 3rd row

        setContentView(gridLayout); // Set gridLayout as the View of this Activity
    }

    // enableButtons - Enable or disable the button
    // @param boolean - A value of true will enable the buttons, and a value of false will disable the buttons
    public void enableButtons(boolean enabled) {
        for (int row = 0; row < TicTacToe.SIDE; row++) {
            for (int column = 0; column < TicTacToe.SIDE; column++) {
                buttons[row][column].setEnabled(enabled);
            }
        }
    }

    public void resetButtons() {
        for (int row = 0; row < TicTacToe.SIDE; row++) {
            for (int column = 0; column < TicTacToe.SIDE; column++)
                buttons[row][column].setText("");
        }
    }

    // update - processes a move, marks a tile with an "X" or "O", and updates the status
    // @param int - the index of the row of a move
    // @param int - the index of the column of a move
    public void update(int row, int column) {
        Log.w("MainActivity", "Inside update: " + row + ", " + column);
        int play = ticTacToeGame.play(row, column); // Make a move if allowed
        if (play == TicTacToe.PLAYER_ONE) // If player 1 moved, set the button's text to 'X'
            buttons[row][column].setText("X");
        else if (play == TicTacToe.PLAYER_TWO) // If player 2 moved, set the button's text to 'O'
            buttons[row][column].setText("O");
        else
            Log.w("MainActivity", "Inside update: move illegal");

        if (ticTacToeGame.isGameOver()) { // If game is over...
            status.setBackgroundColor(Color.RED);  // Set the background color of status to red
            enableButtons(false); // disable the buttons
            status.setText(ticTacToeGame.result()); // Display the result of the game inside status
            showNewGameDialog();
        }
    }

    // showNewGameDialog - shows a dialog where the user can choose to play the game again or quit
    public void showNewGameDialog() {
        AlertDialog.Builder alert = new AlertDialog.Builder(this); // Define an alert dialog
        alert.setTitle("This is fun"); // Set the title of the dialog
        alert.setMessage("Play again?"); // Set the message of the dialog
        PlayDialog playAgain = new PlayDialog(); // Define a PlayDialog object called playAgain
        alert.setPositiveButton("Yes", playAgain); // Set the alert dialog's okay button and pass it playAgain
        alert.setNegativeButton("No", playAgain); // Set the alert dialog's no button and pass it playAgain
        alert.show(); // show the dialog
    }

    private class PlayDialog implements DialogInterface.OnClickListener {

        @Override
        public void onClick(DialogInterface dialogInterface, int id) {
            if (id == -1) {
                ticTacToeGame.resetGame(); // Clear the board and set the turn to player 1
                enableButtons(true); // Make the buttons clickable so the game can be played
                resetButtons();
                status.setBackgroundColor(Color.GREEN); // Set the status to green
                status.setText(ticTacToeGame.result()); // Set the status to indicate the game is being played
            }
            else if (id == -2) {
                MainActivity2.this.finish(); // Close the activity
            }
        }
    }

    private class ButtonHandler implements View.OnClickListener {
        @Override
        public void onClick(View view) {
            Log.w("MainActivity", "Inside onClick, v = " + view);

            // Loop through each button on the Grid and check if any of those buttons is the button
            // that was clicked
            for (int row = 0; row < TicTacToe.SIDE; row++) { // loop through the rows
                for (int column = 0; column < TicTacToe.SIDE; column++) { // loop through the columns
                    if (view == buttons[row][column]) // Check if the button that was clicked is the button in the current iteration of the loop
                        // Once the button is found, run the update() method and pass it the matching button's row
                        // and column to perform a play and update the button text to "X" or "O",
                        // and possibly update the status Text View to state a winner or tie game,
                        // and possibly disable the buttons if the game ends on this button click
                        update(row, column);
                }
            }
        }
    }
}