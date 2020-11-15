package com.kata;

/**
 * @author sunjing
 */
public final class Unit {

    public static Unit Inch  = new Unit("Inch", 1);
    public static Unit Foot  = new Unit("Foot", 12);
    public static Unit Yard  = new Unit("Yard", 36);

    private final String text;

    private final int transferRateToInch;

    private Unit(String text, int transferRateToInch) {
        this.text = text;
        this.transferRateToInch = transferRateToInch;
    }

    int getAmountInInch(int amount) {
        return amount * transferRateToInch;
    }

    public String toString(int amount) {
        return String.format("%d (%s)", amount, text);
    }
}
