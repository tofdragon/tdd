package com.kata.schema;

/**
 * @author sunjing
 */
public final class StringSchema extends AbstractSchema<String> {

    private static final String DEFAULT_VALUE = "";

    public StringSchema(final String flag) {
        super(flag, DEFAULT_VALUE);
    }

    public StringSchema(final String flag, final String defaultValue) {
        super(flag, defaultValue);
    }

    @Override
    protected String parseValue(final String value) {
        return value;
    }
}
