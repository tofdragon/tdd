package com.packtpublishing.tddjava.ch03tictactoe;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author sunjing
 */
public class TicTacToe {

    private Character[][] board = {{'\0', '\0', '\0'}, {'\0', '\0', '\0'}, {'\0', '\0', '\0'}};

    public void play(int x, int y) {
        if (x < 1 || x > 3) {
            throw
                    new RuntimeException("X is outside board");
        } else if (y < 1 || y > 3) {
            throw
                    new RuntimeException("Y is outside board");
        }
        if (board[x - 1][y - 1] != '\0') {
            throw
                    new RuntimeException("Box is occupied");
        } else {
            board[x - 1][y - 1] = 'X';
        }
    }
}
