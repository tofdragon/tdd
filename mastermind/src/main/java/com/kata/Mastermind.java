package com.kata;

/**
 * @author sunjing
 */
public final class Mastermind {

    public String evaluate(String secret, String guess) {
        Answer rightAnswer = Answer.of(secret);
        Answer guessAnswer = Answer.of(guess);

        GuessResult guessResult = guessResult(rightAnswer, guessAnswer);
        return guessResult.wellPlaced() + "," + guessResult.misPlaced();
    }

    private GuessResult guessResult(Answer rightAnswer, Answer guessAnswer) {
        GuessResult guessResult = new GuessResult();

        rightAnswer.units().stream().forEach(current -> {
            Unit foundUnit = guessAnswer.findUnit(current);
            if (foundUnit == null) {
                return;
            }

            if (current.equals(foundUnit)) {
                guessResult.plusWellPlaced();
                return;
            }

            guessResult.plusMisPlaced();
        });

        return guessResult;
    }

}
