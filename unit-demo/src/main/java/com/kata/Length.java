package com.kata;

/**
 *
 * @author sunjing
 */
public class Length {

    private int amountInInch;

    private int amount;

    private String unit;

    public Length(int amount, String unit) {
        this.amount = amount;
        this.unit = unit;
        if (unit.equals("Foot")) {
            this.amountInInch = amount * 12;
        } else if (unit.equals("Yard")) {
            this.amountInInch = amount * 36;
        } else {
            this.amountInInch = amount;
        }
    }

    @Override
    public boolean equals(Object obj) {
        return ((Length)obj).amountInInch == this.amountInInch;
    }

    @Override
    public String toString() {
        return String.format("%d (%s)", this.amount, this.unit);
    }
}
