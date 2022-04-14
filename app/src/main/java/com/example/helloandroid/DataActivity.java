package com.example.helloandroid;

import android.os.Bundle;
import android.widget.EditText;
import android.widget.RadioButton;

public class DataActivity extends androidx.appcompat.app.AppCompatActivity {
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity3_data); // Use the activity3_data layout for this activity
        updateView(); // Update the view with the mortgage model
    }

    public void goBack(android.view.View v) {
        updateMortgageObject();
        this.finish();
        overridePendingTransition(R.anim.fade_in_and_scale, 0);
    }

    public void updateView() {
        Mortgage mortgage = MainActivity3.mortgage; // Get a reference to the Mortgage model
        if (mortgage.getYears() == 10) { // Check the 10-year mortgage term radio button if the mortgage model has 10 as the mortgage term
            RadioButton radioButton10 = (RadioButton)findViewById(R.id.ten); // Get the "ten" radio button
            radioButton10.setChecked(true); // Mark the radio button as "checked"
        }
        else if (mortgage.getYears() == 15) { // Chekc the 15-year mortgage term radio button if the mortgage model has 15 as the mortgage term
            RadioButton radioButton15 = (RadioButton)findViewById(R.id.fifteen); // Get the "fifteen" radio button
            radioButton15.setChecked(true); // Mark the radio button as "checked"
        }
        else {
            // Do nothing because 30 is already checked by default
        }

        EditText amountEditText = (EditText)findViewById(R.id.data_amount);  // Get the data amount edit text
        amountEditText.setText("" + mortgage.getAmount()); // Assign the mortgage amount as the data amount edit text's text
        EditText rateEditText = (EditText)findViewById(R.id.data_rate); // Get the data rate edit text
        rateEditText.setText("" + mortgage.getRate()); // Assign the annual interest rate as the rate edit text's text
    }

    public void updateMortgageObject() {
        Mortgage mortgage = MainActivity3.mortgage; // Get the Mortgage reference
        RadioButton radioButton10 = (RadioButton)findViewById(R.id.ten); // Get a radio button for a 10-year mortgage term
        RadioButton radioButton15 = (RadioButton)findViewById(R.id.fifteen); // Get the radio button for a a 15-year mortgage term
        int years;
        if (radioButton10.isChecked()) { // Assign 10 to years if a 10-year mortgage term is chosen
            years = 10;
        }
        else if (radioButton15.isChecked()) { // Assign 15 to years if a 15-year mortgage term is chosen
            years = 15;
        }
        else { // Assign 30 by default
            years = 30;
        }
        mortgage.setYears(years); // Set the mortgage term in the model
        EditText amountEditText = (EditText)findViewById(R.id.data_amount); // Get the data amount edit text
        String amountString = amountEditText.getText().toString(); // Get the amount edit text's value
        EditText rateEditText = (EditText)findViewById(R.id.data_rate); // Get the rate edit text
        String rateString = rateEditText.getText().toString(); // Get the rate edit text's value
        try {
            float amount = Float.parseFloat(amountString);
            mortgage.setAmount(amount); // Assign the mortgage amount to the model
            float rate = Float.parseFloat(rateString);
            mortgage.setRate(rate); // Assign the rate to the model
            mortgage.setPreferences(this); // Store the data in the model in the file system
        } catch (NumberFormatException numberFormatException) {
            mortgage.setAmount(100000.0f);
            mortgage.setRate(0.035f);
        }
    }
}