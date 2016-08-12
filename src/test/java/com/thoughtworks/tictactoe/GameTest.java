package com.thoughtworks.tictactoe;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.PrintStream;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.*;

public class GameTest {

    private BufferedReader reader;
    TicTacToe ticTacToe;
    PrintStream printStream;
    Game game;

    @Before
    public void setUp() throws Exception {
        reader = mock(BufferedReader.class);
        ticTacToe = mock(TicTacToe.class);
        printStream = mock(PrintStream.class);
        game = new Game(ticTacToe, reader, printStream);
    }

    @Test
    public void shouldCheckThatBoardSquareHasBeenChangedWhenPlayerDoesAMove() throws Exception {
        game.userTakesTurn();
        //assert that board squares contains X? user input has been processed
        verify(ticTacToe).updateBoard();
    }

    @Test
    public void whenPlayersSwitchNewPlayerShouldBeMarkingDifferentlyOnBoard() throws Exception {
        assertThat(game.currentPlayer, is("X"));
        game.userTakesTurn();
        assertThat(game.currentPlayer, is("O"));
    }

    @Test
    @Ignore
    public void shouldPrintSameBoardSquaresBeforeAndAfterBecauseSquareChosenIsOccupied() throws Exception {
        String sampleBoard = "1|2|X\n-----\n4|5|6\n-----\n7|8|9\n";
        assertThat(sampleBoard, is("1|2|X\n-----\n4|5|6\n-----\n7|8|9\n"));
        game.userTakesTurn();
        assertThat(sampleBoard, is("1|2|X\n-----\n4|5|6\n-----\n7|8|9\n"));
    }

    @Test
    @Ignore
    public void shouldKeepPromptingUserToGiveInputWhenTheyChooseAnOccupiedSquare() throws Exception {
//        ticTacToe.setBoardSquare("1", "X");
        when(reader.readLine()).thenReturn("1", "1", "2");
        game.play();
        verify(ticTacToe).updateBoard();
    }
}