package com.kata;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * @author sunjing
 */
public class GameTest {

    @Test
    public void should_say_words() {
        Game game = new Game(100);
        assertThat(game.words().size(), is(100));
        assertThat(game.words().get(0), is("1"));
        assertThat(game.words().get(2), is("fizz"));
        assertThat(game.words().get(4), is("buzz"));
        assertThat(game.words().get(14), is("fizzbuzz"));
    }
}
