package com.kata.schema;

/**
 * 〈功能详细描述〉 描述
 *
 * @author sunjing
 * @since [产品/模块版本]
 */
public class PortSchema implements Schema {

    @Override
    public String flagName() {
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
