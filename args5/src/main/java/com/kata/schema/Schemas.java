package com.kata.schema;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

/**
 * schema
 *
 * @author sunjing
 */
public class Schemas {

    private final List<Schema> schemas;

    private Schemas() {
        this.schemas = new ArrayList<>();
    }

    public static Schemas create() {
        return new Schemas();
    }

    public Stream<Schema> schemasStream() {
        return this.schemas.stream();
    }

    public void add(Schema schema) {
        this.schemas.add(schema);
    }

    public int size() {
        return (int) schemasStream().count();
    }

    public boolean isFlag(String flag) {
        return schemasStream().anyMatch(schema -> schema.flag().equals(flag));
    }
}
