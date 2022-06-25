package org.sujoy.grokking.dp;

import java.util.HashMap;
import java.util.Map;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class TargetSum {

    public static void main(String[] args) {
        TargetSum ts = new TargetSum();
        log.info("Possible ---> {} ", ts.targetSum(new int[]{2, 3}, 7, new HashMap<>()));
        log.info("Possible ---> {} ", ts.targetSum(new int[]{5, 3, 4, 7}, 7, new HashMap<>()));
        log.info("Possible ---> {} ", ts.targetSum(new int[]{2, 4}, 7, new HashMap<>()));
        log.info("Possible ---> {} ", ts.targetSum(new int[]{2, 3, 5}, 8, new HashMap<>()));
        log.info("Possible ---> {} ", ts.targetSum(new int[]{7, 14}, 300, new HashMap<>()));
    }

    public boolean targetSum(int[] subArray,
                             int targetSum,
                             Map<Integer, Boolean> cache) {
        if (cache.get(targetSum) != null) {
            //log.info("Found in cache for {}", targetSum);
            return cache.get(targetSum);
        }
        if (targetSum == 0) {
            return true;
        }

        if (targetSum < 0) {
            return false;
        }

        for (int i = 0; i < subArray.length; i++) {
            final int reminder = targetSum - subArray[i];
            if (targetSum(subArray, reminder, cache)) {
                cache.put(targetSum, true);
                return true;
            }
        }
        cache.put(targetSum, false);
        //log.info("Returned FALSE");
        return false;
    }
}
