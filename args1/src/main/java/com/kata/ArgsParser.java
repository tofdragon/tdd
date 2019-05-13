package com.kata;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;

import com.kata.flag.BooleanFlag;
import com.kata.flag.Flag;
import com.kata.flag.IntegerFlag;
import com.kata.flag.PortFlag;
import com.kata.flag.StringFlag;

/**
 * 参数解析
 * @author sunjing
 */
public final class ArgsParser {

    private static List<Flag> flags = new ArrayList<>();

    private static final String FLAG_NAME_PREFIX = "-";

    private static final String VALID_FLAG_NAME_REGEX = "-[a-zA-Z]+";

    private Map<String, Object> flagToValue = new HashMap<>();

    static {
        flags.add(new IntegerFlag());
        flags.add(new BooleanFlag());
        flags.add(new StringFlag());
        flags.add(new PortFlag());
    }

    public void parse(String args) {
        Stack<String> argsStack = toArgsStack(args);
        while (!argsStack.empty()) {
            parseArg(argsStack, argsStack.pop());
        }
    }

    public Object getValue(String flag) {
        return flagToValue.get(flag);
    }

    public Boolean getBooleanValue(String flag) {
        Object value = flagToValue.get(flag);
        return value == null ? null : Boolean.valueOf(value.toString());
    }

    public String getStringValue(String flag) {
        Object value = flagToValue.get(flag);
        return value == null ? null : value.toString();
    }

    public Integer getIntegerValue(String flag) {
        Object value = flagToValue.get(flag);
        return value == null ? null : Integer.parseInt(value.toString());
    }

    public void registerFlag(Flag flag) {
        flags.add(flag);
    }

    private Stack<String> toArgsStack(String args) {
        List<String> parserArgs = Arrays.asList(args.split(" "));
        Collections.reverse(parserArgs);

        Stack<String> stack = new Stack<>();
        stack.addAll(parserArgs);
        return stack;
    }

    private void parseArg(Stack<String> argsStack, String flagName) {
        if (isInValidFlag(flagName)) {
            throw new RuntimeException("不合法的标记");
        }

        if (argsStack.empty()) {
            addDefaultArgValue(flagName);
            return;
        }

        String flagNameOrValue = argsStack.pop();
        if (isValidFlagNamingConventions(flagNameOrValue)) {
            argsStack.push(flagNameOrValue);
            addDefaultArgValue(flagName);
            return;
        }

        flagToValue.put(flagName, findFlagBy(flagName).parseValue(flagNameOrValue));
    }

    private void addDefaultArgValue(String flagName) {
        flagToValue.put(flagName, findFlagBy(flagName).defaultValue());
    }

    private Flag findFlagBy(String flagName) {
        return flags.stream()
                .filter((flag -> flag.name().equals(flagName)))
                .findAny().orElse(null);
    }

    private boolean isInValidFlag(String flagName) {
        if (!isValidFlagNamingConventions(flagName)) {
            return true;
        }

        if(findFlagBy(flagName) != null) {
            return false;
        }

        return true;
    }

    private boolean isValidFlagNamingConventions(String flagName) {
        if (flagMustPrecededByMinusSign(flagName) && flagMustBeOneCharacter(flagName)) {
            return true;
        }
        return false;
    }

    private boolean flagMustPrecededByMinusSign(String flagName) {
        return flagName.startsWith(FLAG_NAME_PREFIX);
    }

    private boolean flagMustBeOneCharacter(String flagName) {
        return flagName.matches(VALID_FLAG_NAME_REGEX);
    }
}
