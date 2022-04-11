package com.example.helloandroid;

import java.text.DecimalFormat;

public class Mortgage {
    private final DecimalFormat MONEY = new DecimalFormat("$#,##0.00");
    private float amount;
    private int years;
    private float rate;

    // Mortgage - Default constructor
    public Mortgage() {
        setAmount(100000.0f);
        setYears(30);
        setRate(0.035f);
    }

    // setAmount - assigns an amount ot the member variable called amount
    // @param float - the amount
    public void setAmount(float amount) {
        if (amount >= 0)
            this.amount = amount;
    }

    // setYears - assigns a year to the years member variable
    // @param int - the number of years
    public void setYears(int years) {
        if (years >= 0)
            this.years = years;
    }

    // setRate - assigns a rate to the rate member variable
    // @param float - the monthly interest rate
    public void setRate(float rate) {
        if (rate >= 0)
            this.rate = rate;
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

    // getRate - return the monthly interest rate
    // @return float - the monthly interest rate
    public float getRate() {
        return rate;
    }

    // monthlyPayment - get the monthly payment
    // @return float - the monthly payment
    public float monthlyPayment() {
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
