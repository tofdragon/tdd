package com.kata.schema;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import com.kata.Schema;

/**
 * @author sunjing
 */
public final class Schemas {

    private final List<Schema> schemas;

    private Schemas() {
        this.schemas = new ArrayList<>();
    }

    public static Schemas create() {
        return new Schemas();
    }

    public Stream<Schema> stream() {
        return this.schemas.stream();
    }

    public void add(Schema schema) {
        this.schemas.add(schema);
    }
}
