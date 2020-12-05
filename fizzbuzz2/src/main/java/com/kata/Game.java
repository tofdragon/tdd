package com.kata;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * @author sunjing
 */
public class Game {

    private final List<GameNumber> gameNumbers;

    public Game(int size) {
        gameNumbers = new ArrayList<>();
        IntStream.range(1, size + 1).forEach(rawNumber -> gameNumbers.add(new GameNumber(rawNumber)));
    }

    public List<String> words() {
        return gameNumbers.stream().map(GameNumber::toString).collect(Collectors.toList());
    }
}
