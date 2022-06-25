package org.sujoy.leetcode.easy;

import java.util.HashMap;
import java.util.Map;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class MaxSubstring {

    public static void main(String[] args) {
       String[] inputs = {"jbadbwwr"
                           ,"abba"
                           ,"dvdf"
                           ,"aab"
                           ,"abcabcbb"
                           ,"bbbbb"
                           ,"pwwkew"
                           ,"santosh"
                           ,"Sujoy"};
        for (String input : inputs) {
            log.info("Max Length of {} is {}", input, lengthOfLongestSubstring(input));
        }

        /*String input = "dvdf";
        log.info("Max Length of {} is {}", input, lengthOfLongestSubstring(input));*/

    }

    public static int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> dupeMap = new HashMap<>();

        char[] cStr = s.toCharArray();
        int    max  = 0;
        int    low  = 0;
        for (int i = 0; i < cStr.length; i++) {

            char c = cStr[i];
            Integer position = dupeMap.get(c);
            if (position != null && (position >= low)) {
                low = position + 1;
            }
            int tempLen = (i-low) + 1;
            if(tempLen > max){
                max = tempLen;
            }
            dupeMap.put(c, i);
        }

        return max;
    }

}
