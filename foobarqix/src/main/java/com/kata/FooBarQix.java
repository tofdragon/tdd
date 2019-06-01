package com.kata;

/**
 * @author sunjing
 */
public final class FooBarQix {

    private Rule rule;

    public FooBarQix() {
        rule = new DivisibleRule(3, "Foo",
                new DivisibleRule(5, "Bar",
                        new DivisibleRule(7, "Qix",
                                new ContainsRule(3, "Foo",
                                        new ContainsRule(5, "Bar",
                                                new ContainsRule(7, "Qix", new OriginalNumberRule()))))));
    }

    public String compute(String number) {
        StringBuffer result = new StringBuffer();
        rule.apply(result, number);
        return result.toString();
    }
}
