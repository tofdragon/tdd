package com.kata;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author sunjing
 */
public class BowlingGameTest {

    @Test
    public void should_total_score_is_zero_when_no_down_every_frame() {
        BowlingGame game = new BowlingGame();

        Turns turns = new Turns();
        for (int i = 0; i < 10; i++) {
            turns.addTurn(rollsOfFrame("-", "-"));
        }

        assertEquals(0, game.totalScore(turns));
    }

    @Test
    public void should_total_score_is_90_when_no_all_down_every_frame() {
        BowlingGame game = new BowlingGame();

        Turns turns = new Turns();
        for (int i = 0; i < 10; i++) {
            turns.addTurn(rollsOfFrame("9", "-"));
        }

        assertEquals(90, game.totalScore(turns));
    }

    @Test
    public void should_total_score_is_20_when_no_all_down_every_frame() {
        BowlingGame game = new BowlingGame();

        Turns turns = new Turns();
        for (int i = 0; i < 10; i++) {
            turns.addTurn(rollsOfFrame("1", "1"));
        }

        assertEquals(20, game.totalScore(turns));
    }

    @Test
    public void should_total_score_is_46_when_no_all_down_every_frame() {
        BowlingGame game = new BowlingGame();

        Turns turns = new Turns();

        turns.addTurn(rollsOfFrame("8", "-"));
        turns.addTurn(rollsOfFrame("7", "-"));
        turns.addTurn(rollsOfFrame("6", "-"));
        turns.addTurn(rollsOfFrame("5", "-"));
        turns.addTurn(rollsOfFrame("4", "-"));
        turns.addTurn(rollsOfFrame("3", "-"));
        turns.addTurn(rollsOfFrame("2", "-"));
        turns.addTurn(rollsOfFrame("1", "-"));
        turns.addTurn(rollsOfFrame("5", "-"));
        turns.addTurn(rollsOfFrame("5", "-"));


        assertEquals(46, game.totalScore(turns));
    }

    @Test
    public void should_total_score_is_45_when_no_all_down_every_frame() {
        BowlingGame game = new BowlingGame();

        Turns turns = new Turns();

        turns.addTurn(rollsOfFrame("-", "5"));
        turns.addTurn(rollsOfFrame("-", "7"));
        turns.addTurn(rollsOfFrame("6", "-"));
        turns.addTurn(rollsOfFrame("5", "-"));
        turns.addTurn(rollsOfFrame("6", "-"));
        turns.addTurn(rollsOfFrame("3", "-"));
        turns.addTurn(rollsOfFrame("2", "-"));
        turns.addTurn(rollsOfFrame("1", "-"));
        turns.addTurn(rollsOfFrame("-", "5"));
        turns.addTurn(rollsOfFrame("5", "-"));

        assertEquals(45, game.totalScore(turns));
    }

    @Test
    public void should_total_score_is_150_when_spare_every_frame() {
        BowlingGame game = new BowlingGame();

        Turns turns = new Turns();
        for (int i = 0; i < 10; i++) {
            turns.addTurn(rollsOfFrame("5", "/"));
        }

        turns.addTurn(rollsOfFrame("5", "-"));

        assertEquals(150, game.totalScore(turns));
    }

    @Test
    public void should_total_score_is_155_when_spare_every_frame_and_last_strike() {
        BowlingGame game = new BowlingGame();

        Turns turns = new Turns();
        for (int i = 0; i < 10; i++) {
            turns.addTurn(rollsOfFrame("5", "/"));
        }

        turns.addTurn(rollsOfFrame("X", ""));

        assertEquals(155, game.totalScore(turns));
    }

    @Test
    public void should_total_score_is_300_when_strike_every_frame() {
        BowlingGame game = new BowlingGame();

        Turns turns = new Turns();
        for (int i = 0; i < 10; i++) {
            turns.addTurn(rollsOfFrame("X", ""));
        }

        turns.addTurn(rollsOfFrame("X", ""));
        turns.addTurn(rollsOfFrame("X", ""));

        assertEquals(300, game.totalScore(turns));
    }

    @Test
    public void should_total_score_is_127() {
        BowlingGame game = new BowlingGame();

        Turns turns = new Turns();

        turns.addTurn(rollsOfFrame("5", "3")); //8
        turns.addTurn(rollsOfFrame("6", "/")); //10 + 5
        turns.addTurn(rollsOfFrame("5", "1")); //6
        turns.addTurn(rollsOfFrame("6", "/")); //10 + 6
        turns.addTurn(rollsOfFrame("6", "/")); //10 + 10
        turns.addTurn(rollsOfFrame("X", ""));  //10 + 10 + 4
        turns.addTurn(rollsOfFrame("X", ""));  //10 + 4 + 4
        turns.addTurn(rollsOfFrame("4", "4")); //8
        turns.addTurn(rollsOfFrame("3", "-")); //3
        turns.addTurn(rollsOfFrame("6", "3")); //9


        assertEquals(127, game.totalScore(turns));
    }

    @Test
    public void should_total_score_is_123() {
        BowlingGame game = new BowlingGame();

        Turns turns = new Turns();

        turns.addTurn(rollsOfFrame("5", "3")); //8
        turns.addTurn(rollsOfFrame("6", "/")); //10 + 5
        turns.addTurn(rollsOfFrame("5", "1")); //6
        turns.addTurn(rollsOfFrame("6", "/")); //10 + 6
        turns.addTurn(rollsOfFrame("6", "/")); //10 + 10
        turns.addTurn(rollsOfFrame("X", ""));   //10 + 10
        turns.addTurn(rollsOfFrame("6", "/"));  //10 + 4
        turns.addTurn(rollsOfFrame("4", "4")); //8
        turns.addTurn(rollsOfFrame("3", "-")); //3
        turns.addTurn(rollsOfFrame("6", "3")); //9


        assertEquals(119, game.totalScore(turns));
    }

    private Turn rollsOfFrame(String first, String next) {
        Turn turn = new Turn();
        turn.add(first);
        turn.add(next);
        return turn;
    }

}
