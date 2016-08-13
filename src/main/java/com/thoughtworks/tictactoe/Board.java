package com.thoughtworks.tictactoe;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Board {

    private PrintStream printStream;
    private List<String> boardSquares;

    public Board(PrintStream printStream) {
        this.printStream = printStream;
        this.boardSquares = new ArrayList<String>(Arrays.asList("1","2","3","4","5","6","7","8","9"));
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

}
