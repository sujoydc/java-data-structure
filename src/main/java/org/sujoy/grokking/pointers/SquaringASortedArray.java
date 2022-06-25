package org.sujoy.grokking.pointers;


import lombok.extern.slf4j.Slf4j;

@Slf4j
public class SquaringASortedArray {

    public static void main(String[] args) {
        log.info("{}", makeSquares(new int[]{-9, -3, -2, -1, 3, 4}));
    }

    public static int[] makeSquares(int[] arr) {
        int[] sqrs  = new int[arr.length];
        int   index = arr.length - 1;
        for (int start = 0, end = arr.length - 1; start <= end; start++, end--) {
            log.info("Start:{}, End:{}", start, end);
            int firstSq = arr[start] * arr[start];
            int secSq   = arr[end] * arr[end];
            if (start == end) {
                sqrs[index--] = firstSq;
            } else if (firstSq <= secSq) {
                sqrs[index--] = secSq;
                sqrs[index--] = firstSq;
            } else {
                sqrs[index--] = firstSq;
                sqrs[index--] = secSq;
            }
        }

        return sqrs;
    }

}
