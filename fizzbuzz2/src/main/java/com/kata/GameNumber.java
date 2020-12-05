package com.kata;

/**
 *
 * @author sunjing
 */
public class GameNumber {

    private int raw;

    public GameNumber(int raw) {
        this.raw = raw;
    }

    @Override
    public String toString() {
        if (this.raw % 3 == 0 && this.raw % 5 == 0) {
            return "fizzbuzz";
        }

        if (this.raw % 3 == 0) {
            return "fizz";
        }

        if (this.raw % 5 == 0) {
            return "buzz";
        }

        return String.valueOf(raw);
    }

}
