package com.kata;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum Answer {

    FIZZ("Fizz"),

    BUZZ("Buzz"),

    FIZZ_BUZZ("FizzBuzz");

    private String answer;
}
