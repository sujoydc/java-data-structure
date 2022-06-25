package org.sujoy.leetcode.easy;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class MovingAverage {

    public static void main(String[] args) {
        int[] inputs = {1, 3, 2, 6, -1, 4, 1, 8, 2};

        log.info("Moving averages:{}", movingAvg(5, inputs));
    }

    public static double[] movingAvg(int k,
                                     int[] inputs) {
        double[] avgArray = new double[inputs.length - k + 1];
        double   sum      = 0;
        int      start    = 0;
        for (int end = 0; end < inputs.length; end++) {
            sum += inputs[end];
            // when the array iteration hits the k
            if ((end - start) == (k - 1)) {
                avgArray[start] = sum / k;
                sum -= inputs[start];
                start++;
            }
        }

        return avgArray;
    }


}
