package com.kata;

/**
 * @author sunjing
 */
public class GameNumber {

    private final int raw;

    public GameNumber(int raw) {
        this.raw = raw;
    }

    @Override
    public String toString() {
        if (isRelateTo(3) && isRelateTo(5)) {
            return "fizzbuzz";
        }

        if (isRelateTo(3)) {
            return "fizz";
        }

        if (isRelateTo(5)) {
            return "buzz";
        }

        return String.valueOf(raw);
    }

    private boolean isRelateTo(int number) {
        return this.raw % number == 0 || String.valueOf(this.raw).contains(String.valueOf(number));
    }

}
