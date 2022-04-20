package com.example.helloandroid;

import android.content.Context;
import android.widget.Button;

public class CandyButton extends Button {
    private Candy candy;
    public CandyButton(Context context, Candy candy) {
        super(context);
        this.candy = candy;
    }

    public double getPrice() {
        return candy.getPrice();
    }
}
