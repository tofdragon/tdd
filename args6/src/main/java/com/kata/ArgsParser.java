package com.kata;

import java.util.Optional;

import com.kata.schema.Schemas;
import com.kata.value.ArgsValue;

/**
 * @author sunjing
 */
public final class ArgsParser {

    private final Schemas schemas;

    public ArgsParser(Schemas schemas) {
        this.schemas = schemas;
    }

    public ArgsValue parse(final String argsString) {
        final Args args = new Args(argsString, schemas);

        final ArgsValue argsValue = new ArgsValue();

        this.schemas.stream().forEach(schema -> {
            Optional<String> argFlagValue = args.valueOf(schema.flag());
            argsValue.put(schema.flag(), schema.parse(argFlagValue));
        });

        return argsValue;
    }
}
