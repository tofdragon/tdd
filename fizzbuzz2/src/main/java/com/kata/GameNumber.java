package com.kata;

/**
 * @author sunjing
 */
public class GameNumber {

    private int rawNumber;

    public GameNumber(int rowNumber) {
        this.rawNumber =  rowNumber;
    }

    private boolean isDivisibleBy(int denominator) {
        return rawNumber % denominator == 0;
    }

    @Override
    public String toString() {
        if (isDivisibleBy(3) && isDivisibleBy(5)) {
            return "fizzbuzz";
        }

        if (isDivisibleBy(3)) {
            return "fizz";
        }

        if (isDivisibleBy(5)) {
            return "buzz";
        }

        return String.valueOf(this.rawNumber);
    }
}
