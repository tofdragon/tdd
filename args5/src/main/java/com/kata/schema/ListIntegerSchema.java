package com.kata.schema;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * ListInteger
 *
 * @author sunjing
 */
public final class ListIntegerSchema extends AbstractSchema<List<Integer>> {

    private static final String DEFAULT_VALUE = "";

    public ListIntegerSchema(final String flag) {
        super(flag, DEFAULT_VALUE);
    }

    public ListIntegerSchema(final String flag, final String defaultValue) {
        super(flag, defaultValue);
    }

    @Override
    protected List<Integer> parseValue(final String value) {
        return Stream.of(value.split(",")).map(Integer::new).collect(Collectors.toList());
    }
}
