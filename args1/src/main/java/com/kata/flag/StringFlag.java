package com.kata.flag;

/**
 * 字符串
 * @author sunjing
 */
public final class StringFlag implements Flag{

    @Override
    public String name() {
        return "-s";
    }

    @Override
    public Object defaultValue() {
        return "";
    }

    @Override
    public Object parseValue(String value) {
        return value;
    }
}
