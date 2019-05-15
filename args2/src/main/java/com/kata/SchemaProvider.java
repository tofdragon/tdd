package com.kata;

import java.util.ArrayList;
import java.util.List;

import com.kata.schema.BooleanSchema;
import com.kata.schema.IntegerSchema;
import com.kata.schema.PortSchema;
import com.kata.schema.Schema;
import com.kata.schema.StringSchema;

/**
 * Schema提供者
 *
 * @author sunjing
 */
final class SchemaProvider {

    /**
     * Flags should be one character, preceded by a minus sign
     */
    private static final String VALID_FLAG_NAME_NAMING_REGEX = "-[a-zA-Z]+";

    private static List<Schema> schemas = new ArrayList<>();

    static {
        addSchema(new IntegerSchema());
        addSchema(new BooleanSchema());
        addSchema(new StringSchema());
        addSchema(new PortSchema());
    }

    static void addSchema(Schema schema) {
        schemas.add(schema);
    }

    static Schema findSchemaBy(String flagName) {
        return schemas.stream()
                .filter((schema) -> schema.flagName().equals(flagName))
                .findAny().orElse(null);
    }

    static boolean isInValidSchemeWith(String flagName) {
        return findSchemaBy(flagName) == null;
    }

    static boolean isValidFlagNameNamingConventions(String flagName) {
        return flagName.matches(VALID_FLAG_NAME_NAMING_REGEX);
    }
}
