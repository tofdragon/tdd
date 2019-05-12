package com.kata;

/**
 * 参数
 *
 * @author sunjing
 */
class Arg {

    private String flagName;

    private Object value;

    Arg(String flagName, Object value) {
        this.flagName = flagName;
        this.value = value;
    }

    boolean hasSameFlagName(String flagName) {
        return this.flagName.equals(flagName) ? true : false;
    }

    Object value() {
        return value;
    }
}
