package com.kata;

import org.junit.Test;

import static org.junit.Assert.assertThat;
import static org.hamcrest.core.Is.is;

/**
 * @author sunjing
 */
public class GameTest {

    @Test
    public void should_create_game_from_size() {
        Game game = new Game(100);
        assertThat(game.size(), is(100));
    }

    @Test
    public void should_excepted_words() {
        Game game = new Game(100);
        assertThat(game.words().size(), is(100));
        assertThat(game.words().get(0), is("1"));
        assertThat(game.words().get(2), is("fizz"));
        assertThat(game.words().get(4), is("buzz"));
        assertThat(game.words().get(14), is("fizzbuzz"));
    }
}
