package com.kata;

import java.util.List;
import java.util.Optional;

import com.kata.schema.Schemas;
import com.kata.value.ArgsValue;

/**
 * @author sunjing
 */
public final class ArgsParser {

    private final Schemas schemas;

    public ArgsParser(final List<Schema> schemas) {
        this.schemas = new Schemas(schemas);
    }

    public ArgsValue parse(final String argsString) {
        final Args args = new Args(argsString, schemas);

        final ArgsValue argsValue = new ArgsValue();

        this.schemas.stream().forEach(schema -> {
            Optional<String> value = args.valueOf(schema.flag());
            argsValue.put(schema.flag(), schema.parse(value));
        });

        return argsValue;
    }
}
