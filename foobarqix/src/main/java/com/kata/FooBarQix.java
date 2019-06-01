package com.kata;

/**
 * @author sunjing
 */
public final class FooBarQix {

    public String compute(String number) {
        StringBuffer result = new StringBuffer();

        divisibleRule(number, 3, result, "Foo");
        divisibleRule(number, 5, result, "Bar");
        divisibleRule(number, 7, result, "Qix");

        containsRule(number, "3", result, "Foo");
        containsRule(number, "5", result, "Bar");
        containsRule(number, "7", result, "Qix");

        return result.length() > 0 ? result.toString() : number;
    }

    private void containsRule(String number, String containNumber,
                              StringBuffer result, String appendStr) {
        for (char c : number.toCharArray()) {
             if (new Character(c).toString().equals(containNumber)) {
                 result.append(appendStr);
             }
        }
    }

    private void divisibleRule(String number, int divisibleNumber,
                               StringBuffer result, String appendStr) {
        Integer integerOfNumber = Integer.parseInt(number);
        if (integerOfNumber % divisibleNumber == 0) {
            result.append(appendStr);
        }
    }
}
