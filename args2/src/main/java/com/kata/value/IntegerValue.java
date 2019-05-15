package com.kata.value;

/**
 * @author sunjing
 */
public final class IntegerValue implements Value<Integer> {

    private String value;

    private IntegerValue() {
    }

    public static IntegerValue of(String value) {
        IntegerValue integerValue = new IntegerValue();
        integerValue.value = value;
        return integerValue;
    }

    @Override
    public Integer value() {
        return Integer.parseInt(value);
    }
}
