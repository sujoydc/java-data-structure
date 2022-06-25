package org.sujoy.leetcode.hard;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Sudoku {

    private static Map<String, Stack<String>> probableNumbersMap = new HashMap<>();

    public static void main(String[] args) {

        char[][] board = {
            {'5', '3', '.', '.', '7', '.', '.', '.', '.'},
            {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
            {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
            {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
            {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
            {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
            {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
            {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
            {'.', '.', '.', '.', '8', '.', '.', '7', '9'}
        };

        //solveSudoku(board);
        print(board);
    }

    public static void solveSudoku(char[][] board) {
        int left_low = 0;
        int left_high = 2;
        int mid_low = 3;
        int mid_high = 5;
        int right_low = 6;
        int right_high = 8;



        while(true){
            solveSq(left_low, left_high, board);
            solveSq(mid_low, mid_high, board);
            solveSq(right_low, right_high, board);
            if(checkComplete(board)){
                break;
            }

        }

    }

    public static void solveSq(int low, int high, char[][] board){
        // get available list of values
        for(int i = low; i <= high; i++){
            char[] currRow = board[i];

        }

    }

    public static boolean checkComplete(char[][] input) {

        return false;
    }

    public static void print(char[][] input) {
        StringBuilder sb = null;
        for (int i = 0; i < input.length; i++) {
            sb = new StringBuilder();
            for (int j = 0; j < input[i].length; j++) {
                sb.append(input[i][j] + " | ");
            }
            log.info("{}", sb.toString());
            log.info("{}", "-----------------------------------");
        }
    }


}
