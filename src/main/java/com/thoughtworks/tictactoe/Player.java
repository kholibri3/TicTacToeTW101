package com.thoughtworks.tictactoe;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintStream;

public class Player {

    private String symbol;
    private Board board;
    private BufferedReader reader;
    private int squareToMark;
    private PrintStream printStream;

    public Player(String symbol, Board board, BufferedReader reader, PrintStream printStream) {
        this.symbol = symbol;
        this.board = board;
        this.reader = reader;
        this.printStream = printStream;
    }

    public void move() throws IOException {
        squareToMark = Integer.parseInt(reader.readLine());
        if(!board.squareIsFree(squareToMark)) {
            System.out.println("in while");
            printStream.println("Sorry, that location is already taken! Please enter a new #.");
            squareToMark = Integer.parseInt(reader.readLine());
        }
        board.updateSquare(squareToMark-1, symbol);
    }

}
