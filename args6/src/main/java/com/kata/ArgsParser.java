package com.kata;

import java.util.List;
import java.util.Optional;

import com.kata.value.ArgsValue;

/**
 * @author sunjing
 */
public final class ArgsParser {

    private final List<Schema> schemas;

    public ArgsParser(final List<Schema> schemas) {
        this.schemas = schemas;
    }

    public ArgsValue parse(final String argsString) {
        final Args args = new Args(argsString, this.schemas);

        final ArgsValue argsValue = new ArgsValue();

        this.schemas.forEach(schema -> {
            Optional<String> value = args.valueOf(schema.flag());
            argsValue.put(schema.flag(), schema.parse(value));
        });

        return argsValue;
    }
}
