package com.example.helloandroid;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class MainActivity3 extends AppCompatActivity {
    public static Mortgage mortgage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mortgage = new Mortgage();
        setContentView(R.layout.activity_main3);
    }

    public void onStart() {
        super.onStart();
        updateView();
    }

    public void updateView() {
        TextView amountTextView = (TextView) findViewById(R.id.amount);
        amountTextView.setText(mortgage.getFormattedAmount());
        TextView yearsTextView = (TextView) findViewById(R.id.years);
        yearsTextView.setText("" + mortgage.getYears());
        TextView rateTextView = (TextView) findViewById(R.id.rate);
        rateTextView.setText(100 * mortgage.getRate() + "%");
        TextView monthlyPaymentTextView = (TextView)findViewById(R.id.payment);
        monthlyPaymentTextView.setText(mortgage.formattedMonthlyPayment());
        TextView totalPaymentTextView = (TextView)findViewById(R.id.total);
        totalPaymentTextView.setText(mortgage.formattedTotalPayment());
    }
    public void modifyData(android.view.View v) {
        android.content.Intent myIntent = new android.content.Intent(this, DataActivity.class);
        this.startActivity(myIntent);
    }
}