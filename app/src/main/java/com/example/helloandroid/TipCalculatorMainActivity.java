package com.example.helloandroid;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.TextView;
import android.widget.EditText;

import java.text.NumberFormat;

public class TipCalculatorMainActivity extends AppCompatActivity {
    private TipCalculator tipCalc;
    public NumberFormat money = NumberFormat.getCurrencyInstance();
    private EditText billEditText;
    private EditText tipEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        tipCalc = new TipCalculator(0.17f, 100.0f); // Initialize a new tip calculator
        setContentView(R.layout.tip_calculator_activity_main);

        billEditText = (EditText)findViewById(R.id.amount_bill); // Get a reference to the amount bill edit box
        tipEditText = (EditText)findViewById(R.id.amount_tip_percent); // Get a reference to the amount_tip_percent edit box

        TextChangeHandler tch = new TextChangeHandler();
        billEditText.addTextChangedListener(tch); // Executes the overridden functions of the TextChangeHandler when the amount_bill edit box has characters inputted in it or deleted from it
        tipEditText.addTextChangedListener(tch); // Executes the overridden functions of the TextChangeHandler when the amount_tip_percent edit box has its character deleted or when characters are inputted

    }

    private class TextChangeHandler implements TextWatcher {

        @Override
        public void beforeTextChanged(CharSequence charSequence, int start, int count, int after) {

        }

        @Override
        public void onTextChanged(CharSequence charSequence, int start, int before, int after) {

        }

        @Override
        public void afterTextChanged(Editable editable) {
            calculate(); // After a text has been inputted or deleted, call this calculate function
        }
    }

    // calculate - computes the total amount by calculating the tip in dollars and adding it to the bill
    public void calculate() {
        EditText billEditText = (EditText) findViewById(R.id.amount_bill); // Get a reference to the amount bill edit box
        EditText tipEditText = (EditText) findViewById(R.id.amount_tip_percent); // Get a reference to the amount_tip_percent edit box
        String billString = billEditText.getText().toString(); // Get the bill and convert the value to a string
        String tipString = tipEditText.getText().toString();  // Get the tip percent and convert the value to a string
        TextView tipTextView = (TextView)findViewById(R.id.amount_tip); // Get a reference to the amount_tip text view
        TextView totalTextView = (TextView)findViewById(R.id.amount_total); // Get a reference to the amount_total text view
        try {
            float billAmount = Float.parseFloat(billString); // Parse the bill as a float
            int tipPercent = Integer.parseInt(tipString); // Parse the tip percent as an int
            //update model
            tipCalc.setBill(billAmount); // Set the tip calculator's bill member variable to billAmount
            tipCalc.setTip(0.01f * tipPercent); // Set the tipCalculator's tip percent
            float tip = tipCalc.tipAmount();    // Compute the tip and assign it to the tip float variable
            float total = tipCalc.totalAmount(); // Compute the total amount and assign it to the total float variable
            tipTextView.setText(money.format(tip)); // Display the tip in the amount_tip text view
            totalTextView.setText(money.format(total)); // Display the total amount in the amount_total text view
        } catch (NumberFormatException nfe) {

        }
    }

    // calculate - computes the total amount by calculating the tip in dollars and adding it to the bill
    // @param View - More research is needed to determine what the purpose of this parameter is, but
    //               it is required in order to be referenced in the activity_main.xml file's button's
    //               onClick attribute...
    public void calculate(View v) {
        EditText billEditText = (EditText) findViewById(R.id.amount_bill); // Get a reference to the amount bill edit box
        EditText tipEditText = (EditText) findViewById(R.id.amount_tip_percent); // Get a reference to the amount_tip_percent edit box
        String billString = billEditText.getText().toString(); // Get the bill and convert the value to a string
        String tipString = tipEditText.getText().toString();  // Get the tip percent and convert the value to a string
        TextView tipTextView = (TextView)findViewById(R.id.amount_tip); // Get a reference to the amount_tip text view
        TextView totalTextView = (TextView)findViewById(R.id.amount_total); // Get a reference to the amount_total text view
        try {
            float billAmount = Float.parseFloat(billString); // Parse the bill as a float
            int tipPercent = Integer.parseInt(tipString); // Parse the tip percent as an int
            //update model
            tipCalc.setBill(billAmount); // Set the tip calculator's bill member variable to billAmount
            tipCalc.setTip(0.01f * tipPercent); // Set the tipCalculator's tip percent
            float tip = tipCalc.tipAmount();    // Compute the tip and assign it to the tip float variable
            float total = tipCalc.totalAmount(); // Compute the total amount and assign it to the total float variable
            tipTextView.setText(money.format(tip)); // Display the tip in the amount_tip text view
            totalTextView.setText(money.format(total)); // Display the total amount in the amount_total text view
        } catch (NumberFormatException nfe) {

        }
    }
}
