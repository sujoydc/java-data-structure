package org.sujoy.leetcode.easy;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.time.StopWatch;

@Slf4j
public class Palindrome {

    public static void main(String[] args) {
        String    input     = ".,"; //"A man, a plan, a canal: Panama";
        StopWatch stopWatch = new StopWatch();
        stopWatch.start();
        boolean answer = isPalindrome(input);
        stopWatch.stop();
        long timeElapsed = stopWatch.getTime();
        log.info("Time taken {} to find if '{}' is palindrome? {}", timeElapsed, input, answer);
    }

    public static boolean isPalindrome(String s) {
        char[] charArray = s.toCharArray();
        for(int i = 0, j = charArray.length - 1; i != j && i < j; i++, j--){
            while(!Character.isLetterOrDigit(charArray[i])){
                i++;
                if(i == charArray.length) return true;
            }
            while(!Character.isLetterOrDigit(charArray[j])){
                j--;
                if(j == 0) return true;
            }
            if(i == j) return true;
            if(Character.toLowerCase(charArray[i]) != Character.toLowerCase(charArray[j])) return false;
        }
        return true;
    }

}
