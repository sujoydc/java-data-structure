package org.sujoy.grokking.dp;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class AllCombinationSum {

    public static List<List<Integer>> finalResult = new ArrayList<>();

    public static void main(String[] args) {
        AllCombinationSum ts = new AllCombinationSum();
        ts.allCombSum(4, new int[]{1, 2}, new HashMap<>());
        log.info("Possible ---> {} ", finalResult);
//        ts.allCombSum(4, new int[]{1, 2, 5}, new HashMap<>())); // 2, 2
//        ts.allCombSum(8, new int[]{1, 4, 5}, new HashMap<>())); // 4,4
//        ts.allCombSum(0, new int[]{1, 4, 5}, new HashMap<>())); // []
//        ts.allCombSum(7, new int[]{4, 5}, new HashMap<>())); // NULL
//        ts.allCombSum(7, new int[]{5, 3, 4, 7}, new HashMap<>())); // 7
//        ts.allCombSum(8, new int[]{1, 3, 5}, new HashMap<>())); // 3, 5
//        ts.allCombSum(100, new int[]{1, 2, 5, 25}, new HashMap<>())); // 25, 25, 25, 25
    }

    public List<Integer> allCombSum(int targetSum,
                                          int[] numbers,
                                          Map<Integer, List<Integer>> cache) {
        if (cache.containsKey(targetSum)) {
            if (cache.get(targetSum) != null) {
                return new ArrayList<>(cache.get(targetSum));
            } else {
                return null;
            }
        }

        if(targetSum == 0){
            return new ArrayList<>();
        }

        if (targetSum < 0) {
            return null;
        }

        List<Integer> allCombinations = null;

        for (int num : numbers) {
            final int reminder = targetSum - num;
            allCombinations = allCombSum(reminder, numbers, cache);
            if(allCombinations != null){
                allCombinations.add(num);
            }
        }

        if(allCombinations != null){
//            if(targetSum)
            cache.put(targetSum, new ArrayList<>(allCombinations));
            return new ArrayList<>(allCombinations);
        }

        return null;
    }
}
