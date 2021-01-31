package com.kata;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import com.kata.exception.DoesNotExistFlagInSchemaException;
import com.kata.schema.Schemas;

/**
 * @author sunjing
 */
final class Args {

    private final List<String> args;

    private final Schemas schemas;

    Args(final String args, final Schemas schemas) {
        this.args = toArgs(args);
        this.schemas = schemas;
        checkArgs();
    }

    private List<String> toArgs(final String args) {
        return Arrays.asList(args.split(" "));
    }

    public Optional<String> valueOf(String flag) {
        if (isNoFlagValue(flag)) {
            return Optional.empty();
        }
        return Optional.of(flagValue(flag));
    }

    Boolean isNoFlagValue(final String flag) {
        final int indexOfFlag = indexOfFlag(flag);
        if (indexOfFlag + 1 == args.size()) {
            return true;
        }

        if (new FlagArg(nextValue(flag)).isFlag()) {
            return true;
        }

        return false;
    }

    private int indexOfFlag(String flag) {
        return args.indexOf(new FlagArg(flag).toFlagArg());
    }

    private String nextValue(String flag) {
        return args.get(indexOfFlag(flag) + 1);
    }

    private String flagValue(String flag) {
        return nextValue(flag);
    }

    private void checkArgs() {
        List<String> flagArgs = args.stream().filter(arg -> new FlagArg(arg).isFlag())
                .collect(Collectors.toList());

        List<String> notExistFlags = flagArgs.stream()
                .filter(flagArg -> schemas.stream().noneMatch(schema -> schema.flag().equals(new FlagArg(flagArg).toFlag())))
                .collect(Collectors.toList());

        if (notExistFlags.size() > 0) {
            throw new DoesNotExistFlagInSchemaException(notExistFlags);
        }
    }
}
