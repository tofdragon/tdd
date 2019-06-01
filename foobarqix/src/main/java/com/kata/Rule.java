package com.kata;

/**
 * @author sunjing
 */
public interface Rule {

    void apply(StringBuffer context, String number);

    void nextRule(Rule rule);
}
