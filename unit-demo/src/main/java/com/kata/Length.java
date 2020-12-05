package com.kata;

/**
 * @author sunjing
 */
public class Length {

    private final int amount;

    private final Unit unit;

    public Length(int amount, Unit unit) {
        this.amount = amount;
        this.unit = unit;
    }

    private int getAmountAsInch() {
        return unit.getAmountAsInch(amount);
    }

    @Override
    public boolean equals(Object obj) {
        Length other = (Length) obj;
        return other.getAmountAsInch() == getAmountAsInch() ;
    }

    @Override
    public String toString() {
        return unit.toString(this.amount);
    }
}
