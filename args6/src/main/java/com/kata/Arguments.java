package com.kata;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.kata.exception.DoesNotExistFlagValueException;

/**
 * @author sunjing
 */
public final class Arguments {

    private final List<Argument> items;

    public Arguments() {
        items = new ArrayList<>();
    }

    public void add(Argument argument) {
        this.items.add(argument);
    }

    public <T> T getValue(String flag) {
        Optional<Argument> argumentOptional =
                this.items.stream().filter(argument -> argument.getFlag().equals(flag)).findFirst();
        if (argumentOptional.isPresent()) {
            return (T) argumentOptional.get().getValue();
        }

        throw new DoesNotExistFlagValueException(flag);
    }
}
