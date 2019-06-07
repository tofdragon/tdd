package com.kata;

import java.util.Arrays;
import java.util.List;

/**
 * @author sunjing
 */
public final class Mastermind {

    public String evaluate(String secret, String guess) {
        List<String> secrets = Arrays.asList(secret.split(","));
        List<String> guesses = Arrays.asList(guess.split(","));

        return wellPlaced(secrets, guesses) + "," + misPlaced(secrets, guesses);
    }

    private int misPlaced(List<String> secrets, List<String> guesses) {
        int misPlaced = 0;
        for (int i = 0; i < secrets.size(); i++) {
            for (int j = 0; j < guesses.size(); j++) {
                if (i == j) {
                    continue;
                }
                if (secrets.get(i).equals(guesses.get(j))) {
                    misPlaced++;
                }
            }
        }
        return misPlaced;
    }

    private int wellPlaced(List<String> secrets, List<String> guesses) {
        int wellPlaced = 0;
        for (int i = 0; i < secrets.size(); i++) {
            if (secrets.get(i).equals(guesses.get(i))) {
                wellPlaced++;
            }
        }
        return wellPlaced;
    }
}
