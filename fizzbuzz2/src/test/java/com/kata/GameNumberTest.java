package com.kata;

import org.junit.Test;

import static org.junit.Assert.assertThat;
import static org.hamcrest.core.Is.is;

/**
 * @author sunjing
 */
public class GameNumberTest {

    @Test
    public void should_create_game_number_from_raw_number() {
        GameNumber gameNumber = new GameNumber(1);
        assertThat(gameNumber.toString(), is("1"));
    }
}
