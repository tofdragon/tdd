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
        if (isDivisibleOrContains(3) && isDivisibleOrContains(5)) {
            return "fizzbuzz";
        }

        if (isDivisibleOrContains(3)) {
            return "fizz";
        }

        if (isDivisibleOrContains(5)) {
            return "buzz";
        }

        return String.valueOf(raw);
    }

    private boolean isDivisibleOrContains(int number) {
        return this.raw %  number == 0 || String.valueOf(this.raw).contains(String.valueOf(number));
    }

}
