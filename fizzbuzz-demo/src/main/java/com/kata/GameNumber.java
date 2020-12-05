package com.kata;

/**
 * @author sunjing
 */
public class GameNumber {

    private final int rawNumber;

    public GameNumber(int rawNumber) {
        this.rawNumber = rawNumber;
    }

    @Override
    public String toString() {
        if (isRelated(3) && isRelated(5)) {
            return "fizzbuzz";
        }

        if (isRelated(3)) {
            return "fizz";
        }

        if (isRelated(5)) {
            return "buzz";
        }

        return String.valueOf(rawNumber);
    }

    private boolean isRelated(int number) {
        return this.rawNumber % number == 0 || String.valueOf(this.rawNumber).contains(String.valueOf(number));
    }
}
