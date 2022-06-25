package org.sujoy.grokking.pointers;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class PairWithTargetSum {

    public static void main(String[] args) {

        log.info(" Target indexes: {}", search(new int[]{1, 2, 3, 4, 6}, 6));

    }


    public static int[] search(int[] arr,
                               int targetSum) {

        int[] retArr = {-1, -1};

        for (int i = 0, j = arr.length - 1; i < arr.length; i++) {
            log.info("i={}, j={}", i, j);
            if (arr[i] + arr[j] > targetSum) {
                j--;
            }

            if (arr[i] + arr[j] < targetSum) {
                continue;
            }

            if (arr[i] + arr[j] == targetSum) {
                retArr[0] = i;
                retArr[1] = j;
                break;
            }
        }
        return retArr;
    }


}
