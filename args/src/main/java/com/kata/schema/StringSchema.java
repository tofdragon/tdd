package com.kata.schema;

import com.kata.Schema;

/**
 * 字符串参数
 * @author sunjing
 */
public final class StringSchema implements Schema {

    @Override
    public String flag() {
        return "-s";
    }

    @Override
    public Object defaultValue() {
        return "";
    }

    @Override
    public Object parserValue(String value) {
        return value;
    }
}
