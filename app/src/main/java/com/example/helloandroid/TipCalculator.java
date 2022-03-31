package com.example.helloandroid;

public class TipCalculator {
    private float bill;
    private float tip;

    public TipCalculator(float newTip, float newBill) {
        setBill(newBill);
        setTip(newTip);
    }

    public float getTip() {
        return tip;
    }

    public float getBill() {
        return bill;
    }

    public void setTip(float newTip) {
        if (newTip > 0)
            tip = newTip;
    }

    public void setBill(float newBill) {
        if (newBill > 0)
            bill = newBill;
    }

    public float TipAmount() {
        return bill * tip;
    }

    public float totalAmount() {
        return bill + TipAmount();
    }
}
