package com.example.helloandroid;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class InsertActivity extends AppCompatActivity {
    private DatabaseManager dbManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        dbManager = new DatabaseManager(this);
        setContentView(R.layout.activity_insert); // Set up the view
    }

    // insert - inserts a candy into the SQLite database
    // @param View - a button
    public void insert(View v) {
        EditText nameEditText = (EditText)findViewById(R.id.input_name); // Get a reference to the name edit text
        EditText priceEditText = (EditText)findViewById(R.id.input_price); // Get a reference to the price edit text
        String name = nameEditText.getText().toString(); // Get the candy name
        String priceString = priceEditText.getText().toString(); // Get the price

        try {
            double price = Double.parseDouble(priceString);
            Candy candy = new Candy(0, name, price);
            dbManager.insert(candy);
            Toast.makeText(this, "Candy added", Toast.LENGTH_SHORT).show();
        } catch (NumberFormatException nfe) {
            Toast.makeText(this, "Price error", Toast.LENGTH_LONG).show();
        }

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