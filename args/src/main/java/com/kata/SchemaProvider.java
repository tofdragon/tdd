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

    static {
        schemas.add(new BooleanSchema());
        schemas.add(new IntegerSchema());
        schemas.add(new StringSchema());
    }

    void registerScheme(Schema schema) {
        schemas.add(schema);
    }

    boolean isValidSchema(String schemaFlag) {
        if (!isValidSchemeFlagName(schemaFlag)) {
            return false;
        }

        return schemaByFlag(schemaFlag) == null ? false : true;
    }

    boolean isInValidSchema(String schemaFlag) {
        return !(isValidSchema(schemaFlag));
    }

    boolean isValidSchemeFlagName(String schemaFlag) {
        if (schemaFlag.startsWith("-") && schemaFlag.matches("-[a-zA-Z]+")) {
            return true;
        }
        return false;
    }

    Schema schemaByFlag(String flag) {
        return schemas.stream()
                .filter((schema) -> schema.flag().equals(flag))
                .findAny().orElse(null);
    }
}
