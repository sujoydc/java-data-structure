package org.sujoy.grokking.slidingwindow;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class LengthOfLongestSubArrayAfterReplacement {

    public static void main(String[] args) {
        int[] input = {0, 1, 1, 0, 0, 0};
        log.info("The length of longest Sub Array:{}", findLength(input, 2));
    }

    public static int findLength(int[] arr,
                                 int k) {
        int maxLen      = 0;
        int maxOneCount = 0;
        int start       = 0;

        for (int end = 0; end < arr.length; end++) {
            if (arr[end] == 1) {
                maxOneCount++;
            }

            if ((((end - start) + 1) - maxOneCount) > k) {
                if (arr[start] == 1) {
                    maxOneCount--;
                }
                start++;
            }
            maxLen = Math.max(((end - start) + 1), maxLen);
        }
        return maxLen;
    }


}
