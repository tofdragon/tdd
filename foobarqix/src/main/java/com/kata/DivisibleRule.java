package com.kata;

/**
 * @author sunjing
 */
public final class DivisibleRule implements Rule {

    private int divisibleNumber;

    private String addString;

    private Rule nextRule;

    public DivisibleRule(int divisibleNumber, String addString) {
        this.divisibleNumber = divisibleNumber;
        this.addString = addString;
    }

    public DivisibleRule(int divisibleNumber, String addString, Rule nextRule) {
        this.divisibleNumber = divisibleNumber;
        this.addString = addString;
        this.nextRule = nextRule;
    }

    @Override
    public void apply(StringBuffer context, String number) {
        if (Integer.parseInt(number) % divisibleNumber == 0) {
            context.append(addString);
        }

        if (nextRule != null) {
            nextRule.apply(context, number);
        }
    }
}
