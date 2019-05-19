package com.kata;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author sunjing
 */
public final class GuessAnagram {

    public Anagrams findAnagram(List<String> words) {
        List<String> copyWords = words.stream().collect(Collectors.toList());

        Anagrams anagrams = new Anagrams();
        while (copyWords.size() > 0) {
            Anagram anagram = findAnagram(copyWords, copyWords.get(0));
            anagrams.add(anagram);
            copyWords.removeAll(anagram.words());
        }
        return anagrams;
    }

    private Anagram findAnagram(List<String> words, String word) {
        return Anagram.of(words.stream()
                .filter(nextWord -> Anagram.isWordOfAnagram(word, nextWord))
                .collect(Collectors.toList()));
    }

}
