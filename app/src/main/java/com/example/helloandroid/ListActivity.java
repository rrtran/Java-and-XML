package com.example.helloandroid;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Point;
import android.os.Bundle;
import android.text.InputType;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.GridLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

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

        ScrollView scrollView = new ScrollView(this);
        GridLayout grid = new GridLayout(this);
        grid.setRowCount(4);
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

        // Mortgage
        TextView candyStoreTV = new TextView(this);
        candyStoreTV.setText("Candy Store");
        Button startCandyStoreButton = new Button(this);
        startCandyStoreButton.setText("Start");
        StartCandyStoreButtonHandler candyStoreButtonHandler = new StartCandyStoreButtonHandler();
        startCandyStoreButton.setOnClickListener(candyStoreButtonHandler);
        grid.addView(candyStoreTV, (int)(width * 0.5), ViewGroup.LayoutParams.WRAP_CONTENT);
        grid.addView(startCandyStoreButton, (int)(width * 0.5), ViewGroup.LayoutParams.WRAP_CONTENT);

        scrollView.addView(grid);
        setContentView(scrollView);
    }

    private class StartTipCalculatorButtonHandler implements View.OnClickListener {

        @Override
        public void onClick(View view) {
            Intent intent = new Intent(ListActivity.this, MainActivity.class);
            ListActivity.this.startActivity(intent);
        }
    }

    private class StartTicTacToeButtonHandler implements View.OnClickListener {

        @Override
        public void onClick(View view) {
            Intent intent = new Intent(ListActivity.this, MainActivity2.class);
            ListActivity.this.startActivity(intent);
        }
    }

    private class StartMortgageButtonHandler implements View.OnClickListener {

        @Override
        public void onClick(View view) {
            Intent intent = new Intent(ListActivity.this, MainActivity3.class);
            ListActivity.this.startActivity(intent);
        }
    }

    private class StartCandyStoreButtonHandler implements View.OnClickListener {

        @Override
        public void onClick(View view) {
            Intent intent = new Intent(ListActivity.this, MainActivity4.class);
            ListActivity.this.startActivity(intent);
        }
    }
}