package com.game;

import com.game.exception.InvalidInputException;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws InvalidInputException {
        // write your code here
        Player player1 = new Player("Vihaan");
        Player player2 = new Player("Ayaan");
        Game game = new Game(player1, player2);
        Scanner in = new Scanner(System.in);
        while (game.getStatus().equalsIgnoreCase("in-progress")) {
            System.out.println("Please enter row and column ");
            int row = in.nextInt();
            int col = in.nextInt();
            game.makeMove(row, col, game.getCurrentPlayer());
        }
    }
}
