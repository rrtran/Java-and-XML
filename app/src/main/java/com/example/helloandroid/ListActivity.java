package com.example.helloandroid;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Point;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.GridLayout;
import android.widget.ScrollView;
import android.widget.TextView;

import java.util.ArrayList;

public class ListActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        updateView();
    }

    public void updateView() {
        ArrayList<String> activities = new ArrayList<String>();
        activities.add("Tip Calculator");
        activities.add("Tic-Tac-Toe");
        activities.add("Mortgage");
        activities.add("Candy Store");
        activities.add("Orientation");
        activities.add("On Configuration Change");
        activities.add("On Configuration Change 2");

        ScrollView scrollView = new ScrollView(this);
        GridLayout grid = new GridLayout(this);
        grid.setRowCount(7);
        grid.setColumnCount(2);

        Point size = new Point();
        getWindowManager().getDefaultDisplay().getSize(size);
        int width = size.x;

        // Tip Calculator
        TextView tipCalculatorTV = new TextView(this);
        tipCalculatorTV.setText("Tip Calculator");
        Button startTipCalculatorButton = new Button(this);
        startTipCalculatorButton.setText("Start");
        StartTipCalculatorButtonHandler tipCalculatorButtonHandler = new StartTipCalculatorButtonHandler();
        startTipCalculatorButton.setOnClickListener(tipCalculatorButtonHandler);
        grid.addView(tipCalculatorTV, (int) (width * 0.5), ViewGroup.LayoutParams.WRAP_CONTENT);
        grid.addView(startTipCalculatorButton, (int) (width * 0.5), ViewGroup.LayoutParams.WRAP_CONTENT);

        // Tic-tac-toe
        TextView ticTacToeTV = new TextView(this);
        ticTacToeTV.setText("Tic-Tac-Toe");
        Button startTicTacToeButton = new Button(this);
        startTicTacToeButton.setText("Start");
        StartTicTacToeButtonHandler ticTacToeButtonHandler = new StartTicTacToeButtonHandler();
        startTicTacToeButton.setOnClickListener(ticTacToeButtonHandler);
        grid.addView(ticTacToeTV, (int)(width * 0.5), ViewGroup.LayoutParams.WRAP_CONTENT);
        grid.addView(startTicTacToeButton, (int)(width * 0.5), ViewGroup.LayoutParams.WRAP_CONTENT);

        // Mortgage
        TextView mortgageTV = new TextView(this);
        mortgageTV.setText("Mortgage");
        Button startMortgageButton = new Button(this);
        startMortgageButton.setText("Start");
        StartMortgageButtonHandler mortgageButtonHandler = new StartMortgageButtonHandler();
        startMortgageButton.setOnClickListener(mortgageButtonHandler);
        grid.addView(mortgageTV, (int)(width * 0.5), ViewGroup.LayoutParams.WRAP_CONTENT);
        grid.addView(startMortgageButton, (int)(width * 0.5), ViewGroup.LayoutParams.WRAP_CONTENT);

        // Candy Store
        TextView candyStoreTV = new TextView(this);
        candyStoreTV.setText("Candy Store");
        Button startCandyStoreButton = new Button(this);
        startCandyStoreButton.setText("Start");
        StartCandyStoreButtonHandler candyStoreButtonHandler = new StartCandyStoreButtonHandler();
        startCandyStoreButton.setOnClickListener(candyStoreButtonHandler);
        grid.addView(candyStoreTV, (int)(width * 0.5), ViewGroup.LayoutParams.WRAP_CONTENT);
        grid.addView(startCandyStoreButton, (int)(width * 0.5), ViewGroup.LayoutParams.WRAP_CONTENT);

        // Orientation
        TextView orientationTV = new TextView(this);
        orientationTV.setText("Orientation");
        Button startOrientationButton = new Button(this);
        startOrientationButton.setText("Start");
        StartOrientationButtonHandler orientationButtonHandler = new StartOrientationButtonHandler();
        startOrientationButton.setOnClickListener(orientationButtonHandler);
        grid.addView(orientationTV, (int)(width * 0.5), ViewGroup.LayoutParams.WRAP_CONTENT);
        grid.addView(startOrientationButton, (int)(width * 0.5), ViewGroup.LayoutParams.WRAP_CONTENT);

        // On configuration Change
        TextView onConfigurationChangeTV = new TextView(this);
        onConfigurationChangeTV.setText("On Configuration Change");
        Button startOnConfigurationChangeButton = new Button(this);
        startOnConfigurationChangeButton.setText("Start");
        StartOnConfigurationChangeButtonHandler onConfigurationChangeButtonHandler = new StartOnConfigurationChangeButtonHandler();
        startOnConfigurationChangeButton.setOnClickListener(onConfigurationChangeButtonHandler);
        grid.addView(onConfigurationChangeTV, (int)(width * 0.5), ViewGroup.LayoutParams.WRAP_CONTENT);
        grid.addView(startOnConfigurationChangeButton, (int)(width * 0.5), ViewGroup.LayoutParams.WRAP_CONTENT);

        // On Configuration change 2
        TextView onConfigurationChange2TV = new TextView(this);
        onConfigurationChange2TV.setText("On Configuration Change 2");
        Button startOnConfigurationChange2Button = new Button(this);
        startOnConfigurationChange2Button.setText("Start");
        StartOnConfigurationChange2ButtonHandler onConfigurationChange2ButtonHandler = new StartOnConfigurationChange2ButtonHandler();
        startOnConfigurationChange2Button.setOnClickListener(onConfigurationChange2ButtonHandler);
        grid.addView(onConfigurationChange2TV, (int)(width * 0.5), ViewGroup.LayoutParams.WRAP_CONTENT);
        grid.addView(startOnConfigurationChange2Button, (int)(width * 0.5), ViewGroup.LayoutParams.WRAP_CONTENT);

        // Puzzle
        TextView puzzleTV = new TextView(this);
        puzzleTV.setText("Puzzle");
        Button startPuzzleButton = new Button(this);
        startPuzzleButton.setText("Start");
        StartPuzzleButtonHandler puzzleButtonHandler = new StartPuzzleButtonHandler();
        startPuzzleButton.setOnClickListener(puzzleButtonHandler);
        grid.addView(puzzleTV, (int)(width * 0.5), ViewGroup.LayoutParams.WRAP_CONTENT);
        grid.addView(startPuzzleButton, (int)(width * 0.5), ViewGroup.LayoutParams.WRAP_CONTENT);

        // Cannon
        TextView cannonTV = new TextView(this);
        cannonTV.setText("Cannon");
        Button startCannonButton = new Button(this);
        startCannonButton.setText("Start");
        StartCannonButtonHandler cannonButtonHandler = new StartCannonButtonHandler();
        startCannonButton.setOnClickListener(cannonButtonHandler);
        grid.addView(cannonTV, (int)(width * 0.5), ViewGroup.LayoutParams.WRAP_CONTENT);
        grid.addView(startCannonButton, (int)(width * 0.5), ViewGroup.LayoutParams.WRAP_CONTENT);

        scrollView.addView(grid);
        setContentView(scrollView);
    }

    private class StartTipCalculatorButtonHandler implements View.OnClickListener {

        @Override
        public void onClick(View view) {
            Intent intent = new Intent(ListActivity.this, TipCalculatorMainActivity.class);
            ListActivity.this.startActivity(intent);
        }
    }

    private class StartTicTacToeButtonHandler implements View.OnClickListener {

        @Override
        public void onClick(View view) {
            Intent intent = new Intent(ListActivity.this, TicTacToeMainActivity.class);
            ListActivity.this.startActivity(intent);
        }
    }

    private class StartMortgageButtonHandler implements View.OnClickListener {

        @Override
        public void onClick(View view) {
            Intent intent = new Intent(ListActivity.this, Mortgage_MainActivity.class);
            ListActivity.this.startActivity(intent);
        }
    }

    private class StartCandyStoreButtonHandler implements View.OnClickListener {

        @Override
        public void onClick(View view) {
            Intent intent = new Intent(ListActivity.this, Candy_Store_MainActivity.class);
            ListActivity.this.startActivity(intent);
        }
    }

    private class StartOrientationButtonHandler implements View.OnClickListener {

        @Override
        public void onClick(View view) {
            Intent intent = new Intent(ListActivity.this, Orientation_MainActivity.class);
            ListActivity.this.startActivity(intent);
        }
    }

    private class StartOnConfigurationChangeButtonHandler implements View.OnClickListener {
        @Override
        public void onClick(View view) {
            Intent intent = new Intent(ListActivity.this, On_Configuration_Change_MainActivity.class);
            ListActivity.this.startActivity(intent);
        }
    }

    private class StartOnConfigurationChange2ButtonHandler implements View.OnClickListener {
        @Override
        public void onClick(View view) {
            Intent intent = new Intent(ListActivity.this, On_Configuration_Change_2_MainActivity.class);
            ListActivity.this.startActivity(intent);
        }
    }

    private class StartPuzzleButtonHandler implements View.OnClickListener {
        @Override
        public void onClick(View view) {
            Intent intent = new Intent(ListActivity.this, Puzzle_MainActivity.class);
            ListActivity.this.startActivity(intent);
        }
    }

    private class StartCannonButtonHandler implements View.OnClickListener {
        @Override
        public void onClick(View view) {
            Intent intent = new Intent(ListActivity.this, Cannon_MainActivity.class);
            ListActivity.this.startActivity(intent);
        }
    }
}