package com.thoughtworks.tictactoe;

import org.junit.Before;
import org.junit.Test;

import java.io.PrintStream;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class TicTacToeTest {

    private PrintStream printStream;
    private TicTacToe ticTacToe;

    @Before
    public void setUp() throws Exception {
        printStream = mock(PrintStream.class);
        ticTacToe = new TicTacToe(printStream);
    }

    @Test
    public void shouldPrintInitialGameBoardWhenTicTacToeInitialized() throws Exception {
        ticTacToe.initializeBoard();
        verify(printStream).println("1|2|3\n-----\n4|5|6\n-----\n7|8|9\n");
    }

}