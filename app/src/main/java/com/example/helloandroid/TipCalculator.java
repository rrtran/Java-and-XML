package com.example.helloandroid;

public class TipCalculator {
    private float bill;
    private float tip;

    // TipCalculator - Initializes the members variables, bill and tip
    public TipCalculator(float newTip, float newBill) {
        setBill(newBill);
        setTip(newTip);
    }

    // getTip - returns the tip
    // @return float - the tip
    public float getTip() {
        return tip;
    }

    // getBill - returns the bill
    // @return float - the bill
    public float getBill() {
        return bill;
    }

    // setTip - assigns a new tip to the tip member variable
    // @param float - the new tip
    public void setTip(float newTip) {
        if (newTip > 0)
            tip = newTip;
    }

    // setBill - assigns a new bill to the bill member variable
    // @param float - the new bill
    public void setBill(float newBill) {
        if (newBill > 0)
            bill = newBill;
    }

    // tipAmount - computes the tip by multiplying the bill and tip percent
    // @return float - the amount to tip
    public float tipAmount() {
        return bill * tip;
    }

    // totalAmount - returns the bill plus tip amount
    // @return float - the bill plus tip amount
    public float totalAmount() {
        return bill + tipAmount();
    }
}
