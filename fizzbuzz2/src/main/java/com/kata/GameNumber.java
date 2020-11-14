package com.kata;

/**
 * @author sunjing
 */
public class GameNumber {

    private int rawNumber;

    public GameNumber(int rowNumber) {
        this.rawNumber =  rowNumber;
    }

    @Override
    public String toString() {
        if (rawNumber % 3 == 0 && rawNumber % 5 == 0) {
            return "fizzbuzz";
        }

        if (rawNumber % 3 == 0) {
            return "fizz";
        }

        if (rawNumber % 5 == 0) {
            return "buzz";
        }

        return String.valueOf(this.rawNumber);
    }
}
