package com.kata;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 *
 * @author sunjing
 */
public class GameNumberTest {

    @Test
    public void should_create_game_number_from_raw_number() {
        GameNumber gameNumber = new GameNumber(1);
        assertThat(gameNumber.toString(), is("1"));
    }

    @Test
    public void should_say_fizz_when_raw_number_is_3() {
        assertThat(new GameNumber(3).toString(), is("fizz"));
    }

    @Test
    public void should_say_buzz_when_raw_number_is_5() {
        assertThat(new GameNumber(5).toString(), is("buzz"));
    }

    @Test
    public void should_say_fizzbuzz_when_raw_number_is_15() {
        assertThat(new GameNumber(15).toString(), is("fizzbuzz"));
    }

    @Test
    public void should_say_fizz_when_contains_3() {
        assertThat(new GameNumber(13).toString(), is("fizz"));
    }

    @Test
    public void should_say_buzz_when_contains_5() {
        assertThat(new GameNumber(59).toString(), is("buzz"));
    }

    @Test
    public void should_say_fizzbuzz_when_contains_3_or_5() {
        assertThat(new GameNumber(53).toString(), is("fizzbuzz"));
    }
}
