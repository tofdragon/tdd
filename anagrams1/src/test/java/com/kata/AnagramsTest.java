package com.kata;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AnagramsTest {

    @Test
    public void should_has_one_anagram_when_one_word() {
        final String word = "a";

        AnagramParser anagramParser = new AnagramParser();
        Anagrams anagrams = anagramParser.parse(Collections.singletonList(word));

        assertEquals(1, anagrams.size());
        assertEquals(Anagram.of(Collections.singletonList(word)), anagrams.getAnagramByWord(word));
    }

    @Test
    public void should_has_one_anagram_when_two_same_words() {
        final String word = "ab";
        List<String> words = new ArrayList<>();
        words.add(word);
        words.add("ba");

        AnagramParser anagramParser = new AnagramParser();
        Anagrams anagrams = anagramParser.parse(words);

        assertEquals(1, anagrams.size());
        assertEquals(Anagram.of(words), anagrams.getAnagramByWord(word));
    }

    @Test
    public void should_two_anagram_when_two_no_same_words() {
        final String wordOfAnagram1 = "ab";
        final String wordOfAnagram2 = "ac";

        List<String> words = new ArrayList<>();
        words.add(wordOfAnagram1);
        words.add(wordOfAnagram2);

        AnagramParser anagramParser = new AnagramParser();
        Anagrams anagrams = anagramParser.parse(words);

        assertEquals(2, anagrams.size());
        assertEquals(Anagram.of(Collections.singletonList(wordOfAnagram1)),
                anagrams.getAnagramByWord(wordOfAnagram1));
        assertEquals(Anagram.of(Collections.singletonList(wordOfAnagram2)),
                anagrams.getAnagramByWord(wordOfAnagram2));
    }

    @Test
    public void should_three_anagram_when_two_no_same_words() {
        List<String> words = new ArrayList<>();
        words.add("abc");
        words.add("abc");
        words.add("bca");
        words.add("efg");
        words.add("fgi");
        words.add("cba");

        AnagramParser anagramParser = new AnagramParser();
        Anagrams anagrams = anagramParser.parse(words);
        assertEquals(3, anagrams.size());

        List<String> exceptedWords = new ArrayList<>();
        exceptedWords.add("abc");
        exceptedWords.add("abc");
        exceptedWords.add("bca");
        exceptedWords.add("cba");
        assertEquals(Anagram.of(exceptedWords), anagrams.getAnagramByWord("abc"));
    }

    @Test
    public void should_seven_anagram_when_two_no_equals_word() {
        AnagramParser anagramParser = new AnagramParser();
        Anagrams anagrams = anagramParser.parse(createManyWords());

        assertEquals(7, anagrams.size());
    }

    @Test
    public void should_most_words_of_anagrams() {
        List<String> words = new ArrayList<>();
        words.add("enlist");
        words.add("inlets");
        words.add("silent");
        words.add("listen");

        AnagramParser anagramParser = new AnagramParser();

        assertEquals(Anagram.of(words), anagramParser.parse(createManyWords()).mostWordsOfAnagrams());
    }

    @Test
    public void should_longest_words_of_anagrams() {
        AnagramParser anagramParser = new AnagramParser();

        List<String> exceptedWords = new ArrayList<>();
        exceptedWords.add("boatersa");
        exceptedWords.add("boastera");
        exceptedWords.add("boratesa");
        assertEquals(Anagram.of(exceptedWords), anagramParser.parse(createManyWords()).longestWordsOfAnagrams());
    }

    private List<String> createManyWords() {
        List<String> words = new ArrayList<>();
        words.add("kinship");
        words.add("pinkish");
        words.add("enlist");
        words.add("inlets");
        words.add("sort");
        words.add("rots");
        words.add("boatersa");
        words.add("knits");
        words.add("boastera");
        words.add("stink");
        words.add("skins");
        words.add("boratesa");
        words.add("sinks");
        words.add("refresh");
        words.add("fresher");
        words.add("silent");
        words.add("listen");
        return words;
    }
}
