package com.kata;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author sunjing
 */
public class GuessAnagramTest {

    @Test
    public void should_return_four_anagram_when_two_or_three_length_of_words() {
        GuessAnagram guessAnagram = new GuessAnagram();

        List<String> words = new ArrayList<>();
        words.add("ab");
        words.add("ba");
        words.add("ac");
        words.add("ca");
        words.add("ef");

        words.add("abc");
        words.add("abe");
        words.add("acb");
        words.add("acf");
        words.add("bcg");

        assertEquals(7, guessAnagram.findAnagram(words).size());
    }

    @Test
    public void should_return_three_anagram_when_many_words() {
        GuessAnagram guessAnagram = new GuessAnagram();
        List<String> words = new ArrayList<>();
        words.add("kinship");
        words.add("pinkish");
        words.add("enlist");
        words.add("inlets");
        words.add("listen");
        words.add("silent");
        words.add("boaster");
        words.add("boaters");
        words.add("borates");

        List<String> excepted = new ArrayList<>();
        excepted.add("kinship");
        excepted.add("pinkish");

        assertEquals(3, guessAnagram.findAnagram(words).size());
    }

    @Test
    public void should_containing_the_most_words_anagram_words() {
        GuessAnagram guessAnagram = new GuessAnagram();
        List<String> words = new ArrayList<>();
        words.add("kinship");
        words.add("pinkish");
        words.add("enlist");
        words.add("inlets");
        words.add("listen");
        words.add("silent");
        words.add("boaster");
        words.add("boaters");
        words.add("borates");

        List<String> exceptedWords = new ArrayList<>();
        exceptedWords.add("enlist");
        exceptedWords.add("inlets");
        exceptedWords.add("listen");
        exceptedWords.add("silent");

        assertEquals(Anagram.of(exceptedWords), guessAnagram.findAnagram(words).containingMostWordsOfAnagram());
    }

    @Test
    public void should_the_longest_words_anagram_words() {
        GuessAnagram guessAnagram = new GuessAnagram();
        List<String> words = new ArrayList<>();
        words.add("kinship");
        words.add("pinkish");
        words.add("enlist");
        words.add("inlets");
        words.add("listen");
        words.add("silent");
        words.add("boastera");
        words.add("boatersa");
        words.add("boratesa");

        List<String> exceptedWords = new ArrayList<>();
        exceptedWords.add("boastera");
        exceptedWords.add("boatersa");
        exceptedWords.add("boratesa");

        assertEquals(Anagram.of(exceptedWords), guessAnagram.findAnagram(words).longestWordsOfAnagram());
    }

}
