package com.kata;

/**
 * @author sunjing
 */
final class FlagArg {

    private static final String ARG_FLAG_PREFIX = "-";

    private final String value;

    FlagArg(final String value) {
        this.value = value;
    }

    boolean isFlag() {
        return value.startsWith(ARG_FLAG_PREFIX);
    }

    String toFlag() {
        return value.replace(ARG_FLAG_PREFIX, "");
    }

    String toFlagArg() {
        return ARG_FLAG_PREFIX + value;
    }
}
