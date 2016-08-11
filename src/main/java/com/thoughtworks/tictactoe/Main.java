package com.thoughtworks.tictactoe;

public class Main {
    public static void main(String[] args) {
        System.out.println("~ Welcome to Tic Tac Toe ~\n");
        TicTacToe ticTacToeBoard = new TicTacToe(System.out);
        ticTacToeBoard.initializeBoard();

        System.out.println("Player 1 begins! Please enter the # square to place an X.\n");
    }
}
