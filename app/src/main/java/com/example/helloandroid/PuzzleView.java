package com.example.helloandroid;

import android.app.Activity;
import android.graphics.Color;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class PuzzleView extends RelativeLayout {
    private TextView[] textViews;
    private RelativeLayout.LayoutParams[] params;
    private int[] colors;

    private int labelHeight;
    private int startY;
    private int startTouchY;
    private int emptyPosition;
    private int[] positions;

    public PuzzleView(Activity activity, int width, int height, int numberOfPieces) {
        super(activity);
        buildGuiByCode(activity, width, height, numberOfPieces);
    }

    public void buildGuiByCode(Activity activity, int width, int height, int numberOfPieces) {
        positions = new int[numberOfPieces];
        textViews = new TextView[numberOfPieces];
        colors = new int[textViews.length];
        params = new RelativeLayout.LayoutParams[textViews.length];
        Random random = new Random();
        labelHeight = height / numberOfPieces;
        for (int i = 0; i < textViews.length; i++) {
            textViews[i] = new TextView(activity);
            textViews[i].setGravity(Gravity.CENTER);
            colors[i] = Color.rgb(random.nextInt(255),
                    random.nextInt(255), random.nextInt(255));
            textViews[i].setBackgroundColor(colors[i]);
            params[i] = new RelativeLayout.LayoutParams(width, labelHeight);
            params[i].leftMargin = 0;
            params[i].topMargin = labelHeight * i;
            addView(textViews[i], params[i]);
        }
    }

    public void fillGui(String[] scrambledText) {
        int minFontSize = DynamicFontSizing.MAX_FONT_SIZE;
        for (int i = 0; i < textViews.length; i++) {
            textViews[i].setText(scrambledText[i]);
            positions[i] = i;

            textViews[i].setWidth(params[i].width);
            textViews[i].setPadding(20, 5, 20, 5);

            int fontSize = DynamicFontSizing.setFontSizeToFitInView(textViews[i]);
            if (minFontSize > fontSize) {
                minFontSize = fontSize;
            }
        }

        for (int i = 0; i < textViews.length; i++) {
            textViews[i].setTextSize(TypedValue.COMPLEX_UNIT_SP, minFontSize);
        }
    }

    public int indexOfTextView(View textView) {
        if (textView instanceof TextView == false) {
            return -1;
        }

        for (int i = 0; i < textViews.length; i++) {
            if (textView == textViews[i]) {
                return i;
            }
        }
        return -1;
    }

    public void updateStartPositions(int index, int y) {
        startY = params[index].topMargin;
        startTouchY = y;
        emptyPosition = textViewPosition(index);
    }

    public void moveTextViewVertically(int index, int y) {
        params[index].topMargin = startY + y - startTouchY;
        textViews[index].setLayoutParams(params[index]);
    }

    public void enableListener(View.OnTouchListener listener) {
        for (int i = 0; i < textViews.length; i++) {
            textViews[i].setOnTouchListener(listener);
        }
    }

    public void disableListener() {
        for (int i = 0; i < textViews.length; i++) {
            textViews[i].setOnTouchListener(null);
        }
    }

    public int textViewPosition(int textViewIndex) {
        return (params[textViewIndex].topMargin + labelHeight / 2) / labelHeight;
    }

    public void placeTextViewAtPosition(int textViewIndex, int toPosition) {
        params[textViewIndex].topMargin = toPosition * labelHeight;
        textViews[textViewIndex].setLayoutParams(params[textViewIndex]);

        int index = positions[toPosition];
        params[index].topMargin = emptyPosition * labelHeight;
        textViews[index].setLayoutParams(params[index]);

        positions[emptyPosition] = index;
        positions[toPosition] = textViewIndex;
    }

    public String[] currentSolution() {
        String[] current = new String[textViews.length];
        for (int i = 0; i < current.length; i++) {
            current[i] = textViews[positions[i]].getText().toString();
        }

        return current;
    }

    public int indexOfTextView(int y) {
        int position = y / labelHeight;
        return positions[position];
    }

    public String getTextViewText(int textViewIndex) {
        return textViews[textViewIndex].getText().toString();
    }

    public void setTextViewText(int textViewIndex, String s) {
        textViews[textViewIndex].setText(s);
    }
}
