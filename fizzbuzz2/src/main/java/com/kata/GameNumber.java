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
        if (isDivisible(3) && isDivisible(5)) {
            return "fizzbuzz";
        }

        if (isDivisible(3)) {
            return "fizz";
        }

        if (isDivisible(5)) {
            return "buzz";
        }

        return String.valueOf(raw);
    }

    private boolean isDivisible(int number) {
        return this.raw %  number == 0;
    }

}
