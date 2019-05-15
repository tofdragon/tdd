package com.kata.schema;

import com.kata.value.StringValue;

/**
 * @author sunjing
 */
public final class StringSchema implements Schema<StringValue> {

    @Override
    public String flagName() {
        return "-s";
    }

    @Override
    public StringValue defaultValue() {
        return StringValue.of("");
    }

    @Override
    public StringValue parseValue(String value) {
        return StringValue.of(value);
    }
}
