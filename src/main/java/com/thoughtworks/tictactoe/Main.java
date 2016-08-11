package com.thoughtworks.tictactoe;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        System.out.println("~ Welcome to Tic Tac Toe ~\n");
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        List<String> boardSquares = new ArrayList<String>();

        TicTacToe ticTacToeBoard = new TicTacToe(System.out, boardSquares, reader);
        ticTacToeBoard.initializeBoard();

        System.out.println("Player 1 begins! Please enter the # square to place an X.\n");
        ticTacToeBoard.playGame();
    }
}
