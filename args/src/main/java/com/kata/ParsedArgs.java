package com.kata;

import java.util.LinkedList;
import java.util.List;

/**
 * 解析后的参数
 *
 * @author sunjing
 */
class ParsedArgs {

    private List<Arg> args = new LinkedList<>();

    void addArg(String flagName, Object value) {
        args.add(new Arg(flagName, value));
    }

    Object getValue(String flagName) {
        Arg foundArg = args.stream()
                .filter((arg) -> arg.hasSameFlagName(flagName))
                .findAny().orElse(null);
        return foundArg == null ? null : foundArg.value();
    }
}
