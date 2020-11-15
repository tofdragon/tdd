package com.kata;

/**
 *
 * @author sunjing
 */
public final class Length {

    private final int amount;

    private final Unit unit;

    public Length(int amount, Unit unit) {
        this.amount = amount;
        this.unit = unit;
    }

    private int getAmountInInch() {
        return unit.getAmountInInch(this.amount);
    }

    @Override
    public boolean equals(Object obj) {
        Length other = (Length) obj;
        return other.getAmountInInch() == this.getAmountInInch();
    }

    @Override
    public String toString() {
        return unit.toString(this.amount);
    }
}
