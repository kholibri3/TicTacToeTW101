package com.thoughtworks.tictactoe;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException {
        System.out.println("~ Welcome to Tic Tac Toe ~");
        System.out.println("Please enter a # 1-9 to choose which square to mark.\n");

        PrintStream printStream = new PrintStream(System.out);
        Board board = boardSetup(printStream);
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        Player playerOne = new Player("X", board, reader, printStream);
        Player playerTwo = new Player("O", board, reader, printStream);

        Game game = new Game(board, playerOne, playerTwo, reader);
        game.start();
    }

    private static Board boardSetup(PrintStream printStream) {
        List<String> boardSquares = new ArrayList<String>(Arrays.asList(" "," "," "," "," "," "," "," "," "));
        return new Board(printStream, boardSquares);
    }
}
