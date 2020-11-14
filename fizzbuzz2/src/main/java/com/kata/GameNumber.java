package com.kata;

/**
 * @author sunjing
 */
public class GameNumber {

    private int rawNumber;

    public GameNumber(int rowNumber) {
        this.rawNumber =  rowNumber;
    }

    private boolean isDivisibleByOrContains(int denominator) {
        return rawNumber % denominator == 0 || String.valueOf(rawNumber).contains(String.valueOf(denominator));
    }

    @Override
    public String toString() {
        if (isDivisibleByOrContains(3) && isDivisibleByOrContains(5)) {
            return "fizzbuzz";
        }

        if (isDivisibleByOrContains(3)) {
            return "fizz";
        }

        if (isDivisibleByOrContains(5)) {
            return "buzz";
        }

        return String.valueOf(this.rawNumber);
    }
}
