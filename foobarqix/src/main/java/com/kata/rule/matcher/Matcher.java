package com.kata.rule.matcher;

import com.kata.rule.matcher.model.MatchResult;

/**
 * @author sunjing
 */
public interface Matcher {

    MatchResult matches(int num);

    static Matcher times(int times) {
        return num -> MatchResult.of(num % times == 0);
    }

    static Matcher numberOfTimesOfContains(int containsNum) {
        return num -> {
            int numberOfTimesOfMatch = 0;
            for (char c : String.valueOf(num).toCharArray()) {
                if (new Character(c).toString().equals(String.valueOf(containsNum))) {
                    numberOfTimesOfMatch++;
                }
            }
            return MatchResult.of(numberOfTimesOfMatch > 0, numberOfTimesOfMatch);
        };
    }

    static Matcher always(boolean bool) {
        return n -> MatchResult.of(bool);
    }
}

