package com.packtpublishing.tddjava.ch03tictactoe;

/**
 *
 * @author sunjing
 */
public class TicTacToe {

    public void play(int x, int y) {
        if (x < 1 || x > 3) {
            throw new RuntimeException();
        }

        if (y < 1 || y > 3) {
            throw new RuntimeException();
        }
    }
}
