package com.thoughtworks.tictactoe;

import org.junit.Before;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class TicTacToeTest {

    private PrintStream printStream;
    private TicTacToe ticTacToe;
    private List<String> boardSquares;
    private BufferedReader reader;

    @Before
    public void setUp() throws Exception {
        printStream = mock(PrintStream.class);
        reader = mock(BufferedReader.class);
        boardSquares = new ArrayList<String>(Arrays.asList("1","2","3","4","5","6","7","8","9"));
        ticTacToe = new TicTacToe(printStream, boardSquares);
    }

    @Test
    public void shouldPrintInitialGameBoardWhenTicTacToeInitialized() throws Exception {
        ticTacToe.initializeBoard();
        verify(printStream).println("1|2|3\n-----\n4|5|6\n-----\n7|8|9\n");
    }

    @Test
    public void shouldChangeCorrespondingSquareInBoardSquaresWhenUserEntersTheirChoice() throws Exception {
        when(reader.readLine()).thenReturn("2");
        ticTacToe.setBoardSquare("2", "X");
        assertThat(ticTacToe.boardSquares.get(1),is("X"));
    }

    @Test
    public void shouldPrintUpdatedBoardWithXInsteadOfNumber() throws Exception {
        when(reader.readLine()).thenReturn("3");
        boardSquares.set(2,"X");
        ticTacToe.updateBoard();
        verify(printStream).println("1|2|X\n-----\n4|5|6\n-----\n7|8|9\n");
    }
}