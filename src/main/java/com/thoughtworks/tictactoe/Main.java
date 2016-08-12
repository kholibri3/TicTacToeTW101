package com.thoughtworks.tictactoe;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        System.out.println("~ Welcome to Tic Tac Toe ~");
        System.out.println("Press '0' at any time to quit.\n");
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        List<String> boardSquares = new ArrayList<String>();

        TicTacToe ticTacToeBoard = new TicTacToe(System.out, boardSquares);
        Game game = new Game(ticTacToeBoard, reader, System.out);
        ticTacToeBoard.initializeBoard();
        System.out.println("Player 1 begins.");

        game.play();
    }
}
