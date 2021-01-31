package com.kata;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import com.kata.exception.DoesNotExistFlagInSchemaException;

/**
 * @author sunjing
 */
final class Args {

    private final List<String> values;

    private final List<Schema> schemas;

    Args(final String args, final List<Schema> schemas) {
        this.values = toArgs(args);
        this.schemas = schemas;
        checkArgs();
    }

    Optional<String> valueOf(final String flag) {
        final int flagIndex = values.indexOf("-" + flag);
        if (flagIndex + 1 == values.size()) {
            return Optional.empty();
        }

        String nextValue = values.get(flagIndex + 1);
        if (nextValue.startsWith("-")) {
            return Optional.empty();
        }

        return Optional.of(nextValue);
    }

    private List<String> toArgs(final String args) {
        return Arrays.asList(args.split(" "));
    }

    private void checkArgs() {
        List<String> flags = values.stream()
                .filter(arg -> arg.startsWith("-"))
                .map(arg -> arg.replace("-", "")).collect(Collectors.toList());

        List<String> notExistFlags = flags.stream()
                .filter(arg -> schemas.stream().noneMatch(schema -> schema.flag().equals(arg)))
                .collect(Collectors.toList());

        if (notExistFlags.size() > 0) {
            throw new DoesNotExistFlagInSchemaException(notExistFlags);
        }
    }
}
