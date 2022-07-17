package org.sujoy.grokking.dp;

import java.util.HashMap;
import java.util.Map;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class CountConstruct {

    public static void main(String[] args) {
        CountConstruct ts = new CountConstruct();
        log.info("Possible ---> {} ", ts.countConstruct("purple", new String[]{"purp", "p", "ur", "le", "purpl"}, new HashMap<>()));
        log.info("Possible ---> {} ", ts.countConstruct("abcdef", new String[]{"ab", "abc", "cd", "def", "abcd"}, new HashMap<>()));
        log.info("Possible ---> {} ", ts.countConstruct("skateboard", new String[]{"bo", "rd", "ate", "t", "ska", "sk", "bor"}, new HashMap<>()));
        log.info("Possible ---> {} ", ts.countConstruct("eeeeeeeeeef", new String[]{"e", "ee", "eee", "eeee", "eeeee", "eeeeeee", "f"}, new HashMap<>()));
    }

    public int countConstruct(String targetString,
                              String[] arrayString,
                              Map<String, Integer> cache) {
        if (cache.containsKey(targetString)) {
            return cache.get(targetString);
        }
        if (targetString.length() == 0) {
            return 1;
        }

        int totalCount = 0;
        for (String word : arrayString) {
            if (targetString.startsWith(word)) {
                String    suffix        = targetString.substring(word.length());
                final int restOfTheWays = countConstruct(suffix, arrayString, cache);
                totalCount += restOfTheWays;
            }
        }

        cache.put(targetString, totalCount);
        return totalCount;
    }
}
