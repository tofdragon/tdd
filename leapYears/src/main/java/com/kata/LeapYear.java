package com.kata;

/**
 * @author sunjing
 */
public final class LeapYear {

    public boolean is(String year) {
        if (divisible400(year)) {
            return true;
        }

        if (divisible100(year) && !divisible400(year)) {
            return false;
        }

        if (divisible4(year) && !divisible100(year)) {
            return true;
        }

        if (!divisible4(year)) {
            return false;
        }

        return false;
    }

    private boolean divisible400(String year) {
        return divisibleBy(year, 400);
    }

    private boolean divisibleBy(String year, int divisibleNum) {
        return Integer.parseInt(year) % divisibleNum == 0;
    }

    private boolean divisible4(String year) {
        return divisibleBy(year, 4);
    }

    private boolean divisible100(String year) {
        return divisibleBy(year, 100);
    }
}
