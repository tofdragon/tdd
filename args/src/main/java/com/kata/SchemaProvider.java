package com.kata;

import java.util.ArrayList;
import java.util.List;

import com.kata.schema.BooleanSchema;
import com.kata.schema.IntegerSchema;
import com.kata.schema.StringSchema;

/**
 * Schema的提供者
 *
 * @author sunjing
 */
final class SchemaProvider {

    private static List<Schema> schemas = new ArrayList<>();

    /**
     * 标记的前缀
     */
    private static final String FLAG_NAME_PREFIX = "-";

    /**
     * 标记的名字必须是字母
     */
    private static final String VALID_FLAG_NAME_REGEX = "-[a-zA-Z]+";

    static {
        schemas.add(new BooleanSchema());
        schemas.add(new IntegerSchema());
        schemas.add(new StringSchema());
    }

    void registerScheme(Schema schema) {
        schemas.add(schema);
    }

    Schema findSchemaBy(String flagName) {
        return schemas.stream()
                .filter((schema) -> schema.flagName().equals(flagName))
                .findAny().orElse(null);
    }

    boolean isValidSchema(String schemaFlagName) {
        if (!isValidSchemaFlagName(schemaFlagName)) {
            return false;
        }
        return findSchemaBy(schemaFlagName) == null ? false : true;
    }

    boolean isInValidSchema(String schemaFlagName) {
        return !isValidSchema(schemaFlagName);
    }

    boolean isValidSchemaFlagName(String schemaFlagName) {
        if (schemaFlagNameMustPrecededByMinusSign(schemaFlagName)
                && schemaFlagNameMustBeOneCharacter(schemaFlagName)) {
            return true;
        }
        return false;
    }

    private boolean schemaFlagNameMustPrecededByMinusSign(String schemaFlagName) {
        return schemaFlagName.startsWith(FLAG_NAME_PREFIX);
    }

    private boolean schemaFlagNameMustBeOneCharacter(String schemaFlagName) {
        return schemaFlagName.matches(VALID_FLAG_NAME_REGEX);
    }
}
