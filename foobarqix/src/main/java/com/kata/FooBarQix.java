package com.kata;

import com.kata.rule.Rule;

/**
 * @author sunjing
 */
public final class FooBarQix {

    private Rule rule;

    public FooBarQix(Rule rule) {
        this.rule = rule;
    }

    public String compute(String number) {
        return rule.apply(Integer.parseInt(number));
    }
}
