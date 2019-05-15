package com.kata.schema;

/**
 * 〈功能详细描述〉 描述
 *
 * @author sunjing
 * @since [产品/模块版本]
 */
public class BooleanSchema implements Schema {
    @Override
    public String flagName() {
        return "-l";
    }

    @Override
    public Object defaultValue() {
        return false;
    }

    @Override
    public Object parseValue(String value) {
        return Boolean.valueOf(value.toString());
    }
}
