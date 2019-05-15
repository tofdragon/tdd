package com.kata.schema;

import com.kata.value.StringValue;

/**
 * @author sunjing
 */
public final class PortSchema implements Schema<StringValue> {

    @Override
    public String flagName() {
        return "-port";
    }

    @Override
    public StringValue defaultValue() {
        return StringValue.of("8000");
    }

    @Override
    public StringValue parseValue(String value) {
        return StringValue.of(value);
    }
}
