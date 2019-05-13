package com.kata.flag;

/**
 * 端口
 * @author sunjing
 */
public final class PortFlag implements Flag {

    @Override
    public String name() {
        return "-port";
    }

    @Override
    public Object defaultValue() {
        return "8000";
    }

    @Override
    public Object parseValue(String value) {
        return value;
    }
}
