package com.kata;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

/**
 * @author sunjing
 */
final class Anagram {

    private List<String> words = new ArrayList<>();

    static Anagram of(List<String> words) {
        Anagram anagram = new Anagram();
        anagram.words = words;
        return anagram;
    }

    static boolean isWordOfAnagram(String word1, String word2) {
        if (word1.length() != word2.length()) {
            return false;
        }

        List<Character> characterOfWord1 = new LinkedList<>();
        for (int index = 0; index < word1.length(); index++) {
            characterOfWord1.add(word1.charAt(index));
        }

        boolean isNoWordOfAnagram = characterOfWord1.stream()
                .filter(character -> !word2.contains(Character.toString(character)))
                .findAny().isPresent();

        return isNoWordOfAnagram ? false :true;
    }

    List<String> words() {
        return Collections.unmodifiableList(words);
    }

    int size() {
        return words().size();
    }

    int lengthOfWord() {
        if (words().isEmpty()) {
            return 0;
        }
        return words().stream().findAny().orElse(null).length();
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
        return Objects.equals(words(), anagram.words());
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
