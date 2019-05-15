package com.kata.schema;

import com.kata.value.BooleanValue;

/**
 * @author sunjing
 */
public final class BooleanSchema implements Schema<BooleanValue> {

    @Override
    public String flagName() {
        return "-l";
    }

    @Override
    public BooleanValue defaultValue() {
        return BooleanValue.falseValue();
    }

    @Override
    public BooleanValue parseValue(String value) {
        return BooleanValue.of(value);
    }

}
