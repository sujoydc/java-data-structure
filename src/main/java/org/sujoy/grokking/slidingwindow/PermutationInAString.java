package org.sujoy.grokking.slidingwindow;

import java.util.HashMap;
import java.util.Map;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class PermutationInAString {

    public static void main(String[] args) {
        String input  = "ajnmaadecbcceabecba";
        String subStr = "cbade";
        log.info("For String:{} and a sub-string:{}, Perm match exists:{}", input, subStr, isPermSubString(input, subStr));
    }

    public static boolean isPermSubString(String str,
                                          String subStr) {
        Map<Character, Integer> permMap = new HashMap<>();

        for(char ch: subStr.toCharArray()){
            permMap.put(ch, permMap.getOrDefault(ch, 0) + 1);
        }

        int start = 0;
        int matched = 0;

        for(int end = 0; end < str.length(); end++){
            char c = str.charAt(end);

            if(permMap.containsKey(c)){
                permMap.put(c, permMap.get(c) - 1);
                if(permMap.get(c) == 0){
                    matched++;
                }
            }

            if(matched == permMap.size()) return true;

            if(end >= subStr.length() - 1){
                char leftChar = str.charAt(start);
                if(permMap.containsKey(leftChar)){
                    if(permMap.get(leftChar) == 0){
                        matched--;
                    }
                    permMap.put(leftChar, permMap.get(leftChar) + 1);
                }
                start++;
            }
        }
        return false;
    }


}
