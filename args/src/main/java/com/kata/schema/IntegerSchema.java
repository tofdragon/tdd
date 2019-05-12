package com.kata.schema;

import com.kata.Schema;

/**
 * 整型参数
 * @author sunjing
 */
public final class IntegerSchema implements Schema {

    @Override
    public String flag() {
        return "-i";
    }

    @Override
    public Object defaultValue() {
        return 0;
    }

    @Override
    public Object parserValue(String value) {
        return Integer.parseInt(value);
    }
}
