package com.kata;

import com.kata.rule.Rule;

import static com.kata.rule.RuleFactory.allOf;
import static com.kata.rule.RuleFactory.not;
import static com.kata.rule.RuleFactory.of;
import static com.kata.rule.converter.Converter.nop;
import static com.kata.rule.converter.Converter.to;
import static com.kata.rule.matcher.Matcher.always;
import static com.kata.rule.matcher.Matcher.numberOfTimesOfContains;
import static com.kata.rule.matcher.Matcher.times;

/**
 * @author sunjing
 */
public final class FooBarQix {

    private Rule rule;

    public FooBarQix() {
        createRule();
    }

    public String compute(String number) {
        return rule.apply(Integer.parseInt(number));
    }

    private void createRule() {
        Rule threeTimes = of(times(3), to("Foo"));
        Rule fiveTimes =  of(times(5), to("Bar"));
        Rule sevenTimes = of(times(7), to("Qix"));

        Rule threeContains= of(numberOfTimesOfContains(3), to("Foo"));
        Rule fiveContains =  of(numberOfTimesOfContains(5), to("Bar"));
        Rule sevenContains = of(numberOfTimesOfContains(7), to("Qix"));

        Rule timesOrContains = allOf(threeTimes, fiveTimes, sevenTimes, threeContains, fiveContains, sevenContains);

        rule = not(timesOrContains, of(always(true), nop()));
    }
}
