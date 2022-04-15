package com.example.helloandroid;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class InsertActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_insert); // Set up the view
    }

    // insert - inserts a candy into the SQLite database
    // @param View - a button
    public void insert(View v) {
        EditText nameEditText = (EditText)findViewById(R.id.input_name); // Get a reference to the name edit text
        EditText priceEditText = (EditText)findViewById(R.id.input_price); // Get a reference to the price edit text
        String name = nameEditText.getText().toString(); // Get the candy name
        String priceString = priceEditText.getText().toString(); // Get the price

        // TODO: Insert new candy into database

        // clear data
        nameEditText.setText("");
        priceEditText.setText("");
    }

    // goBack - terminates this activity
    // @param View - a button
    public void goBack(View v) {
        this.finish(); // End this activity
    }
}