package com.thoughtworks.tictactoe;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintStream;

public class Game {

    private TicTacToe ticTacToe;
    private String playerChoice;
    private BufferedReader reader;
    private PrintStream printStream;
    String currentPlayer;
    private boolean switchPlayer;

    public Game(TicTacToe ticTacToe, BufferedReader reader, PrintStream printStream){
        this.ticTacToe = ticTacToe;
        this.reader = reader;
        this.printStream = printStream;
        switchPlayer = false;
        currentPlayer = "X";
    }

    private void setXOrO() {
        switchPlayer = !switchPlayer;

        if(switchPlayer)
            currentPlayer = "O";
        else
            currentPlayer = "X";

        System.out.println("Switch players! Please enter the # square to place an " + currentPlayer + ".\n");
    }

    private void processUserMark(String playerChoice) throws IOException {
        ticTacToe.setBoardSquare(playerChoice, currentPlayer);
    }

    public void play() throws IOException {
        playerChoice = reader.readLine();

        while(!playerChoice.equals("0")){
            userTakesTurn();
            playerChoice = reader.readLine();
        }
    }

    void userTakesTurn() throws IOException {
        processUserMark(playerChoice);
        ticTacToe.updateBoard();
        setXOrO();
    }
}
