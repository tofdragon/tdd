package com.kata.rule;

import java.util.Arrays;
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
            if (!matchResult.isMatch()) {
                return "";
            }

            if (matchResult.getNumberOfTimesOfMatch() == 0) {
                return converter.to(num);
            }

            StringBuffer sb = new StringBuffer();
            for (int i = 0; i < matchResult.getNumberOfTimesOfMatch(); i++) {
                sb.append(converter.to(num));
            }

            return sb.toString();
        };
    }

    public static Rule allOf(Rule... rules) {
        return n -> stringStream(n, rules).collect(joining());
    }

    public static Rule not(Rule rule1, Rule rule2) {
        return n -> {
            String result = rule1.apply(n);
            if (result == null || result.length() <= 0) {
                return rule2.apply(n);
            }
            return result;
        };
    }

    private static Stream<String> stringStream(int num, Rule[] rules) {
        return Arrays.stream(rules).map(rule -> rule.apply(num));
    }
}
