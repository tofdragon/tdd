package com.kata.schema;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import com.kata.Schema;

/**
 * @author sunjing
 */
public final class ListIntegerSchema extends AbstractSchema<List<Integer>> {

    private static final String DEFAULT_VALUE = "";

    private static final String SPLIT_FLAG = ",";

    public ListIntegerSchema(final String flag) {
        super(flag, DEFAULT_VALUE);
    }

    public ListIntegerSchema(final String flag, final String defaultValue) {
        super(flag, defaultValue);
    }

    @Override
    protected List<Integer> parseValue(final String value) {
        Schema<Integer> integerSchema = new IntegerSchema(flag(), getDefaultValue());
        return Stream.of(value.split(SPLIT_FLAG))
                .map(item -> integerSchema.parse(Optional.of(item)))
                .collect(Collectors.toList());
    }
}
