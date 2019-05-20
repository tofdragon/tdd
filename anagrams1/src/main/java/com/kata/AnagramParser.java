package com.kata;

import java.util.List;
import java.util.stream.Collectors;

public final class AnagramParser {

    public Anagrams parse(List<String> words) {
        List<String> copyWords = words.stream().collect(Collectors.toList());

        Anagrams anagrams = new Anagrams();
        while(copyWords.size() > 0) {
            Anagram anagram = findAnagram(copyWords.get(0), words);
            copyWords.removeAll(anagram.words());
            anagrams.add(anagram);
        }
        return anagrams;
    }

    private Anagram findAnagram(String word, List<String> words) {
        return Anagram.of(words.stream()
                .filter(otherWord -> Anagram.isWordOfSameAnagram(word, otherWord))
                .collect(Collectors.toList()));
    }
}
