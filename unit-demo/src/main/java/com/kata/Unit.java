package com.kata;

/**
 *
 * @author sunjing
 */
public class Unit {

    public static Unit Inch = new Unit("Inch", 1);
    public static Unit Foot = new Unit("Foot", 12);
    public static Unit Yard = new Unit("Yard", 36);

    public final String text;

    private final int radioAsInch;

    public Unit(String text, int radioAsInch) {
        this.text = text;
        this.radioAsInch = radioAsInch;
    }

    int getAmountAsInch(int amount) {
        return radioAsInch * amount;
    }

    public String toString(int amount) {
        return String.format("%d (%s)", amount, text);
    }
}
