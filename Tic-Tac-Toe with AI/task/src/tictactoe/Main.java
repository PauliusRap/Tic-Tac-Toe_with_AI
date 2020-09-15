package tictactoe;

import java.util.Arrays;
import java.util.Scanner;

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


    }


    public static void printBoard(char[][] board) {
        System.out.println("---------");
        System.out.println("| " + board[0][0] + " " + board[0][1] + " " + board[0][2] + " |");
        System.out.println("| " + board[1][0] + " " + board[1][1] + " " + board[1][2] + " |");
        System.out.println("| " + board[2][0] + " " + board[2][1] + " " + board[2][2] + " |");
        System.out.println("---------");
    }

    public static void checkState(char[][] board, int numX, int numO) {
        char[] winX = {'X', 'X', 'X'};
        char[] winO = {'O', 'O', 'O'};

        if (numO + numX < 9) {
            if (board[0] == winX || board[1] == winX || board[2] == winX) {
                
            }
        }
    }
}
