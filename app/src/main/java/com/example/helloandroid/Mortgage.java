package com.example.helloandroid;

import java.text.DecimalFormat;
import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

public class Mortgage {
    private final DecimalFormat MONEY = new DecimalFormat("$#,##0.00");
    private static final String PREFERENCE_AMOUNT = "amount";
    private static final String PREFERENCE_YEARS = "years";
    private static final String PREFERENCE_RATE = "rate";

    private float amount;
    private int years;
    private float rate;

    // Mortgage - Default constructor
    public Mortgage(Context context) {
        SharedPreferences pref = PreferenceManager.getDefaultSharedPreferences(context);
        setAmount(pref.getFloat(PREFERENCE_AMOUNT, 100000.0f));
        setYears(pref.getInt(PREFERENCE_YEARS, 30));
        setRate(pref.getFloat(PREFERENCE_RATE, 0.035f));
    }

    public void setPreferences(Context context) {
        SharedPreferences pref = PreferenceManager.getDefaultSharedPreferences(context); // Get a SharedPreference reference
        SharedPreferences.Editor editor = pref.edit(); // Get a SharedPreference.Editor reference
        editor.putFloat(PREFERENCE_AMOUNT, amount); // Begin a write of the amount to the SharedPreference
        editor.putInt(PREFERENCE_YEARS, years); // Begin a write of the years to the SharedPreference
        editor.putFloat(PREFERENCE_RATE, rate); // Begin a write of the annual interest rate to the SharedPreference
        editor.commit(); // Complete the write of the values to the SharedPreference (a.k.a. the file system)
    }

    // setAmount - assigns an amount ot the member variable called amount
    // @param float - the amount
    public void setAmount(float amount) {
        if (amount >= 0) // Check that the amount is greater than or is 0
            this.amount = amount; // Assign the amount to this model
    }

    // setYears - assigns a year to the years member variable
    // @param int - the number of years
    public void setYears(int years) {
        if (years >= 0) // Check that the mortgage term is greater than or is 0
            this.years = years; // Assign the mortgage term to this model
    }

    // setRate - assigns a rate to the rate member variable
    // @param float - the monthly interest rate
    public void setRate(float rate) {
        if (rate >= 0) // Check that the annual interest rate is greater than or is 0
            this.rate = rate; // Assign the annual rate to this model
    }

    // getAmount - returns the amount
    // @return float - the amount
    public float getAmount() {
        return amount;
    }

    // getFormattedAmount - format the amount and return it
    // @return String - the formatted amount
    public String getFormattedAmount() {
        return MONEY.format(amount);
    }

    // getYears - Get the payment years
    // @return int - the number of years of the mortgage payment
    public int getYears() {
        return years;
    }

    // getRate - return the annual interest rate
    // @return float - the annual interest rate
    public float getRate() {
        return rate;
    }

    // monthlyPayment - get the monthly payment
    // @return float - the monthly payment
    public float monthlyPayment() {
        // Calculate the monthly payments with some crazy math formulas
        float mRate = rate / 12; // monthly interest rate
        double temp = Math.pow(1/(1 + mRate), years * 12);
        return amount * mRate / (float) (1 - temp);
    }

    // formattedMonthlyPayment - Format the monthly payment and return it
    // @return String - the formatted monthly payment
    public String formattedMonthlyPayment() {
        return MONEY.format(monthlyPayment());
    }

    // totalPayment - Get the total payment (of the mortgage)
    // @return float - the total payment
    public float totalPayment() {
        return monthlyPayment() * 12 * years;
    }

    // formattedTotalPayment - Get the format the total payment
    // @return String - the formatted total payment
    public String formattedTotalPayment() {
        return MONEY.format(totalPayment());
    }
}
