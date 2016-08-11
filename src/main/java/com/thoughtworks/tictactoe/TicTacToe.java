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

    public TicTacToe(PrintStream printStream, List<String> boardSquares) {
        this.printStream = printStream;
        this.boardSquares = boardSquares;
    }

    public void initializeBoard() {
        printStream.println("1|2|3\n-----\n4|5|6\n-----\n7|8|9\n");
        boardSquares = new ArrayList<String>(Arrays.asList("1","2","3","4","5","6","7","8","9"));
    }

    protected void setBoardSquare(String playerChoice, String mark){
        int locationToMark = Integer.parseInt(playerChoice);
        boardSquares.set(locationToMark-1, mark);
    }

    protected void updateBoard() {
        currentBoard = String.format("%s|%s|%s\n-----\n%s|%s|%s\n-----\n%s|%s|%s\n", boardSquares.toArray());
        printStream.println(currentBoard);
    }
}
