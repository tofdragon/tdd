package com.kata.schema.builder;

import com.kata.schema.BooleanSchema;
import com.kata.schema.IntegerSchema;
import com.kata.schema.ListIntegerSchema;
import com.kata.schema.ListStringSchema;
import com.kata.schema.Schemas;
import com.kata.schema.StringSchema;

/**
 * @author sunjing
 */
public final class SchemasBuilder {

    private final Schemas schemas;

    private SchemasBuilder() {
        schemas = Schemas.create();
    }

    public static SchemasBuilder builder() {
        return new SchemasBuilder();
    }

    public SchemasBuilder booleanSchema(final String flag) {
        schemas.add(new BooleanSchema(flag));
        return this;
    }

    public SchemasBuilder booleanSchema(final String flag, final String defaultValue) {
        schemas.add(new BooleanSchema(flag, defaultValue));
        return this;
    }

    public SchemasBuilder stringSchema(final String flag) {
        schemas.add(new StringSchema(flag));
        return this;
    }

    public SchemasBuilder integerSchema(final String flag) {
        schemas.add(new IntegerSchema(flag));
        return this;
    }

    public SchemasBuilder listIntegerSchema(final String flag) {
        schemas.add(new ListIntegerSchema(flag));
        return this;
    }

    public SchemasBuilder listStringSchema(final String flag) {
        schemas.add(new ListStringSchema(flag));
        return this;
    }

    public Schemas build() {
        return schemas;
    }
}
