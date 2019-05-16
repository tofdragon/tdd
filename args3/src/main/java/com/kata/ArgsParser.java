package com.kata;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;

public final class ArgsParser {

    private static Map<String, Object> flagNameToDefaultValue = new HashMap<>();

    private Map<String, Object> flagNameToValue = new HashMap<>();

    static {
        flagNameToDefaultValue.put("-i", 0);
        flagNameToDefaultValue.put("-s", "");
        flagNameToDefaultValue.put("-l", false);
    }

    public void parse(String args) {
        Stack<String> argsStack = toArgsStack(args);
        while (!argsStack.empty()) {
            parseArg(argsStack);
        }
    }

    public void registerSchema(String flagName, Object defaultValue) {
        flagNameToDefaultValue.put(flagName, defaultValue);
    }

    private void parseArg(Stack<String> argsStack) {
        String flagName = argsStack.pop();

        if (notExistFlag(flagName)) {
            throw new RuntimeException("不合法的Schema");
        }

        if (argsStack.isEmpty()) {
            addDefaultValue(flagName);
            return;
        }

        String flagNameOrValue = argsStack.pop();
        if (isValidFlag(flagNameOrValue)) {
            addDefaultValue(flagName);
            argsStack.push(flagNameOrValue);
            return;
        }
        flagNameToValue.put(flagName, flagNameOrValue);
    }

    private boolean isValidFlag(String flagNameOrValue) {
        return flagNameOrValue.matches("-[a-zA-Z]+");
    }

    private boolean notExistFlag(String flagName) {
        return !flagNameToDefaultValue.containsKey(flagName);
    }

    private void addDefaultValue(String flagName) {
        flagNameToValue.put(flagName, flagNameToDefaultValue.get(flagName));
    }

    private Stack<String> toArgsStack(String args) {
        List<String> parserArgs = Arrays.asList(args.split(" "));
        Collections.reverse(parserArgs);

        Stack<String> stack = new Stack<>();
        stack.addAll(parserArgs);
        return stack;
    }

    public boolean getBooleanValue(String flagName) {
        return Boolean.valueOf(flagNameToValue.get(flagName).toString());
    }

    public String getStringValue(String flagName) {
        return flagNameToValue.get(flagName).toString();
    }

    public int getIntegerValue(String flagName) {
        return Integer.parseInt(flagNameToValue.get(flagName).toString());
    }
}
