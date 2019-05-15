package com.kata.schema;

/**
 * 〈功能详细描述〉 描述
 *
 * @author sunjing
 * @since [产品/模块版本]
 */
public class IntegerSchema implements Schema {
    @Override
    public String flagName() {
        return "-i";
    }

    @Override
    public Object defaultValue() {
        return 0;
    }

    @Override
    public Object parseValue(String value) {
        return Integer.parseInt(value.toString());
    }
}
