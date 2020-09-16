package tictactoe;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {
        // write your code here
        char[][] board = {{' ', ' ', ' '}, {' ', ' ', ' '}, {' ', ' ', ' '}};
        printBoard(board);
        while (true) {
            makeAMove(board);
            printBoard(board);
            if (checkState(board)) break;
            makeARandomMove(board);
            printBoard(board);
            if (checkState(board)) break;
        }
    }


    public static void printBoard(char[][] board) {
        System.out.println("---------");
        System.out.println("| " + board[0][0] + " " + board[0][1] + " " + board[0][2] + " |");
        System.out.println("| " + board[1][0] + " " + board[1][1] + " " + board[1][2] + " |");
        System.out.println("| " + board[2][0] + " " + board[2][1] + " " + board[2][2] + " |");
        System.out.println("---------");
    }

    public static char[][] makeAMove(char[][] board) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the coordinates");
        String line = scanner.nextLine();
        if (Pattern.matches("[123] [123]", line)) {
            line = line + " ";
//            int[] coords = {Integer.parseInt(line.substring(0,1)), 3 - Integer.parseInt(line.substring(2,3))};
            int[] coords = {3 - Integer.parseInt(line.substring(2, 3)), Integer.parseInt(line.substring(0, 1)) - 1};
            if (board[coords[0]][coords[1]] == ' ') {
                board[coords[0]][coords[1]] = 'X';
                return board;
            } else {
                System.out.println("This cell is occupied! Choose another one!");
                return makeAMove(board);
            }
        } else {
            if (line.matches("\\d \\d")) {
                System.out.println("Coordinates should be from 1 to 3!");
            } else {
                System.out.println("You should enter numbers!");
            }
            return makeAMove(board);
        }
    }

    public static boolean checkState(char[][] board) {
        char[] winX = {'X', 'X', 'X'};
        char[] winO = {'O', 'O', 'O'};
        char[] col1 = {board[0][0], board[1][0], board[2][0]};
        char[] col2 = {board[0][1], board[1][1], board[2][1]};
        char[] col3 = {board[0][2], board[1][2], board[2][2]};
        char[] across1 = {board[0][0], board[1][1], board[2][2]};
        char[] across2 = {board[0][2], board[1][1], board[2][0]};

//        if (numO + numX < 9) {
        if (Arrays.equals(board[0], winX) || Arrays.equals(board[1], winX) || Arrays.equals(board[2], winX) ||
                Arrays.equals(col1, winX) || Arrays.equals(col2, winX) || Arrays.equals(col3, winX) ||
                Arrays.equals(across1, winX) || Arrays.equals(across2, winX)) {
            System.out.println("X wins");
            return true;
        } else if (Arrays.equals(board[0], winO) || Arrays.equals(board[1], winO) || Arrays.equals(board[2], winO) ||
                Arrays.equals(col1, winO) || Arrays.equals(col2, winO) || Arrays.equals(col3, winO) ||
                Arrays.equals(across1, winO) || Arrays.equals(across2, winO)) {
            System.out.println("O wins");
            return true;
        } else /*System.out.println("Game not finished");*/
            return false;
        /*} else {
            if (board[0] == winX || board[1] == winX || board[2] == winX ||
                    col1 == winX || col2 == winX || col3 == winX || across1 == winX || across2 == winX) {
                System.out.println("X wins");
            } else if (board[0] == winO || board[1] == winO || board[2] == winO ||
                    col1 == winO || col2 == winO || col3 == winO || across1 == winO || across2 == winO) {
                System.out.println("O wins");
            } else System.out.println("Draw");*/
    }

    public static char[][] makeARandomMove(char[][] board) {
        Random randCoord = new Random();
        int coord1 = randCoord.nextInt(3);
        int coord2 = randCoord.nextInt(3);
        if (board[coord1][coord2] == ' ') {
            board[coord1][coord2] = 'O';
            System.out.println("Making move level \"easy\"");
        } else makeARandomMove(board);
        return board;
    }
}

