package com.kata.flag;

/**
 * 布尔
 * @author sunjing
 */
public final class BooleanFlag implements Flag{

    @Override
    public String name() {
        return "-l";
    }

    @Override
    public Object defaultValue() {
        return false;
    }

    @Override
    public Object parseValue(String value) {
        return Boolean.valueOf(value);
    }
}
