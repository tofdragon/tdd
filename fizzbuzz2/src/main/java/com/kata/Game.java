package com.kata;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author sunjing
 */
public class Game {

    private final List<GameNumber> gameNumbers;

    public Game(int size) {
        this.gameNumbers = new ArrayList<>();
        for (int i = 1; i <= size; i++) {
            this.gameNumbers.add(new GameNumber(i));
        }
    }

    public int size() {
        return this.gameNumbers.size();
    }

    public List<String> words() {
        return this.gameNumbers.stream().map(GameNumber::toString).collect(Collectors.toList());
    }
}
