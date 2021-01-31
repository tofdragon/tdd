package com.kata;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import com.kata.exception.DoesNotExistFlagValueException;

/**
 * @author sunjing
 */
public final class Arguments {

    private final List<Argument> items;

    public Arguments() {
        items = new ArrayList<>();
    }

    public <T> void add(String flag, T value) {
        this.items.add(new Argument(flag, value));
    }

    public <T> T getValue(String flag) {
        return (T) this.items.stream()
                .filter(argument -> argument.getFlag().equals(flag)).findFirst()
                .orElseThrow(() -> new DoesNotExistFlagValueException(flag))
                .getValue();
    }

    public Stream<Argument> stream() {
        return items.stream();
    }
}
