package com.kata;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import com.kata.schema.Schemas;

/**
 * 参数
 *
 * @author sunjing
 */
final class Args {

    private static final String FLAG_PREFIX = "-";

    private final List<String> args;

    private final Schemas schemas;

    Args(final String args, final Schemas schemas) {
        this.args = Arrays.asList(args.split(" "));
        this.schemas = schemas;
    }

    Optional<String> value(String flag) {
        if (isNoValueOfFlag(flag)) {
            return Optional.empty();
        }
        return Optional.of(valueOfFlag(flag));
    }

    private Boolean isNoValueOfFlag(String flag) {
        if (args.size() == 0) {
            return true;
        }

        int indexOfFlag = indexOfFlag(flag);
        if (indexOfFlag + 1 == args.size()) {
            return true;
        }

        if (isFlag(nextValue(flag))) {
            return true;
        }

        return false;
    }

    private String valueOfFlag(String flag) {
        return nextValue(flag);
    }

    private String nextValue(String flag) {
        int indexOfFlag = indexOfFlag(flag);
        return args.get(indexOfFlag + 1);
    }

    private boolean isFlag(String value) {
        return value.startsWith(FLAG_PREFIX) && schemas.isFlag(toFlag(value));
    }

    private int indexOfFlag(String flag) {
        return args.indexOf(toValue(flag));
    }

    private String toFlag(String value) {
        return value.replace(FLAG_PREFIX, "");
    }

    private String toValue(String flag) {
        return FLAG_PREFIX + flag;
    }
}
