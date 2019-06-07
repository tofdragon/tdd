package com.kata;

/**
 * @author sunjing
 */
public final class Mastermind {

    public String evaluate(String secret, String guess) {
        Answer rightAnswer = Answer.of(secret);
        Answer guessAnswer = Answer.of(guess);

        return rightAnswer.wellPlaced(guessAnswer) + "," + rightAnswer.misPlaced(guessAnswer);
    }
}
