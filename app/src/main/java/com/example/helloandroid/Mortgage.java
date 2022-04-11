package com.example.helloandroid;

import java.text.DecimalFormat;

public class Mortgage {
    private final DecimalFormat MONEY = new DecimalFormat("$#,##0.00");
    private float amount;
    private int years;
    private float rate;

    public Mortgage() {
        setAmount(100000.0f);
        setYears(30);
        setRate(0.035f);
    }

    // Mutators
    public void setAmount(float amount) {
        if (amount >= 0)
            this.amount = amount;
    }

    public void setYears(int years) {
        if (years >= 0)
            this.years = years;
    }

    public void setRate(float rate) {
        if (rate >= 0)
            this.rate = rate;
    }

    public float getAmount() {
        return amount;
    }
    // Accessors
    public String getFormattedAmount() {
        return MONEY.format(amount);
    }

    public int getYears() {
        return years;
    }

    public float getRate() {
        return rate;
    }

    public float monthlyPayment() {
        float mRate = rate / 12; // monthly interest rate
        double temp = Math.pow(1/(1 + mRate), years * 12);
        return amount * mRate / (float) (1 - temp);
    }

    public String formattedMonthlyPayment() {
        return MONEY.format(monthlyPayment());
    }

    public float totalPayment() {
        return monthlyPayment() * years * 12;
    }

    public String formattedTotalPayment() {
        return MONEY.format(totalPayment());
    }
}
