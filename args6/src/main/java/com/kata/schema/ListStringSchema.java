package com.kata.schema;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import com.kata.Schema;

/**
 * @author sunjing
 */
public final class ListStringSchema extends Schema<List<String>> {

    private static final String DEFAULT_VALUE = "";

    private static final String SPLIT_FLAG = ",";

    public ListStringSchema(final String flag) {
        super(flag, DEFAULT_VALUE);
    }

    public ListStringSchema(final String flag, final String defaultValue) {
        super(flag, defaultValue);
    }

    @Override
    protected List<String> doParse(final String value) {
        return Stream.of(value.split(SPLIT_FLAG)).map(String::new).collect(Collectors.toList());
    }
}
