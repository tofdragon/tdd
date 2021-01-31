package com.kata.schema;

import java.util.List;
import java.util.stream.DoubleStream;
import java.util.stream.Stream;

import com.kata.Schema;

/**
 * @author sunjing
 */
public final class Schemas {

    private final List<Schema> schemas;

    public Schemas(List<Schema> schemas) {
        this.schemas = schemas;
    }

    public Stream<Schema> stream() {
        return this.schemas.stream();
    }
}
