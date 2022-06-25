package org.sujoy.leetcode.medium;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ZigzagString {

    public static void main(String[] args) {
        String str     = "PAYPALISHIRING";
        int    numRows = 7;
        log.info("For String Length:{} and Rows:{} Number of Cols:{}", str.length(), numRows, getColumn(str.length(), numRows));
        log.info("Final String: {}", convert(str, numRows));
    }

    public static String convert(String s,
                                 int numRows) {
        int      colLength  = getColumn(s.length(), numRows);
        char[][] finalArray = new char[numRows][colLength];

        char[] input = s.toCharArray();

        int     row      = 0;
        int     col      = 0;
        boolean downward = true;
        for (int i = 0; i < s.length(); i++) {
            char c = input[i];
            finalArray[row][col] = c;
            if (downward) {
                if (row == (numRows - 1)) {
                    downward = false;
                    row = (row - 1) < 0 ? 0 : (row - 1);
                    col += 1;
                } else {
                    row++;
                }
            } else {
                if (row != 0) {
                    row = (row - 1) < 0 ? 0 : (row - 1);
                    col += 1;
                } else {
                    downward = true;
                    row = ((numRows - 1) == 0) ? 0 : (row + 1);
                    col = (numRows == 1) ? col + 1 : col;
                }
            }

        }

        final String SPACE = " ";
        StringBuffer sb = new StringBuffer();
        for (int ar = 0; ar < numRows; ar++) {
            for (int ac = 0; ac < colLength; ac++) {
                char temp = finalArray[ar][ac];
                if (temp == (char) 0) {
                    temp = ' ';
                } else {
                    sb.append(temp);
                }
                System.out.print(SPACE + temp);

            }
            System.out.println("");
        }

        return sb.toString();
    }

    public static int getColumn(int length,
                                int numRows) {
        if (numRows == 1) {
            return length;
        } else if (numRows == 2) {
            return (length % 2 == 0) ? length / 2 : length / 2 + 1;
        } else {
            int a = 1 + (numRows - 2);
            int b = numRows + (numRows - 2);
            int c = length / b;
            int d = a * c;
            int e = length % b;
            int f = (e <= numRows) ? 1 : (e - numRows) + 1;

            return d + f;
        }
    }
}
