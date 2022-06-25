package org.sujoy.recursion;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class MinSortWindow {

    public static void main(String[] args) {
        log.info("Min Sort Window:{}", minWindow(new int[]{1, 2, 5, 3, 7, 10, 9, 12}));
        log.info("=================");
        log.info("Min Sort Window:{}", minWindow(new int[]{1, 2, 3, 4}));
        log.info("=================");
        log.info("Min Sort Window:{}", minWindow(new int[]{3, 2, 1}));
    }

    public static int minWindow(int[] input) {
        int start = 0, end = input.length - 1;

        return (end - start) + 1;
    }
}
