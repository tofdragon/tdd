package com.kata;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public final class Anagram {

    private List<String> words = new ArrayList<>();

    public static Anagram of(List<String> words) {
        Anagram anagram = new Anagram();
        anagram.words = words;
        return anagram;
    }

    public List<String> words() {
        return Collections.unmodifiableList(words);
    }

    int size() {
        return words.size();
    }

    int lengthOfWord() {
        return words.stream().findAny().orElse("").length();
    }

    boolean isIncludeWord(String compareWord) {
        return words.stream().filter(word -> isWordOfSameAnagram(word, compareWord)).findAny().isPresent();
    }

    static boolean isWordOfSameAnagram(String word, String otherWords) {
        if (word.length() != otherWords.length()) {
            return false;
        }

        for(int i = 0; i < word.length() ;i++) {
            if (!otherWords.contains(new Character(word.charAt(i)).toString())) {
                return false;
            }
        }
        return true;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Anagram)) {
            return false;
        }
        Anagram anagram = (Anagram) o;
        return words().equals(anagram.words());
    }

    @Override
    public int hashCode() {
        return Objects.hash(words());
    }

    @Override
    public String toString() {
        return "Anagram{" +
                "words=" + words +
                '}';
    }
}
