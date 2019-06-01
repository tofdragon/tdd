package com.kata;

/**
 * @author sunjing
 */
public class OriginalNumberRule implements Rule {

    @Override
    public void apply(StringBuffer context, String number) {
        if (context.length() > 0) {
            return;
        }
        context.append(number);
    }

    @Override
    public void nextRule(Rule rule) {
    }
}
