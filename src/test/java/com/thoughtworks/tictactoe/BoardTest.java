package com.thoughtworks.tictactoe;

import org.junit.Before;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.PrintStream;
import java.util.List;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class BoardTest {

    private PrintStream printStream;
    private Board board;
    private BufferedReader reader;

    @Before
    public void setUp() throws Exception {
        printStream = mock(PrintStream.class);
        reader = mock(BufferedReader.class);
        board = new Board(printStream);
    }

    @Test
    public void shouldPrintInitialGameBoard() throws Exception {
        board.draw();
        verify(printStream).println("1|2|3\n-----\n4|5|6\n-----\n7|8|9\n");
    }

//    @Test
//    public void shouldChangeCorrespondingSquareToXInBoardSquaresWhenUserEntersTheirChoice() throws Exception {
//        when(reader.readLine()).thenReturn("2");
//        ticTacToe.setBoardSquare("2", "X");
//        assertThat(boardSquares.get(1),is("X"));
//    }
//
//    @Test
//    public void shouldPrintUpdatedBoardWithXInsteadOfNumber() throws Exception {
//        when(reader.readLine()).thenReturn("3");
//        boardSquares.set(2,"X");
//        ticTacToe.updateBoard();
//        verify(printStream).println("1|2|X\n-----\n4|5|6\n-----\n7|8|9\n");
//    }
}