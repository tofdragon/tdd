package com.kata;

/**
 * @author sunjing
 */
public final class RuleFactory {

    static Rule divisible(int divisibleNumber, String addString) {
         return new Rule() {

             private Rule nextRule;

             @Override
             public void apply(StringBuffer context, String number) {
                 if (Integer.parseInt(number) % divisibleNumber == 0) {
                     context.append(addString);
                 }

                 if (nextRule != null) {
                     nextRule.apply(context, number);
                 }
             }

             @Override
             public void nextRule(Rule rule) {
                 this.nextRule = rule;
             }
         };
    }

    static Rule contains(int containsNumber, String appendStr) {
        return new Rule() {

            private Rule nextRule;

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

            @Override
            public void nextRule(Rule rule) {
                this.nextRule = rule;
            }
        };
    }

    static Rule originalNumber() {
        return new Rule() {

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
        };
    }
}
