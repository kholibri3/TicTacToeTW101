package com.thoughtworks.tictactoe;

import org.junit.Test;

import java.io.BufferedReader;
import java.io.PrintStream;

import static org.mockito.Matchers.contains;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class GameTest {

    @Test
    public void shouldPrintBoardToShowThatWhenPlayIsCalledTheBoardChanges() throws Exception {
        BufferedReader reader = mock(BufferedReader.class);
        TicTacToe ticTacToe = mock(TicTacToe.class);
        PrintStream printStream = mock(PrintStream.class);
        Game game = new Game(ticTacToe, reader);

        // not working
        game.play();
        verify(printStream).println(contains("X"));
    }
}