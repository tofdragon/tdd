package com.kata;

/**
 * @author sunjing
 */
public class GameNumber {

    private int rawNumber;

    public GameNumber(int rowNumber) {
        this.rawNumber =  rowNumber;
    }

    private boolean isRelatedTo(int denominator) {
        return rawNumber % denominator == 0 || String.valueOf(rawNumber).contains(String.valueOf(denominator));
    }

    @Override
    public String toString() {
        if (isRelatedTo(3) && isRelatedTo(5)) {
            return "fizzbuzz";
        }

        if (isRelatedTo(3)) {
            return "fizz";
        }

        if (isRelatedTo(5)) {
            return "buzz";
        }

        return String.valueOf(this.rawNumber);
    }
}
