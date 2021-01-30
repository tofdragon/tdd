package com.kata.schema;

import java.util.Arrays;
import java.util.List;

/**
 * ListString
 *
 * @author sunjing
 */
public final class ListStringSchema extends AbstractSchema<List<String>> {

    private static final String DEFAULT_VALUE = "";

    public ListStringSchema(final String flag) {
        super(flag, DEFAULT_VALUE);
    }

    public ListStringSchema(final String flag, final String defaultValue) {
        super(flag, defaultValue);
    }

    @Override
    protected List<String> parseValue(final String value) {
        return Arrays.asList(value.split(","));
    }
}
