package org.sujoy.leetcode.easy;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class SmallestSubArray {

    public static void main(String[] args) {
        int[] inputs = {2, 3, 4, 1, 2, 5, 5, 8};
        int   sum    = 8;

        log.info("Find smallest SubArray:{} which is >= {}", smallestSubArray(sum, inputs), sum);
    }

    public static int smallestSubArray(int sum,
                                       int[] inputs) {
        int minSubArray  = 0;
        int minTempArray = 0;
        int tempSum      = 0;

        int start = 0;
        for (int end = 0; end < inputs.length; end++) {
            tempSum += inputs[end];
            while (tempSum >= sum) {
                minTempArray = (end - start) + 1;
                minSubArray = (minSubArray == 0) ? minTempArray : Math.min(minTempArray, minSubArray);
                tempSum -= inputs[start];
                start++;
            }
        }

        return minSubArray;
    }


}
