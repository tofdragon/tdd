package com.kata;

/**
 * @author sunjing
 */
final class GuessResult {

    private int wellPlaced;

    private int misPlaced;

    void plusWellPlaced() {
        wellPlaced++;
    }

    void plusMisPlaced() {
        misPlaced++;
    }

    int wellPlaced() {
        return wellPlaced;
    }

    int misPlaced() {
        return misPlaced;
    }
}
