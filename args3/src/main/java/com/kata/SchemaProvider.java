package com.kata;

import java.util.ArrayList;
import java.util.List;

import com.kata.schema.BooleanSchema;
import com.kata.schema.IntegerSchema;
import com.kata.schema.Schema;
import com.kata.schema.StringSchema;

/**
 * @author sunjing
 */
final class SchemaProvider {

    private static final String VALID_FLAG_NAMING_REGEX = "-[a-zA-Z]+";

    private static final List<Schema> SCHEMAS = new ArrayList<>();

    static {
        SCHEMAS.add(new IntegerSchema());
        SCHEMAS.add(new StringSchema());
        SCHEMAS.add(new BooleanSchema());
    }

    static void registerSchema(Schema schema) {
        SCHEMAS.add(schema);
    }

    static boolean notExistSchemaForFlagName(String flagName) {
        return findByFlagName(flagName) == null;
    }

    static boolean isValidFlagNaming(String flagName) {
        return flagName.matches(VALID_FLAG_NAMING_REGEX);
    }

    static Object defaultValueOfSchema(String flagName) {
        return findByFlagName(flagName).defaultValue();
    }

    static Object parserValueOfSchema(String flagName, String value) {
        return findByFlagName(flagName).parserValue(value);
    }

    private static Schema findByFlagName(String flagName) {
        return SCHEMAS.stream().filter((schema) -> schema.flagName().equals(flagName)).findAny().orElse(null);
    }
}
