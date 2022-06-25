package org.sujoy.test;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Trying {

    public static void main(String[] args) {
        int     row = 3;
        int     col = 3;
        char[][] ttt = new char[row][col];

        int num = 1;

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                ttt[i][j] = (char)num++;
            }
        }

        int c = '9';
        log.info("C = {}", (char)c);

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                log.info("TicTacTow[{}][{}] = {}", i, j, ttt[i][j]);
            }
        }


    }


}
