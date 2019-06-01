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
        rule = RuleFactory.divisible(3, "Foo");
        Rule fiveDivisible =  RuleFactory.divisible(5,"Bar");
        Rule sevenDivisible =  RuleFactory.divisible(7, "Qix");

        Rule threeContains =   RuleFactory.contains(3, "Foo");
        Rule fiveContains = RuleFactory.contains(5, "Bar");
        Rule sevenContains = RuleFactory.contains(7, "Qix");

        Rule originalNumber = RuleFactory.originalNumber();

        rule.nextRule(fiveDivisible);
        fiveDivisible.nextRule(sevenDivisible);
        sevenDivisible.nextRule(threeContains);
        threeContains.nextRule(fiveContains);
        fiveContains.nextRule(sevenContains);
        sevenContains.nextRule(originalNumber);
    }
}
