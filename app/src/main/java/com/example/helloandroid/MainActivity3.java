package com.example.helloandroid;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class MainActivity3 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
    }

    public void modifyData(android.view.View v) {
        android.content.Intent myIntent = new android.content.Intent(this, DataActivity.class);
        this.startActivity(myIntent);
    }
}