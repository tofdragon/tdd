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

    private static final String VALID_FLAG_NAMING_REFEX = "-[a-zA-Z]+";

    private static List<Schema> schemas = new ArrayList<>();

    static {
        schemas.add(new IntegerSchema());
        schemas.add(new StringSchema());
        schemas.add(new BooleanSchema());
    }

    static void registerSchema(Schema schema) {
        schemas.add(schema);
    }

    static boolean notExistSchemaForFlagName(String flagName) {
        return findByFlagName(flagName) == null;
    }

    static boolean isValidFlagNaming(String flagName) {
        return flagName.matches(VALID_FLAG_NAMING_REFEX);
    }

    static Object defaultValueOfSchema(String flagName) {
        return findByFlagName(flagName).defaultValue();
    }

    static Object parserValueOfSchema(String flagName, String value) {
        return findByFlagName(flagName).parserValue(value);
    }

    private static Schema findByFlagName(String flagName) {
        return schemas.stream().filter((schema) -> schema.flagName().equals(flagName)).findAny().orElse(null);
    }
}
