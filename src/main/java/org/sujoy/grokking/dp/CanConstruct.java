package org.sujoy.grokking.dp;

import java.util.HashMap;
import java.util.Map;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class CanConstruct {

    public static void main(String[] args) {
        CanConstruct ts = new CanConstruct();
        log.info("Possible ---> {} ", ts.canConstruct("abcdef", new String[]{"ab", "abc", "cd", "def", "abcd"}, new HashMap<>()));
        log.info("Possible ---> {} ", ts.canConstruct("skateboard", new String[]{"bo", "rd", "ate", "t", "ska", "sk", "bor"}, new HashMap<>()));
        log.info("Possible ---> {} ", ts.canConstruct("eeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeef", new String[]{"e", "ee", "eee", "eeee", "eeeee", "eeeeeee"}, new HashMap<>()));

    }

    public boolean canConstruct(String targetString,
                                String[] arrayString,
                                Map<String, Boolean> cache) {
        if (cache.containsKey(targetString)) {
            return cache.get(targetString);
        }
        if (targetString.length() == 0) {
            return true;
        }

        for (String word : arrayString) {
            if (targetString.startsWith(word)) {
                String suffix = targetString.substring(word.length());
                if (canConstruct(suffix, arrayString, cache)) {
                    cache.put(targetString, true);
                    return true;
                }
            }
        }

        cache.put(targetString, false);
        return false;
    }
}
