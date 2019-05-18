package com.kata;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

import com.kata.schema.Schema;

/**
 * @author sunjing
 */
public final class ArgsParser {

    public ArgsValue parse(String args) {
        Stack<String> stack = toParsedArgs(args);
        return parseArgsValue(stack);
    }

    private ArgsValue parseArgsValue(Stack<String> stack) {
        ArgsValue argsValue = new ArgsValue();
        while(!stack.isEmpty()) {
            parseArgValue(stack, argsValue);
        }
        return argsValue;
    }

    private void parseArgValue(Stack<String> stack, ArgsValue argsValue) {
        String flagName = stack.pop();

        if (SchemaProvider.isNotExistSchema(flagName)) {
            throw new RuntimeException("不合法的schema");
        }

        if (stack.isEmpty()) {
            addDefaultValue(argsValue, flagName);
            return;
        }

        String flagNameOrValue = stack.pop();
        if (SchemaProvider.validFlagName(flagNameOrValue)) {
            stack.push(flagNameOrValue);
            addDefaultValue(argsValue, flagName);
            return;
        }
        argsValue.addValue(flagName, flagNameOrValue);
    }

    private Stack<String> toParsedArgs(String args) {
        List<String> parsedArgs = Arrays.asList(args.split(" "));
        Collections.reverse(parsedArgs);

        Stack<String> stack = new Stack<>();
        stack.addAll(parsedArgs);
        return stack;
    }

    private void addDefaultValue(ArgsValue argsValue, String flagName) {
        argsValue.addValue(flagName, SchemaProvider.defaultValueOfSchema(flagName));
    }

    public void registerSchema(Schema schema) {
        SchemaProvider.register(schema);
    }
}
