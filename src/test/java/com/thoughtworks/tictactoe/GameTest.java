package com.thoughtworks.tictactoe;

import org.junit.Before;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.IOException;

import static org.mockito.Mockito.*;

public class GameTest {

    private Board board;
    private Player playerOne;
    private Player playerTwo;
    private Game game;
    private BufferedReader reader;

    @Before
    public void setUp() {
        board = mock(Board.class);
        playerOne = mock(Player.class);
        playerTwo = mock(Player.class);
        reader = mock(BufferedReader.class);
        game = new Game(board, playerOne, playerTwo, reader);
    }

    @Test
    public void shouldDrawBoardThreeTimesWhenGameStartsAndThenPlayersEachMove() throws IOException {
        game.start();
        verify(board, times(3)).draw();
    }

}