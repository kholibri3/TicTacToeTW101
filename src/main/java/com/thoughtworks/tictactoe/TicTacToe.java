package com.thoughtworks.tictactoe;

import java.io.PrintStream;

public class TicTacToe {

    private PrintStream printStream;
    private String initialBoard;

    public TicTacToe(PrintStream printStream) {
        this.printStream = printStream;
        initialBoard = "";
    }

    public void initializeBoard() {
        initialBoard = "1|2|3\n-----\n4|5|6\n-----\n7|8|9\n";
        printStream.println(initialBoard);
    }
}
