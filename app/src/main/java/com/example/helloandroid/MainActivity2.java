package com.example.helloandroid;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Point;
import android.os.Bundle;
import android.util.Log;
import android.view.Display;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.GridLayout;

public class MainActivity2 extends AppCompatActivity {
    private Button[][] buttons;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_main2);
        buildGuiByCode();
    }

    public void buildGuiByCode() {
        // Get width of the screen
        Point size = new Point();
        WindowManager windowManager = getWindowManager();
        Display display = windowManager.getDefaultDisplay();
        display.getSize(size);
        int w = size.x / TicTacToe.SIDE;

        // Create Layout manager as a GridLayout
        GridLayout gridLayout = new GridLayout(this);
        gridLayout.setColumnCount(TicTacToe.SIDE);
        gridLayout.setRowCount(TicTacToe.SIDE);

        buttons = new Button[TicTacToe.SIDE][TicTacToe.SIDE];
        ButtonHandler buttonHandler = new ButtonHandler();
        for (int row = 0; row < TicTacToe.SIDE; row++) {
            for (int column = 0; column < TicTacToe.SIDE; column++) {
                buttons[row][column] = new Button(this);
                buttons[row][column].setTextSize((int)(w * .2));
                buttons[row][column].setOnClickListener(buttonHandler);
                gridLayout.addView(buttons[row][column], w, w);
            }
        }

        // Set gridLayout as the View of this Activity
        setContentView(gridLayout);
    }

    public void update(int row, int column) {
        Log.w("MainActivity", "Inside update: " + row + ", " + column);
        buttons[row][column].setText("X");
    }
    private class ButtonHandler implements View.OnClickListener {
        @Override
        public void onClick(View view) {
            Log.w("MainActivity", "Inside onClick, v = " + view);
            for (int row = 0; row < TicTacToe.SIDE; row++) {
                for (int column = 0; column < TicTacToe.SIDE; column++) {
                    if (view == buttons[row][column])
                        update(row, column);
                }
            }
        }
    }
}