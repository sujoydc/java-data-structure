package org.sujoy.grokking.slidingwindow;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class MinWindowSubstring {

    public static void main(String[] args) {
        String input   = "abbcabc";
        String pattern = "abc";
        log.info("For String:{} and pattern:{}, Smallest Window Substring:{}", input, pattern, findSubstring(input, pattern));
    }


    public static String findSubstring(String input,
                                       String pattern) {
        String smallestSubString = "";

        int start = 0;

        Map<Character, Integer> patternMap = new HashMap<>();
        for (char c : pattern.toCharArray()) {
            patternMap.put(c, patternMap.getOrDefault(c, 0) + 1);
        }

        for (int end = 0; end < input.length(); end++) {

        }

        return smallestSubString;
    }
}
