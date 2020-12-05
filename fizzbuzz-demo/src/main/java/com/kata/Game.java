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
        IntStream.range(1, size + 1).forEach(number -> gameNumbers.add(new GameNumber(number)));
    }

    public int size() {
        return gameNumbers.size();
    }

    public List<String> words() {
        return gameNumbers.stream().map(GameNumber::toString).collect(Collectors.toList());
    }
}
