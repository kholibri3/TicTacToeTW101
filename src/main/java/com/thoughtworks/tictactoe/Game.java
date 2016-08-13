package com.thoughtworks.tictactoe;

import java.io.BufferedReader;
import java.io.IOException;

public class Game {

    private Board board;
    private Player playerOne;
    private Player playerTwo;
    private BufferedReader reader;

    public Game(Board board, Player playerOne, Player playerTwo, BufferedReader reader) {
        this.board = board;
        this.playerOne = playerOne;
        this.playerTwo = playerTwo;
        this.reader = reader;
    }

    public void start() throws IOException {
        board.draw();
        System.out.println("Player 1 begins!\n");

        playerOne.move();
        board.draw();
        System.out.println("Player 2's turn.\n");
        playerTwo.move();
        board.draw();
        System.out.println("Player 1's turn.\n");
    }

}
