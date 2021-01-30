package com.kata.schema;

/**
 * Integer
 *
 * @author sunjing
 */
public final class IntegerSchema extends AbstractSchema<Integer> {

    private static final String DEFAULT_VALUE = "0";

    public IntegerSchema(final String flag) {
        super(flag, DEFAULT_VALUE);
    }

    public IntegerSchema(final String flag, final String defaultValue) {
        super(flag, defaultValue);
    }

    @Override
    protected Integer parseValue(final String value) {
        return Integer.valueOf(value);
    }

}
