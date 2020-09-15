package tictactoe;

import java.util.Arrays;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {
        // write your code here
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter cells: ");
        String line = scanner.nextLine();
        char[][] board = new char[3][3];
        int currChar = 0;
        int numX = 0;
        int numO = 0;
        for (int i = 0; i < 3; i++) {
            for (int k = 0; k < 3; k++) {
                board[i][k] = line.charAt(currChar);
                if (line.charAt(currChar) == 'X') {
                    numX++;
                }
                if (line.charAt(currChar) == 'O') {
                    numO++;
                }
                currChar++;
            }
        }
        printBoard(board);
        board = makeAMove(board, numX, numO);
        if (numX == numO) {
            numX++;
        } else numO++;
        printBoard(board);
        checkState(board, numX, numO);
    }


    public static void printBoard(char[][] board) {
        System.out.println("---------");
        System.out.println("| " + board[0][0] + " " + board[0][1] + " " + board[0][2] + " |");
        System.out.println("| " + board[1][0] + " " + board[1][1] + " " + board[1][2] + " |");
        System.out.println("| " + board[2][0] + " " + board[2][1] + " " + board[2][2] + " |");
        System.out.println("---------");
    }

    public static char[][] makeAMove(char[][] board, int numX, int numO) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the coordinates");
        String line = scanner.nextLine();
        if (Pattern.matches("[123] [123]", line)) {
            int[] coords = {Integer.parseInt(line.substring(0,1)), Integer.parseInt(line.substring(2,3))};
            if (board[coords[0]][coords[1]] == '_') {
                if (numX == numO) {
                    board[coords[0]][coords[1]] = 'X';
                } else {
                    board[coords[0]][coords[1]] = 'O';
                }
                return board;
            } else {
                System.out.println("This cell is occupied! Choose another one!");
                 return makeAMove(board, numX, numO);
            }
        } else {
            System.out.println("Invalid input");
             return makeAMove(board, numX, numO);
        }
    }

    public static void checkState(char[][] board, int numX, int numO) {
        char[] winX = {'X', 'X', 'X'};
        char[] winO = {'O', 'O', 'O'};
        char[] col1 = {board[0][0], board[1][0], board[2][0]};
        char[] col2 = {board[0][1], board[1][1], board[2][1]};
        char[] col3 = {board[0][2], board[1][2], board[2][2]};
        char[] across1 = {board[0][0], board[1][1], board[2][2]};
        char[] across2 = {board[0][2], board[1][1], board[2][0]};

        if (numO + numX < 9) {
            if (board[0] == winX || board[1] == winX || board[2] == winX ||
            col1 == winX || col2 == winX || col3 == winX || across1 == winX || across2 == winX) {
                System.out.println("X wins");
            } else if (board[0] == winO || board[1] == winO || board[2] == winO ||
                    col1 == winO || col2 == winO || col3 == winO || across1 == winO || across2 == winO) {
                System.out.println("O wins");
            } else System.out.println("Game not finished");
        } else {
            if (board[0] == winX || board[1] == winX || board[2] == winX ||
                    col1 == winX || col2 == winX || col3 == winX || across1 == winX || across2 == winX) {
                System.out.println("X wins");
            } else if (board[0] == winO || board[1] == winO || board[2] == winO ||
                    col1 == winO || col2 == winO || col3 == winO || across1 == winO || across2 == winO) {
                System.out.println("O wins");
            } else System.out.println("Draw");
        }
    }
}
