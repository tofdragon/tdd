package com.kata.schema;

import com.kata.Schema;

/**
 * 布尔参数
 *
 * @author sunjing
 */
public final class BooleanSchema implements Schema {

    @Override
    public String flagName() {
        return "-l";
    }

    @Override
    public Object defaultValue() {
        return Boolean.FALSE;
    }

    @Override
    public Object parseValue(String value) {
        return Boolean.valueOf(value);
    }
}
