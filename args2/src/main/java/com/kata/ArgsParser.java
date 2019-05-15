package com.kata;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;

import com.kata.schema.BooleanSchema;
import com.kata.schema.IntegerSchema;
import com.kata.schema.PortSchema;
import com.kata.schema.Schema;
import com.kata.schema.StringSchema;

/**
 * 参数解析器
 *
 * @author sunjing
 */
public final class ArgsParser {

    private static List<Schema> schemas = new ArrayList<>();

    private Map<String, Object> flagNameToValue = new HashMap<>();

    static {
        schemas.add(new IntegerSchema());
        schemas.add(new BooleanSchema());
        schemas.add(new StringSchema());
        schemas.add(new PortSchema());
    }

    public void parse(String args) {
        Stack<String> argsStack = toArgsStack(args);
        while (!argsStack.empty()) {
            parseArg(argsStack);
        }
    }

    public void registerSchema(Schema schema) {
        schemas.add(schema);
    }

    private Stack<String> toArgsStack(String args) {
        List<String> parserArgs = Arrays.asList(args.split(" "));
        Collections.reverse(parserArgs);

        Stack<String> stack = new Stack<>();
        stack.addAll(parserArgs);
        return stack;
    }

    private void parseArg(Stack<String> argsStack) {
        String currentFlagName = argsStack.pop();

        if (findSchemaBy(currentFlagName) == null) {
            throw new RuntimeException("不合法的Schema");
        }

        if (argsStack.isEmpty()) {
            addDefaultValue(currentFlagName);
            return;
        }

        String flagValueOrNextFlagName = argsStack.pop();
        if (flagValueOrNextFlagName.matches("-[a-zA-Z]+")) {
            addDefaultValue(currentFlagName);
            argsStack.push(flagValueOrNextFlagName);
            return;
        }

        flagNameToValue.put(currentFlagName, findSchemaBy(currentFlagName).parseValue(flagValueOrNextFlagName));
    }

    private void addDefaultValue(String currentFlagName) {
        flagNameToValue.put(currentFlagName, findSchemaBy(currentFlagName).defaultValue());
    }

    private Schema findSchemaBy(String flagName) {
        return schemas.stream()
                .filter((schema) -> schema.flagName().equals(flagName))
                .findAny().orElse(null);
    }

    public boolean getBooleanValue(String flagName) {
        Object value = flagNameToValue.get(flagName);
        return value == null ? false : Boolean.valueOf(value.toString());
    }

    public String getStringValue(String flagName) {
        Object value = flagNameToValue.get(flagName);
        return value == null ? null : value.toString();
    }

    public int getIntegerValue(String flagName) {
        Object value = flagNameToValue.get(flagName);
        return value == null ? null : Integer.parseInt(value.toString());
    }

    public List<Object> getListValue(String flagName) {
        Object value = flagNameToValue.get(flagName);
        return value == null ? null : (List) (value);
    }
}
