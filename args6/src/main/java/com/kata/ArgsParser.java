package com.kata;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import com.kata.exception.DoesNotExistFlagInSchemaException;

/**
 * @author sunjing
 */
public final class ArgsParser {

    private final List<Schema> schemas;

    public ArgsParser(final List<Schema> schemas) {
        this.schemas = schemas;
    }

    public ArgsValue parse(final String args) {
        final List<String> argsObject = toArgs(args);
        checkArgs(argsObject);

        final ArgsValue argsValue = new ArgsValue();
        this.schemas.forEach(schema -> {
            String flag = schema.getFlag();
            String argValue = argValue(argsObject, flag);
            argsValue.put(schema.getFlag(), schema.parse(argValue));
        });

        return argsValue;
    }

    private void checkArgs(List<String> argsObject) {
        List<String> flags = argsObject.stream()
                .filter(arg -> arg.startsWith("-"))
                .map(arg -> arg.replace("-", "")).collect(Collectors.toList());

        List<String> notExistFlags = flags.stream()
                .filter(arg -> schemas.stream().noneMatch(schema -> schema.getFlag().equals(arg)))
                .collect(Collectors.toList());

        if (notExistFlags.size() > 0) {
            throw new DoesNotExistFlagInSchemaException(notExistFlags);
        }

    }

    private List<String> toArgs(final String args) {
        return Arrays.asList(args.split(" "));
    }

    private String argValue(final List<String> args, final String flag) {
        final int flagIndex = args.indexOf("-" + flag);
        if (flagIndex + 1 == args.size()) {
            return null;
        }

        String nextValue = args.get(flagIndex + 1);
        if (nextValue.startsWith("-")) {
            return null;
        }

        return nextValue;
    }
}
