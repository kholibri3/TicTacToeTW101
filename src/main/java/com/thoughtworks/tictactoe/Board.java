package com.thoughtworks.tictactoe;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Board {

    private PrintStream printStream;
    private List<String> boardSquares = new ArrayList<String>(Arrays.asList(" "," "," "," "," "," "," "," "," "));

    public Board(PrintStream printStream, List<String> boardSquares) {
        this.printStream = printStream;
        this.boardSquares = boardSquares;
    }

    public void draw() {
        String currentBoard = String.format(
                "%s|%s|%s\n" +
                "-----\n" +
                "%s|%s|%s\n" +
                "-----\n" +
                "%s|%s|%s\n", boardSquares.toArray());
        printStream.println(currentBoard);
    }

    public void updateSquare(int squareToMark, String symbol) {
        boardSquares.set(squareToMark, symbol);
    }

    public boolean squareIsFree(int squareToMark) {
        System.out.println(boardSquares.get(squareToMark-1));
        return boardSquares.get(squareToMark - 1).equals(" ");
    }
}
