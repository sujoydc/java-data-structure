package org.sujoy.leetcode.easy;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class FindMaxSumSubArray {

    public static void main(String[] args) {
        int[] inputs = {2, 3, 4, 1, 5};

        log.info("FindMaxSumSubArray:{}", findMaxSumSubArray(2, inputs));
    }

    public static int findMaxSumSubArray(int k,
                                         int[] inputs) {
        int maxSum  = 0;
        int tempSum = 0;

        int start = 0;
        for (int end = 0; end < inputs.length; end++) {
            tempSum += inputs[end];
            // when the array iteration hits the k
            if ((end - start) == (k - 1)) {
                maxSum = Math.max(maxSum, tempSum);
                tempSum -= inputs[start];
                start++;
            }
        }

        return maxSum;
    }


}
