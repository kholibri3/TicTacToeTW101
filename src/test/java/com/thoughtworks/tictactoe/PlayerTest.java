package com.thoughtworks.tictactoe;

import org.junit.Before;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintStream;

import static org.mockito.Mockito.*;

public class PlayerTest {

    private Board board;
    private Player player;
    private BufferedReader reader;
    private PrintStream printStream;

    @Before
    public void setUp() {
        board = mock(Board.class);
        reader = mock(BufferedReader.class);
        printStream = mock(PrintStream.class);
        player = new Player("X", board, reader, printStream);
    }

    @Test
    public void shouldMarkBoardWithXWhenPlayerOneMoves() throws IOException {
        when(reader.readLine()).thenReturn("1");
        when(board.isSquareAvailable(anyInt())).thenReturn(false, true);
        player.move();
        verify(board).updateSquare(0, "X");
    }

    @Test
    public void shouldOnlyUpdateBoardOnceWhenUserTriesToMarkAlreadyTakenSquare() throws IOException {
        when(reader.readLine()).thenReturn("5", "5");
        when(board.isSquareAvailable(anyInt())).thenReturn(false, true);
        player.move();
        verify(board, times(1)).updateSquare(4, "X");
    }

    @Test
    public void shouldPrintInvalidMessageIfPlayerChoosesOccupiedSquareOnBoard() throws Exception {
        when(reader.readLine()).thenReturn("5", "5", "1");
        when(board.isSquareAvailable(anyInt())).thenReturn(false, true, true);
        player.move();
        verify(printStream).println("Sorry, that location is already taken! Please enter a new #.");
    }
}