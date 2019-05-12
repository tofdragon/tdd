package com.kata;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

import com.kata.exception.NotExistSchemaException;

/**
 * 参数解析
 *
 * @author sunjing
 */
public final class ArgsParser {

    private ParsedArgs parsedArgs = new ParsedArgs();

    private SchemaProvider schemaProvider = new SchemaProvider();

    public void parse(String args) {
        Stack<String> argsStack = toArgsStack(args);
        while (!argsStack.empty()) {
            String flagName = argsStack.pop();
            parseArg(argsStack, flagName);
        }
    }

    public Object getValue(String flagName) {
        return parsedArgs.getValue(flagName);
    }

    public String getStringValue(String flagName) {
        Object value = getValue(flagName);
        if (value == null) {
            return null;
        }
        return String.valueOf(value);
    }

    public Boolean getBooleanValue(String flagName) {
        Object value = getValue(flagName);
        return value == null ? null : Boolean.valueOf(value.toString());
    }

    public Integer getIntegerValue(String flagName) {
        Object value = getValue(flagName);
        return value == null ? null : Integer.valueOf(value.toString());
    }

    public void registerScheme(Schema schema) {
        schemaProvider.registerScheme(schema);
    }

    private Stack<String> toArgsStack(String args) {
        List<String> parserArgs = Arrays.asList(args.split(" "));
        Collections.reverse(parserArgs);

        Stack<String> stack = new Stack<>();
        stack.addAll(parserArgs);
        return stack;
    }

    private void parseArg(Stack<String> argsStack, String flagName) {
        if (schemaProvider.isInValidSchema(flagName)) {
            throw new NotExistSchemaException("不合法的Schema");
        }

        Schema schema = schemaProvider.findSchemaBy(flagName);
        if (argsStack.empty()) {
            addDefaultValueOfSchema(schema);
            return;
        }

        String flagNameOrValue = argsStack.pop();
        if (schemaProvider.isValidSchemaFlagName(flagNameOrValue)
                && schemaProvider.isInValidSchema(flagNameOrValue)) {
            throw new NotExistSchemaException("不合法的Schema");
        }

        if (schemaProvider.isValidSchemaFlagName(flagNameOrValue)) {
            argsStack.push(flagNameOrValue);
            addDefaultValueOfSchema(schema);
            return;
        }

        addArgValue(schema, flagNameOrValue);
    }

    private void addDefaultValueOfSchema(Schema schema) {
        parsedArgs.addArg(schema.flagName(), schema.defaultValue());
    }

    private void addArgValue(Schema schema, String value) {
        parsedArgs.addArg(schema.flagName(), schema.parseValue(value));
    }
}
