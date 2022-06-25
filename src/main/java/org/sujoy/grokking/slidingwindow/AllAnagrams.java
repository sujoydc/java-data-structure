package org.sujoy.grokking.slidingwindow;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class AllAnagrams {

    public static void main(String[] args) {
        String input   = "abbcabc";
        String pattern = "abc";
        log.info("For String:{} and pattern:{}, All Anagram Indices:{}", input, pattern, findStringAnagrams(input, pattern));
    }

    public static List<Integer> findStringAnagrams(String input,
                                                   String pattern) {
        List<Integer> resultIndices = new ArrayList<>();

        Map<Character, Integer> freqMap = new HashMap<>();

        for (char c : pattern.toCharArray()) {
            freqMap.put(c, freqMap.getOrDefault(c, 0) + 1);
        }

        int start   = 0;
        int matched = 0;

        for (int end = 0; end < input.length(); end++) {
            char rightChar = input.charAt(end);

            if (freqMap.containsKey(rightChar)) {
                freqMap.put(rightChar, freqMap.get(rightChar) - 1);
                if (freqMap.get(rightChar) == 0) {
                    matched++;
                }
            }

            if (matched == freqMap.size()) {
                resultIndices.add(start);
            }

            if (end >= pattern.length() - 1) {
                char leftChar = input.charAt(start);
                if (freqMap.containsKey(leftChar)) {
                    if (freqMap.get(leftChar) == 0) {
                        matched--;
                    }
                    freqMap.put(leftChar, freqMap.get(leftChar) + 1);
                }
                start++;
            }

        }
        return resultIndices;
    }

}
