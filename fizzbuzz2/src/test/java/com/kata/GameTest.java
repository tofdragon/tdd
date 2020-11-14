package com.kata;

import java.util.List;

import org.junit.Test;

import static org.junit.Assert.assertThat;
import static org.hamcrest.core.Is.is;

/**
 *
 * @author sunjing
 */
public class GameTest {

    @Test
    public void should_create_game_with_given_size() {
        Game game = new Game(100);
        assertThat(game.size(), is(100));
    }

    @Test
    public void should_provide_words_to_be_spoken() {
        Game game = new Game(100);

        List<String> wordsToBeanSpoken = game.words();
        assertThat(wordsToBeanSpoken.size(), is(100));
        assertThat(wordsToBeanSpoken.get(0), is("1"));
        assertThat(wordsToBeanSpoken.get(2), is("fizz"));
        assertThat(wordsToBeanSpoken.get(4), is("buzz"));
        assertThat(wordsToBeanSpoken.get(14), is("fizzbuzz"));
    }
}
