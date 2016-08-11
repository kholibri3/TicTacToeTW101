package com.thoughtworks.tictactoe;

import java.io.BufferedReader;
import java.io.IOException;

public class Game {

    private TicTacToe ticTacToe;
    private String playerChoice;
    private BufferedReader reader;
    private String currentPlayer;
    private boolean switchPlayer;

    public Game(TicTacToe ticTacToe, BufferedReader reader){
        this.ticTacToe = ticTacToe;
        this.reader = reader;
        currentPlayer = "X";
    }

    private void switchPlayer() {
        if(switchPlayer)
            currentPlayer = "X";
        else
            currentPlayer = "O";
    }

    public void play() throws IOException {
        switchPlayer = true;
        processUserMark();
        ticTacToe.updateBoard();
        switchPlayer = false;
        switchPlayer();
    }

    private void processUserMark() throws IOException {
        playerChoice = reader.readLine();
        ticTacToe.setBoardSquare(playerChoice, currentPlayer);
    }
}
