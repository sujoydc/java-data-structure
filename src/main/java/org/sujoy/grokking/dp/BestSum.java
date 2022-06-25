package org.sujoy.grokking.dp;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class BestSum {

    public static void main(String[] args) {
        BestSum ts = new BestSum();
        log.info("Possible ---> {} ", ts.bestSum(4, new int[]{1, 2}, new HashMap<>())); // 2, 2
        log.info("Possible ---> {} ", ts.bestSum(4, new int[]{1, 2, 5}, new HashMap<>())); // 2, 2
        log.info("Possible ---> {} ", ts.bestSum(8, new int[]{1, 4, 5}, new HashMap<>())); // 4,4
        log.info("Possible ---> {} ", ts.bestSum(0, new int[]{1, 4, 5}, new HashMap<>())); // []
        log.info("Possible ---> {} ", ts.bestSum(7, new int[]{4, 5}, new HashMap<>())); // NULL
        log.info("Possible ---> {} ", ts.bestSum(7, new int[]{5, 3, 4, 7}, new HashMap<>())); // 7
        log.info("Possible ---> {} ", ts.bestSum(8, new int[]{1, 3, 5}, new HashMap<>())); // 3, 5
        log.info("Possible ---> {} ", ts.bestSum(100, new int[]{1, 2, 5, 25}, new HashMap<>())); // 25, 25, 25, 25
    }

    public List<Integer> bestSum(int targetSum,
                                 int[] numbers,
                                 Map<Integer, List<Integer>> memo) {
        //log.info("Called with {}", targetSum);
        if (memo.containsKey(targetSum)) {
            //log.info("Found in cache for {}", targetSum);
            return memo.get(targetSum);
        }

        if (targetSum == 0) {
            return new ArrayList<>();
        }

        if (targetSum < 0) {
            return null;
        }

        List<Integer> shortestResult = null;

        for (int num : numbers) {
            final int     reminder       = targetSum - num;
            List<Integer> reminderResult = bestSum(reminder, numbers, memo);
            if (reminderResult != null) {
                reminderResult.add(num);

                if (shortestResult == null || shortestResult.size() > reminderResult.size()) {
                    shortestResult = new ArrayList<>(reminderResult);
                }
            }
        }

        memo.put(targetSum, shortestResult);

        if (shortestResult == null) {
            return null;
        } else {
            return new ArrayList<>(shortestResult);
        }
    }
}
