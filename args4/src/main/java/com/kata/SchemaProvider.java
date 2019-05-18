package com.kata;

import java.util.ArrayList;
import java.util.List;

import com.kata.schema.Schema;

/**
 * @author sunjing
 */
final class SchemaProvider {

    private static List<Schema> schemas = new ArrayList<>();

    static {
        addIntegerSchema();
        addStringSchema();
        addBooleanSchema();
    }

    private static void addBooleanSchema() {
        schemas.add(new Schema() {
            @Override
            public String flagName() {
                return "-i";
            }

            @Override
            public Object defaultValue() {
                return 0;
            }

            @Override
            public Object parseValue(String value) {
                return Integer.parseInt(value);
            }
        });
    }

    private static void addStringSchema() {
        schemas.add(new Schema() {
            @Override
            public String flagName() {
                return "-s";
            }

            @Override
            public Object defaultValue() {
                return "";
            }

            @Override
            public Object parseValue(String value) {
                return value;
            }
        });
    }

    private static void addIntegerSchema() {
        schemas.add(new Schema() {
            @Override
            public String flagName() {
                return "-l";
            }

            @Override
            public Object defaultValue() {
                return false;
            }

            @Override
            public Object parseValue(String value) {
                return Boolean.valueOf(value);
            }
        });
    }

    static boolean isNotExistSchema(String flagName) {
        return findSchemaByFlagName(flagName) == null;
    }

    static boolean validFlagName(String flagName) {
        return flagName.matches("-[a-zA-Z]+");
    }

    static Object defaultValueOfSchema(String flagName) {
        return findSchemaByFlagName(flagName).defaultValue();
    }

    static void register(Schema schema) {
        schemas.add(schema);
    }

    private static Schema findSchemaByFlagName(String flagName) {
        return schemas.stream()
                .filter((schema -> schema.flagName().equals(flagName)))
                .findAny()
                .orElse(null);
    }
}
