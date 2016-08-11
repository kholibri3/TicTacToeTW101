package com.thoughtworks.tictactoe;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TicTacToe {

    private PrintStream printStream;
    private String currentBoard;
    protected List<String> boardSquares;
    private String playerChoice;
    private BufferedReader reader;

    public TicTacToe(PrintStream printStream, List<String> boardSquares, BufferedReader reader) {
        this.printStream = printStream;
        this.boardSquares = boardSquares;
        this.reader = reader;
    }

    public void playGame() throws IOException {
        processUserMark();
        updateBoard();
    }

    public void initializeBoard() {
        printStream.println("1|2|3\n-----\n4|5|6\n-----\n7|8|9\n");
        boardSquares = new ArrayList<String>(Arrays.asList("1","2","3","4","5","6","7","8","9"));
    }

    public void setBoardSquare(String playerChoice){
        int locationToMark = Integer.parseInt(playerChoice);
        boardSquares.set(locationToMark-1, "X");
    }

    public void processUserMark() throws IOException {
        playerChoice = reader.readLine();
        setBoardSquare(playerChoice);
    }

    public void updateBoard() {
        currentBoard = String.format("%s|%s|%s\n-----\n%s|%s|%s\n-----\n%s|%s|%s\n", boardSquares.toArray());
        printStream.println(currentBoard);
    }
}
