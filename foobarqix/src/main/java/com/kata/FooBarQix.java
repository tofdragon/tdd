package com.kata;

/**
 * @author sunjing
 */
public final class FooBarQix {

    private Rule rule;

    public FooBarQix() {
        createRule();
    }

    public String compute(String number) {
        StringBuffer result = new StringBuffer();
        rule.apply(result, number);
        return result.toString();
    }

    private void createRule() {
        rule = new DivisibleRule(3, "Foo");
        Rule fiveDivisible = new DivisibleRule(5,"Bar");
        Rule sevenDivisible = new DivisibleRule(7, "Qix");

        Rule threeContains =  new ContainsRule(3, "Foo");
        Rule fiveContains = new ContainsRule(5, "Bar");
        Rule sevenContains = new ContainsRule(7, "Qix");

        Rule originalNumber = new OriginalNumberRule();

        rule.nextRule(fiveDivisible);
        fiveDivisible.nextRule(sevenDivisible);
        sevenDivisible.nextRule(threeContains);
        threeContains.nextRule(fiveContains);
        fiveContains.nextRule(sevenContains);
        sevenContains.nextRule(originalNumber);
    }
}
