package org.sujoy.grokking.dp;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class HowSum {

    public static void main(String[] args) {
        HowSum ts = new HowSum();
        log.info("Possible ---> {} ", ts.howSum(new int[]{2, 3}, 7, new HashMap<>()));
        log.info("Possible ---> {} ", ts.howSum(new int[]{5, 3, 4, 7}, 7, new HashMap<>()));
        log.info("Possible ---> {} ", ts.howSum(new int[]{2, 4}, 7, new HashMap<>()));
        log.info("Possible ---> {} ", ts.howSum(new int[]{2, 3, 5}, 8, new HashMap<>()));
        log.info("Possible ---> {} ", ts.howSum(new int[]{7, 14}, 300, new HashMap<>()));
    }

    public List<Integer> howSum(int[] numbers,
                                int targetSum,
                                Map<Integer, List<Integer>> memo) {
        //log.info("Called with {}", targetSum);
        if (memo.get(targetSum) != null) {
            //log.info("Found in cache for {}", targetSum);
            return memo.get(targetSum);
        }
        if (targetSum == 0) {
            return new ArrayList<>();
        }

        if (targetSum < 0) {
            return null;
        }

        for (int number : numbers) {
            final int     reminder       = targetSum - number;
            List<Integer> reminderResult = howSum(numbers, reminder, memo);
            if (reminderResult != null) {
                reminderResult.add(number);
                memo.put(targetSum, reminderResult);
                return reminderResult;
            }
        }
        memo.put(targetSum, null);
        //log.info("Returned FALSE");
        return null;
    }
}
