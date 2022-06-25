package org.sujoy.grokking.slidingwindow;

import java.util.HashMap;
import java.util.Map;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class LengthOfLongestSubString {

    public static void main(String[] args) {
        String input = "abccdea123456789aaaa";
        log.info("For String:{} The length of longest substring:{}", input, findLength(input));
    }

    public static int findLength(String str) {
        int maxLen = 0;
        int start  = 0;

        Map<Character, Integer> dupeMap = new HashMap<>();

        for (int end = 0; end < str.length(); end++) {
            char    charAt    = str.charAt(end);
            if(dupeMap.containsKey(charAt)){
                start = Math.max(start, dupeMap.get(charAt) + 1);
            }
            dupeMap.put(charAt, end);
            maxLen = Math.max(maxLen, (end - start) + 1);
        }
        return maxLen;
    }


}
