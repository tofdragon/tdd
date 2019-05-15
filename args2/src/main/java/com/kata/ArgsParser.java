package com.kata;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

import com.kata.exception.InValidSchemaException;
import com.kata.schema.Schema;
import com.kata.value.Value;

/**
 * 参数解析器
 *
 * @author sunjing
 */
public final class ArgsParser {

    private ArgsValue argsValue = new ArgsValue();

    public void parse(String args) {
        Stack<String> argsStack = toArgsStack(args);
        while (!argsStack.empty()) {
            parseArg(argsStack);
        }
    }

    public void registerSchema(Schema schema) {
        SchemaProvider.addSchema(schema);
    }

    private Stack<String> toArgsStack(String args) {
        List<String> parserArgs = Arrays.asList(args.split(ParserConfig.ARG_FLAG_SPLIT.getValue()));
        Collections.reverse(parserArgs);

        Stack<String> stack = new Stack<>();
        stack.addAll(parserArgs);
        return stack;
    }

    private void parseArg(Stack<String> argsStack) {
        String flagName = argsStack.pop();
        if (SchemaProvider.isInValidSchemeWith(flagName)) {
            throw new InValidSchemaException(flagName);
        }

        if (argsStack.isEmpty()) {
            addDefaultValue(flagName);
            return;
        }

        String flagValueOrNextFlagName = argsStack.pop();
        if (SchemaProvider.isValidFlagNameNamingConventions(flagValueOrNextFlagName)) {
            addDefaultValue(flagName);
            argsStack.push(flagValueOrNextFlagName);
            return;
        }

        addArgsValue(flagName, SchemaProvider.findSchemaBy(flagName).parseValue(flagValueOrNextFlagName));
    }

    private void addDefaultValue(String currentFlagName) {
        addArgsValue(currentFlagName, SchemaProvider.findSchemaBy(currentFlagName).defaultValue());
    }

    private void addArgsValue(String flagName, Value value) {
        argsValue.addValue(flagName, value);
    }

    public boolean getBooleanValue(String flagName) {
        return argsValue.getBooleanValue(flagName);
    }

    public String getStringValue(String flagName) {
        return argsValue.getStringValue(flagName);
    }

    public int getIntegerValue(String flagName) {
        return argsValue.getIntegerValue(flagName);
    }

    public List getListValue(String flagName) {
        return argsValue.getListValue(flagName);
    }
}
