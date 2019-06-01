package com.kata.rule.matcher.model;

/**
 * @author sunjing
 */
public final class MatchResult {

    /**
     * 是否匹配
     */
    private boolean isMatch;

    /**
     * 匹配次数
     */
    private int numberOfTimesOfMatch;

    private MatchResult() {
    }

    public static MatchResult of(boolean isMatch) {
        MatchResult matchResult = new MatchResult();
        matchResult.isMatch = isMatch;
        return matchResult;
    }

    public static MatchResult of(boolean isMatch, int numberOfTimesOfMatch) {
        MatchResult matchResult = of(isMatch);
        matchResult.numberOfTimesOfMatch = numberOfTimesOfMatch;
        return matchResult;
    }

    public boolean isMatch() {
        return isMatch;
    }

    public int getNumberOfTimesOfMatch() {
        return numberOfTimesOfMatch;
    }
}
