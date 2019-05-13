package com.kata.flag;

/**
 * 整型
 * @author sunjing
 */
public final class IntegerFlag implements Flag {

    @Override
    public String name() {
        return "-i";
    }

    @Override
    public Object defaultValue() {
        return 0;
    }

    @Override
    public Object parseValue(String value) {
        return Integer.parseInt(value);
    }
}
