package com.kata;

import lombok.Getter;

/**
 * @author sunjing
 */
@Getter
final class Argument<T> {

    private final String flag;

    private final T value;

    Argument(final String flag, final T value) {
        this.flag = flag;
        this.value = value;
    }
}
