package com.packtpublishing.tddjava.ch03tictactoe;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

/**
 *
 * @author sunjing
 */
public class TicTacToeSpec {

    @Rule
    public ExpectedException exception = ExpectedException.none();

    private TicTacToe ticTacToe;

    @Before
    public final void before() {
        ticTacToe = new TicTacToe();
    }

    @Test
    public void whenXOutsideBoardThenRuntimeException()
    {
        exception.expect(RuntimeException.class);
        ticTacToe.play(5, 2);
    }
}
