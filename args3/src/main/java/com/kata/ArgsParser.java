package com.kata;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

import com.kata.exception.NotExistSchemaException;
import com.kata.schema.Schema;

/**
 * @author sunjing
 */
public final class ArgsParser {

    public ArgsValue parse(String args) {
        return parseArgsValue(new ArgsHolder(args));
    }

    private ArgsValue parseArgsValue(ArgsHolder argsHolder) {
        if (argsHolder.isEmpty()) {
            return null;
        }

        ArgsValue argsValue = new ArgsValue();
        while (argsHolder.isNotEmpty()) {
            String flagName = argsHolder.popCurrent();
            Object value = parseArgValue(argsHolder, flagName);
            argsValue.addValue(flagName, value);
        }
        return argsValue;
    }

    private Object parseArgValue(ArgsHolder argsHolder, String flagName) {
        if (SchemaProvider.notExistSchemaForFlagName(flagName)) {
            throw new NotExistSchemaException(flagName);
        }

        if (argsHolder.isEmpty()) {
            return defaultValueOfArg(flagName);
        }

        String flagNameOrValueOfNext = argsHolder.popNext();
        if (SchemaProvider.isValidFlagNaming(flagNameOrValueOfNext)) {
            argsHolder.renewPush(flagNameOrValueOfNext);
            return defaultValueOfArg(flagName);
        }
        return normalValueOfArg(flagName, flagNameOrValueOfNext);
    }

    private Object defaultValueOfArg(String flagName) {
       return SchemaProvider.defaultValueOfSchema(flagName);
    }

    private Object normalValueOfArg(String flagName, String value) {
        return SchemaProvider.parserValueOfSchema(flagName, value);
    }

    public void registerSchema(Schema schema) {
        SchemaProvider.registerSchema(schema);
    }

    private class ArgsHolder {

        private static final String ARGS_SPLIT_KEY = " ";

        private Stack<String> stack = new Stack<>();

        ArgsHolder(String args) {
            List<String> parsedArgs = Arrays.asList(args.split(ARGS_SPLIT_KEY));
            Collections.reverse(parsedArgs);

            stack.addAll(parsedArgs);
        }

        boolean isEmpty() {
            return stack.isEmpty();
        }

        boolean isNotEmpty() {
            return !isEmpty();
        }

        void renewPush(String arg) {
            stack.push(arg);
        }

        String popCurrent() {
            return stack.pop();
        }

        String popNext() {
            return stack.pop();
        }
    }

}
