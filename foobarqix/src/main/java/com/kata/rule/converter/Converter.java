package com.kata.rule.converter;

/**
 * @author sunjing
 */
public interface Converter {

    String to(int num);

    static Converter to(String str) {
        return num -> str;
    }

    static Converter nop() {
        return num -> String.valueOf(num);
    }

}
