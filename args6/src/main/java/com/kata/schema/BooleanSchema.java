package com.kata.schema;

/**
 * @author sunjing
 */
public final class BooleanSchema extends AbstractSchema<Boolean> {

    private static final String DEFAULT_VALUE = "false";

    public BooleanSchema(final String flag) {
        super(flag, DEFAULT_VALUE);
    }

    public BooleanSchema(final String flag, final String defaultValue) {
        super(flag, defaultValue);
    }

    @Override
    protected Boolean parseValue(final String value) {
        return Boolean.valueOf(value);
    }
}
