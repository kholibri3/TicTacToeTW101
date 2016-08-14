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

public class BoardTest {

    private PrintStream printStream;
    private Board board;
    private BufferedReader reader;
    private List<String> boardSquares;

    @Before
    public void setUp() {
        printStream = mock(PrintStream.class);
        reader = mock(BufferedReader.class);
        boardSquares = new ArrayList<String>(Arrays.asList("1","2","3","4","5","6","7","8","9"));
        board = new Board(printStream, boardSquares);
    }

    @Test
    public void shouldPrintInitialGameBoard() {
        board.draw();
        verify(printStream).println("1|2|3\n-----\n4|5|6\n-----\n7|8|9\n");
    }

    @Test
    public void shouldChangeCorrespondingSquareToXInBoardSquares() {
        board.updateSquare(2, "X");
        assertThat(boardSquares.get(2), is("X"));
    }

}