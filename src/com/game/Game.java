package com.game;

import com.game.exception.InvalidInputException;

public class Game {
    public static final int N = 3;
    private final int[][] board;
    private Player player1;
    private Player player2;
    private String status;
    private Player currentPlayer;
    private int totalMoves;

    public Game(Player player1, Player player2) {
        board = new int[N][N];
        this.player1 = player1;
        this.player2 = player2;
        currentPlayer = player1;
        status = "in-progress";
        totalMoves = 0;
    }

    /**
     * This method note a move and print anouces player id anyone wins
     *
     * @param row    board row
     * @param col    board col
     * @param player who is make move
     * @throws InvalidInputException if input index is out of scope
     */
    public void makeMove(int row, int col, Player player) throws InvalidInputException {
        if (row >= N || col >= N) {
            throw new InvalidInputException("entered index is invalid");
        } else if (board[row][col] == -1 || board[row][col] == -1) {
            throw new InvalidInputException("this box is already occupied");
        }
        board[row][col] = player.getName().equalsIgnoreCase(player1.getName()) ? 1 : -1;
        totalMoves++;

        boolean rowCompleted = true;
        boolean colCompleted = true;
        boolean majorDiagonalCompleted = true;
        boolean minorDiagonalCompleted = true;
        for (int i = 0; i < 3; i++) {
            if (board[row][i] != board[row][col]) {
                rowCompleted = false;
            }

            if (board[i][col] != board[row][col]) {
                colCompleted = false;
            }

            if (board[i][i] != board[row][col]) {
                majorDiagonalCompleted = false;
            }

            if (board[i][N - i - 1] != board[row][col]) {
                minorDiagonalCompleted = false;
            }
        }
        showBoard();
        if (rowCompleted || colCompleted || minorDiagonalCompleted || majorDiagonalCompleted) {
            status = "completed";
            System.out.println(currentPlayer.getName() + " is winner");
            return;
        }
        switchPlayer();
        if (totalMoves == N * N) {
            status = "draw";
            System.out.println("game is finished");
        }
    }

    private void showBoard() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                System.out.print(board[i][j] + "\t");
            }
            System.out.println();
        }
    }

    /**
     * this method switched the current player
     */
    private void switchPlayer() {
        if (currentPlayer == player1) {
            currentPlayer = player2;
        } else {
            currentPlayer = player1;
        }
    }

    public Player getPlayer1() {
        return player1;
    }

    public void setPlayer1(Player player1) {
        this.player1 = player1;
    }

    public Player getPlayer2() {
        return player2;
    }

    public void setPlayer2(Player player2) {
        this.player2 = player2;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Player getCurrentPlayer() {
        return currentPlayer;
    }

    public void setCurrentPlayer(Player currentPlayer) {
        this.currentPlayer = currentPlayer;
    }


    public int getTotalMoves() {
        return totalMoves;
    }

    public void setTotalMoves(int totalMoves) {
        this.totalMoves = totalMoves;
    }
}
