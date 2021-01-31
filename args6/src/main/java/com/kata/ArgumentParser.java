package com.kata;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import com.kata.exception.DoesNotExistFlagInSchemaException;
import com.kata.schema.Schemas;
import com.kata.token.ArgumentTokenizer;

/**
 * @author sunjing
 */
public final class ArgumentParser {

    private final Schemas schemas;

    public ArgumentParser(Schemas schemas) {
        this.schemas = schemas;
    }

    public Arguments parse(final String commandLine) {
        final Arguments tokenArguments = tokenArguments(commandLine);

        final Arguments arguments = new Arguments();
        schemas.stream().forEach(schema -> {
            Optional<String> tokenValue = tokenArguments.getValue(schema.flag());
            arguments.add(schema.flag(), schema.parse(tokenValue));
        });

        return arguments;
    }

    private Arguments tokenArguments(String commandLine) {
        final Arguments arguments = new ArgumentTokenizer(commandLine).arguments();

        List<String> notExistFlags = arguments.stream()
                .filter(argument -> schemas.stream().noneMatch(schema -> schema.flag().equals(argument.getFlag())))
                .map(Argument::getFlag)
                .collect(Collectors.toList());

        if (notExistFlags.size() > 0) {
            throw new DoesNotExistFlagInSchemaException(notExistFlags);
        }

        return arguments;
    }
}
