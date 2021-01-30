package com.kata;

import java.util.Optional;

import com.kata.schema.Schemas;
import com.kata.value.ArgsValues;

/**
 * 参数解析
 *
 * @author sunjing
 * @since 1.0.0
 */
public final class ArgsParser {

    private final Schemas schemas;

    public ArgsParser(Schemas schemas) {
        this.schemas = schemas;
    }

    public int sizeOfSchemas() {
        return schemas.size();
    }

    public ArgsValues parse(final String args) {
        return argsValues(new Args(args, schemas));
    }

    private ArgsValues argsValues(final Args args) {
        ArgsValues argsValues = new ArgsValues();

        this.schemas.schemasStream().forEach(schema -> {
            Optional<String> flagValue = args.value(schema.flag());
            argsValues.add(schema.flag(), schema.parse(flagValue));
        });

        return argsValues;
    }
}
