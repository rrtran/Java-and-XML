package com.example.helloandroid;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class Mortgage_MainActivity extends AppCompatActivity {
    public static Mortgage mortgage; // Make available to other activity classes

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mortgage = new Mortgage(this); // Define Mortgage variable
        setContentView(R.layout.mortgage_activity_main); // Show the read-only view of the Mortgage app
    }

    public void onStart() {
        super.onStart();
        updateView(); // Call update view
    }

    public void updateView() {
        TextView amountTextView = (TextView) findViewById(R.id.amount); // Get the amount text view
        amountTextView.setText(mortgage.getFormattedAmount()); // Assign the formatted mortgage amount to the amount text view's text
        TextView yearsTextView = (TextView) findViewById(R.id.years); // Get the years text view
        yearsTextView.setText("" + mortgage.getYears()); // Assign the mortgage term as the years text view's text
        TextView rateTextView = (TextView) findViewById(R.id.rate); // Get the rate text view
        rateTextView.setText(100 * mortgage.getRate() + "%"); // Assign the monthly interest rate as the rate text view's text
        TextView monthlyPaymentTextView = (TextView)findViewById(R.id.payment); // Get the payment text view
        monthlyPaymentTextView.setText(mortgage.formattedMonthlyPayment());  // Assign the formatted monthly payment as the payment text view's text
        TextView totalPaymentTextView = (TextView)findViewById(R.id.total); // Get the total text view
        totalPaymentTextView.setText(mortgage.formattedTotalPayment()); // Assign the formatted total payment to pay off the loan as the total text view's text
    }
    public void modifyData(android.view.View v) {
        android.content.Intent myIntent = new android.content.Intent(this, DataActivity.class); // Specify the activity to launch
        this.startActivity(myIntent); // Launch the activity
        overridePendingTransition(R.anim.slide_from_left, 0); // Specify the transition to this view uses the R.anim.slide_from_left animation and no transition when leaving this view
    }
}