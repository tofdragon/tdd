package com.kata;

public final class Student {

    public String say(int number) {
        if (isFizz(number) && isBuzz(number)) {
            return Answer.FIZZ_BUZZ.getAnswer();
        }

        if (isFizz(number)) {
            return Answer.FIZZ.getAnswer();
        }

        if (isBuzz(number)) {
            return Answer.BUZZ.getAnswer();
        }

        return String.valueOf(number);
    }

    private boolean isFizz(int number) {
        final int comparisonValue = 3;
        return divisible(number, comparisonValue) || include(number, comparisonValue);
    }

    private boolean isBuzz(int number) {
        final int comparisonValue = 5;
        return divisible(number, comparisonValue) || include(number, comparisonValue);
    }

    private boolean divisible(int targetNumber, int divisibleNumber) {
        return targetNumber % divisibleNumber == 0 ? true : false;
    }

    private boolean include(int targetNumber, int numberOfInclusions) {
        return String.valueOf(targetNumber).indexOf(String.valueOf(numberOfInclusions)) > -1;
    }
}
