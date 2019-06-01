package com.kata.rule;

import java.util.Arrays;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import com.kata.rule.converter.Converter;
import com.kata.rule.matcher.Matcher;
import com.kata.rule.matcher.model.MatchResult;

import static java.util.stream.Collectors.joining;

/**
 * @author sunjing
 */
public final class RuleFactory {

    public static Rule of(Matcher matcher, Converter converter) {
        return num -> {
            MatchResult matchResult = matcher.matches(num);
            return matchResult.isMatch() ? converter.to(num) : "";
        };
    }

    public static Rule numberOfTimesOfMatch(Matcher matcher, Converter converter) {
        return num -> {
            MatchResult matchResult = matcher.matches(num);
            if (matchResult.isNotMatch()) {
                return "";
            }

            StringBuffer sb = new StringBuffer();
            IntStream.range(0, matchResult.numberOfTimesOfMatch()).forEach((index) -> {
                sb.append(converter.to(num));
            });
            return sb.toString();
        };
    }

    public static Rule allOf(Rule... rules) {
        return num -> stringStream(num, rules).collect(joining());
    }

    public static Rule not(Rule primary, Rule next) {
        return num -> {
            String result = primary.apply(num);
            return (result != null && result.length() > 0) ? result : next.apply(num);
        };
    }

    private static Stream<String> stringStream(int num, Rule[] rules) {
        return Arrays.stream(rules).map(rule -> rule.apply(num));
    }
}
