package org.sujoy.grokking.slidingwindow;

import java.util.HashMap;
import java.util.Map;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class LongestSubStrWithMaxKDistinctChars {

    public static void main(String[] args) {
        String input = "cbbebi";
        int    K     = 10;
        log.info("For String:{} and Distinct Chars:{}, Longest substr length:{}", input, K, findLength(input, K));
    }

    public static int findLength(String str,
                                 int k) {

        char[] input  = str.toCharArray();
        int    maxLen = 1;
        int    start  = 0;

        Map<Character, Integer> uniqueKeysMap = new HashMap<>();

        for (int end = 0; end < input.length; end++) {
            char rightChar = input[end];
            uniqueKeysMap.put(rightChar, uniqueKeysMap.getOrDefault(rightChar, 0) + 1);

            // iterate the map and remove the chars
            while (uniqueKeysMap.size() > k) {
                char leftChar = input[start];
                uniqueKeysMap.put(leftChar, uniqueKeysMap.get(leftChar) - 1);
                if (uniqueKeysMap.get(leftChar) == 0) {
                    uniqueKeysMap.remove(leftChar);
                }
                start++;
            }

            maxLen = Math.max(maxLen, ((end - start) + 1));
        }

        return maxLen;
    }


}
