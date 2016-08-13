package com.thoughtworks.tictactoe;

import org.junit.Before;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintStream;

import static org.mockito.Mockito.*;

public class PlayerTest {

    private Board board;
    private Player playerOne;
    private Player playerTwo;
    private BufferedReader reader;
    private PrintStream printStream;

    @Before
    public void setUp() {
        board = mock(Board.class);
        reader = mock(BufferedReader.class);
        printStream = mock(PrintStream.class);
        playerOne = new Player("X", board, reader, printStream);
        playerTwo = new Player("O", board, reader, printStream);
    }

    @Test
    public void shouldMarkBoardWithXWhenPlayerOneMoves() throws IOException {
        when(reader.readLine()).thenReturn("1");
        playerOne.move();
        verify(board).updateSquare(0, "X");
    }

    @Test
    public void shouldMarkBoardWithOWhenPlayerTwoMoves() throws IOException {
        when(reader.readLine()).thenReturn("3");
        playerTwo.move();
        verify(board).updateSquare(2, "O");
    }

    @Test
    public void shouldPrintInvalidMessageIfPlayerChoosesOccupiedSquareOnBoard() throws IOException {
        when(reader.readLine()).thenReturn("3", "3");
        playerOne.move();
        playerTwo.move();
        verify(printStream).println("Sorry, that location is already taken! Please enter a new #.");
    }
}