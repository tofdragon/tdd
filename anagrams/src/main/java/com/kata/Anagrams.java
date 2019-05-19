package com.kata;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * @author sunjing
 */
public final class Anagrams {

    private List<Anagram> allAnagram = new ArrayList<>();

    public void add(Anagram anagram) {
        allAnagram.add(anagram);
    }

    public int size() {
        return allAnagram.size();
    }

    public Anagram containingMostWordsOfAnagram() {
        return allAnagram.stream()
                .max(Comparator.comparingInt(anagram -> anagram.size())).orElse(null);
    }

    public Anagram longestWordsOfAnagram() {
        return allAnagram.stream()
                .max(Comparator.comparingInt(anagram -> anagram.lengthOfWord())).orElse(null);
    }
}
