package com.kata;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public final class Anagrams {

    private List<Anagram> anagrams = new ArrayList<>();

    public void add(Anagram anagram) {
        anagrams.add(anagram);
    }

    public int size() {
        return anagrams.size();
    }

    public Anagram getAnagramByWord(String anagramIncludeSomeWord) {
        return anagrams.stream()
                .filter(anagram -> anagram.isIncludeWord(anagramIncludeSomeWord))
                .findAny().orElse(null);
    }

    public Anagram mostWordsOfAnagrams() {
        return anagrams.stream()
                .max(Comparator.comparingInt(anagram -> anagram.size())).orElse(null);
    }

    public Anagram longestWordsOfAnagrams() {
        return anagrams.stream()
                .max(Comparator.comparingInt(anagram -> anagram.lengthOfWord())).orElse(null);
    }
}
