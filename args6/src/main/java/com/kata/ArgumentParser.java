package com.kata;

import java.util.Optional;

import com.kata.schema.Schemas;

/**
 * @author sunjing
 */
public final class ArgumentParser {

    private final Schemas schemas;

    public ArgumentParser(Schemas schemas) {
        this.schemas = schemas;
    }

    public Arguments parse(final String commandLine) {
        final Args args = new Args(commandLine, schemas);

        final Arguments arguments = new Arguments();

        this.schemas.stream().forEach(schema -> {
            Optional<String> argFlagValue = args.valueOf(schema.flag());
            arguments.add(new Argument(schema.flag(), schema.parse(argFlagValue)));
        });

        return arguments;
    }
}
