package org.sujoy.binary;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class BinarySearch {

    public static void main(String[] args) {
        int[] input = {1, 2, 3, 4, 5, 6, 7, 8, 9};

        log.info("Index of Number:{}", findNumber(input, 9));
        log.info("Index of Number:{}", findNumber(input, 8));
        log.info("Index of Number:{}", findNumber(input, 11));
    }

    public static int findNumber(int[] input,
                                 int number) {

        int start = 0;
        int end   = input.length - 1;
        int mid   = -1;

        do {
            mid = (start + end) / 2;

            if (input[mid] == number) {
                return mid;
            }

            if (number > input[mid]) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        } while (start <= end);

        return -1;
    }

}
