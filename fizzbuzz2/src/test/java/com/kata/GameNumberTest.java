package com.kata;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * @author sunjing
 */
public class GameNumberTest {

    @Test
    public void should_say_1_when_row_number_is_1() {
        GameNumber gameNumber = new GameNumber(1);

        assertThat(gameNumber.toString(), is("1"));
    }

    @Test
    public void should_say_fizz_when_row_number_is_3() {
        GameNumber gameNumber = new GameNumber(3);

        assertThat(gameNumber.toString(), is("fizz"));
    }

    @Test
    public void should_say_buzz_when_row_number_is_5() {
        GameNumber gameNumber = new GameNumber(5);

        assertThat(gameNumber.toString(), is("buzz"));
    }

    @Test
    public void should_say_fizzbuzz_when_row_number_is_15() {
        GameNumber gameNumber = new GameNumber(15);

        assertThat(gameNumber.toString(), is("fizzbuzz"));
    }
}
