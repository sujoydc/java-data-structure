package org.sujoy.leetcode.dp;

import java.util.*;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class CountCoin {

    public static void main(String[] args) {
        log.info("Number of coins:", coinChange(new int[]{1, 2, 5}, 11));
    }

    public static int coinChange(int[] coins,
                                 int amount) {
        List<List<Integer>> tab = new ArrayList<>();
        // initialize
        for (int i = 0; i <= amount; i++) {
            if (i == 0) {
                tab.add(0, new ArrayList<Integer>());
            } else {
                tab.add(i, null);
            }
        }

        log.info("At Size=",tab.get(0).size());

        for (int i = 0; i <= amount + 1; i++) {
            for (int j = 0; j < coins.length; j++) {
                // index should not be more than the array and the current spot should not be NULL
                if (i + coins[j] <= amount && tab.get(i) != null) {
                    // if the target index is empty
                    if (tab.get(i + coins[j]) == null) {
                        List<Integer> temp = new ArrayList<>();
                        temp.addAll(tab.get(i));
                        temp.add(coins[j]);
                        tab.set(i + coins[j], temp);
                    } else {
                        // now check the length if it's shorter than the new length
                        int newLen = tab.get(i)
                                        .size() + 1;
                        int currLen = tab.get(i + coins[j])
                                         .size();
                        if (currLen > newLen) {
                            List<Integer> temp = new ArrayList<>();
                            temp.addAll(tab.get(i));
                            temp.add(coins[j]);
                            tab.set(i + coins[j], temp);
                        }

                    }
                }
            }
        }

        if (tab.get(amount) == null) {
            return -1;
        } else {
            return tab.get(amount)
                      .size();
        }
    }
}



