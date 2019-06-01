package com.kata;

/**
 * @author sunjing
 */
public final class ContainsRule implements Rule {

    private int containsNumber;

    private String appendStr;

    private Rule nextRule;

    public ContainsRule(int containsNumber, String appendStr) {
        this.containsNumber = containsNumber;
        this.appendStr = appendStr;
    }

    public ContainsRule(int containsNumber, String appendStr, Rule nextRule) {
        this.containsNumber = containsNumber;
        this.appendStr = appendStr;
        this.nextRule = nextRule;
    }

    @Override
    public void apply(StringBuffer context, String number) {
        for (char c : number.toCharArray()) {
            if (new Character(c).toString().equals(String.valueOf(containsNumber))) {
                context.append(appendStr);
            }
        }

        if (nextRule != null) {
            nextRule.apply(context, number);
        }
    }
}
