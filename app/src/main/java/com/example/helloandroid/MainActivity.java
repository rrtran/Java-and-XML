package com.example.helloandroid;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.EditText;
import android.text.TextWatcher;
import java.text.NumberFormat;

public class MainActivity extends AppCompatActivity {
    private TipCalculator tipCalc;
    public NumberFormat money = NumberFormat.getCurrencyInstance();
    private EditText billEditText;
    private EditText tipEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        tipCalc = new TipCalculator(0.17f, 100.0f);
        setContentView(R.layout.activity_main);

        billEditText = (EditText)findViewById(R.id.amount_bill);
        tipEditText = (EditText)findViewById(R.id.amount_tip_percent);

        TextChangeHandler tch = new TextChangeHandler();
        billEditText.addTextChangedListener(tch);
        tipEditText.addTextChangedListener(tch);

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
            calculate();
        }
    }

    public void calculate(View v) {
        EditText billEditText = (EditText) findViewById(R.id.amount_bill);
        EditText tipEditText = (EditText) findViewById(R.id.amount_tip_percent);
        String billString = billEditText.getText().toString();
        String tipString = tipEditText.getText().toString();
        TextView tipTextView = (TextView)findViewById(R.id.amount_tip);
        TextView totalTextView = (TextView)findViewById(R.id.amount_total);
        try {
            float billAmount = Float.parseFloat(billString);
            int tipPercent = Integer.parseInt(tipString);
            //update model
            tipCalc.setBill(billAmount);
            tipCalc.setTip(0.01f * tipPercent);
            float tip = tipCalc.tipAmount();
            float total = tipCalc.totalAmount();
            tipTextView.setText(money.format(tip));
            totalTextView.setText(money.format(total));
        } catch (NumberFormatException nfe) {

        }
    }

    public void calculate() {
        EditText billEditText = (EditText) findViewById(R.id.amount_bill);
        EditText tipEditText = (EditText) findViewById(R.id.amount_tip_percent);
        String billString = billEditText.getText().toString();
        String tipString = tipEditText.getText().toString();
        TextView tipTextView = (TextView)findViewById(R.id.amount_tip);
        TextView totalTextView = (TextView)findViewById(R.id.amount_total);
        try {
            float billAmount = Float.parseFloat(billString);
            int tipPercent = Integer.parseInt(tipString);
            //update model
            tipCalc.setBill(billAmount);
            tipCalc.setTip(0.01f * tipPercent);
            float tip = tipCalc.tipAmount();
            float total = tipCalc.totalAmount();
            tipTextView.setText(money.format(tip));
            totalTextView.setText(money.format(total));
        } catch (NumberFormatException nfe) {

        }
    }
}
