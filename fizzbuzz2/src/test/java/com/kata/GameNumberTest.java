package com.kata;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * @author sunjing
 */
public class GameNumberTest {

    @Test
    public void should_create_game_number_from_raw_number() {
        GameNumber gameNumber = new GameNumber(1);
        assertThat(gameNumber.toString(), is("1"));
    }

    @Test
    public void should_say_fizz_when_is_3() {
        GameNumber gameNumber = new GameNumber(3);
        assertThat(gameNumber.toString(), is("fizz"));
    }

    @Test
    public void should_say_fizz_when_is_contains_3() {
        GameNumber gameNumber = new GameNumber(13);
        assertThat(gameNumber.toString(), is("fizz"));
    }

    @Test
    public void should_say_buzz_when_is_5() {
        GameNumber gameNumber = new GameNumber(5);
        assertThat(gameNumber.toString(), is("buzz"));
    }

    @Test
    public void should_say_buzz_when_is_contains_5() {
        GameNumber gameNumber = new GameNumber(52);
        assertThat(gameNumber.toString(), is("buzz"));
    }

    @Test
    public void should_say_fizzbuzz_when_is_contains_35() {
        GameNumber gameNumber = new GameNumber(53);
        assertThat(gameNumber.toString(), is("fizzbuzz"));
    }

    @Test
    public void should_say_fizzbuzz_when_is_15() {
        assertThat(new GameNumber(15).toString(), is("fizzbuzz"));
    }


}
