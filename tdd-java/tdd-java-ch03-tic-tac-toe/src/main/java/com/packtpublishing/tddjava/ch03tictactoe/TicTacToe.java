package com.packtpublishing.tddjava.ch03tictactoe;

/**
 *
 * @author sunjing
 */
public class TicTacToe {

    private Character[][] board = {{'\0', '\0', '\0'}, {'\0', '\0', '\0'}, {'\0', '\0', '\0'}};

    private String player = "X";

    public void play(int x, int y) {
        checkAxis(x);
        checkAxis(y);
        setBox(x, y);
        goNextPlayer();
    }

    private void goNextPlayer() {
        if (player == "X") {
            player = "O";
        } else if (player == "O") {
            player = "X";
        }
    }

    private void checkAxis(int axis) {
        if (axis <1 || axis > 3) {
            throw new RuntimeException("X is outside board");
        }
    }

    private void setBox(int x, int y) {
        if (board[x - 1][y - 1] != '\0') {
            throw new RuntimeException("Box is occupied");
        } else {
            board[x - 1][y - 1] = 'X';
        }
    }

    public String nextPlayer() {
        return player;
    }
}
