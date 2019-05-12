package com.kata;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;

import com.kata.exception.NotExistSchemaException;

/**
 * 参数解析
 *
 * @author sunjing
 */
public final class ArgsParser {

    private Map<String, Object> argToValue = new HashMap<>();

    private SchemaProvider schemaProvider = new SchemaProvider();

    public void parser(String args) {
        Stack<String> argsStack = toArgsStack(args);
        while (!argsStack.empty()) {
            String flagOfSchema = argsStack.pop();
            parserArg(argsStack, flagOfSchema);
        }
    }

    public Object getValue(String schemaFlag) {
        return argToValue.get(schemaFlag);
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

    private void parserArg(Stack<String> argsStack, String flagOfSchema) {
        if (schemaProvider.isInValidSchema(flagOfSchema)) {
            throw new NotExistSchemaException("不合法的Schema");
        }

        Schema schema = schemaProvider.schemaByFlag(flagOfSchema);
        if (argsStack.empty()) {
            addDefaultValueOfSchema(schema);
            return;
        }

        String flagOrValueOfSchema = argsStack.pop();
        if (schemaProvider.isValidSchemeFlagName(flagOrValueOfSchema)
                && schemaProvider.isInValidSchema(flagOrValueOfSchema)) {
            throw new NotExistSchemaException("不合法的Schema");
        }

        if (schemaProvider.isValidSchemeFlagName(flagOrValueOfSchema)) {
            argsStack.push(flagOrValueOfSchema);
            addDefaultValueOfSchema(schema);
            return;
        }

        addArgValue(schema, flagOrValueOfSchema);
    }

    private void addDefaultValueOfSchema(Schema schema) {
        argToValue.put(schema.flag(), schema.defaultValue());
    }

    private void addArgValue(Schema schema, String value) {
        argToValue.put(schema.flag(), schema.parserValue(value));
    }
}
