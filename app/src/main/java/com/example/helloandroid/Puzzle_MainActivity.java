package com.example.helloandroid;

import androidx.appcompat.app.AppCompatActivity;

import android.content.res.Resources;
import android.graphics.Point;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.util.Log;
import android.util.TypedValue;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.RelativeLayout;

public class Puzzle_MainActivity extends AppCompatActivity implements View.OnTouchListener {
    private int statusBarHeight;
    private int actionBarHeight;
    private GestureDetector detector;

    public static int STATUS_BAR_HEIGHT = 24;
    public static int ACTION_BAR_HEIGHT = 56;
    private PuzzleView puzzleView;
    private Puzzle puzzle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        DoubleTapHandler doubleTapHandler = new DoubleTapHandler();
        detector = new GestureDetector(this, doubleTapHandler);
        detector.setOnDoubleTapListener(doubleTapHandler);
        puzzle = new Puzzle();

        Point size = new Point();
        getWindowManager().getDefaultDisplay().getSize(size);
        int screenHeight = size.y;
        int puzzleWidth = size.x;

        Resources res = getResources();
        DisplayMetrics metrics = res.getDisplayMetrics();
        float pixelDensity = metrics.density;

        int actionBarHeight = (int) (pixelDensity * ACTION_BAR_HEIGHT);
        TypedValue typedValue = new TypedValue();
        if (getTheme().resolveAttribute(android.R.attr.actionBarSize, typedValue, true)) {
            actionBarHeight = TypedValue.complexToDimensionPixelSize(typedValue.data, metrics);
        }

        int statusBarHeight = (int)(pixelDensity * STATUS_BAR_HEIGHT);
        int resourceId = res.getIdentifier("status_bar_height", "dimen", "android");
        if (resourceId != 0) {
            statusBarHeight = res.getDimensionPixelSize(resourceId);
        }

        int puzzleHeight = screenHeight - statusBarHeight - actionBarHeight;
        puzzleView = new PuzzleView(this, puzzleWidth, puzzleHeight, puzzle.getNumberOfParts());
        String[] scrambled = puzzle.scramble();
        puzzleView.fillGui(scrambled);
        puzzleView.enableListener(this);
        setContentView(puzzleView);
    }

    public boolean onTouchEvent(MotionEvent event) {
        detector.onTouchEvent(event);
        return true;
    }

    private class DoubleTapHandler extends GestureDetector.SimpleOnGestureListener {
        public boolean onDoubleTapEvent(MotionEvent event) {
            int touchY = (int) event.getRawY();
            int index = puzzleView.indexOfTextView(touchY - actionBarHeight - statusBarHeight);
            if (puzzleView.getTextViewText(index).equals(puzzle.wordToChange())) {
                puzzleView.setTextViewText(index, puzzle.replacementWord());
            }
            return true;
        }
    }

    @Override
    public boolean onTouch(View v, MotionEvent event) {
        int index = puzzleView.indexOfTextView(v);
        int action = event.getAction();
        switch(action) {
            case MotionEvent.ACTION_DOWN:
                puzzleView.updateStartPositions(index, (int)event.getY());
                puzzleView.bringChildToFront(v);
                break;
            case MotionEvent.ACTION_MOVE:
                puzzleView.moveTextViewVertically(index, (int)event.getY());
                break;
            case MotionEvent.ACTION_UP:
                int newPosition = puzzleView.textViewPosition(index);
                puzzleView.placeTextViewAtPosition(index, newPosition);
                if(puzzle.solved(puzzleView.currentSolution()))
                    puzzleView.disableListener();
                break;
        }
        return true;
    }
}