package org.sujoy.leetcode.dp;

import java.math.BigInteger;
import java.util.*;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class CountCoin {

    public static void main(String[] args) {
        // Doesn't work with Integer.MAX_VALUE
        //log.info("Number of coins:{}", coinChange(new int[]{1,2147483647}, 2));
        // Other values work
        log.info("Number of coins:{}", coinChange(new int[]{1,2,5}, 11));
    }

    public static int coinChange(int[] coins,
                                 int amount) {
        List<List<Integer>> tab = new ArrayList<>();
        //List<List<BigInteger>> temp = new ArrayList<>();
        // initialize
        for (int i = 0; i <= amount; i++) {
            if (i == 0) {
                tab.add(0, new ArrayList<>());
            } else {
                tab.add(i, null);
            }
        }

        for (int i = 0; i <= amount; i++) {
            for (int j = 0; j < coins.length; j++) {
                // index should not be more than the array and the current spot should not be NULL
                if (i + coins[j] <= amount
                    && (i <= tab.size() && tab.get(i) != null)) {
                    // if the target index is empty
                    if (tab.get(i + coins[j]) == null) {
                        List<Integer> temp = new ArrayList<>();
                        //List<BigInteger> temp = new ArrayList<>();
                        temp.addAll(tab.get(i));
                        //temp.add(BigInteger.valueOf(coins[j]));
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
                            //List<BigInteger> temp = new ArrayList<>();
                            temp.addAll(tab.get(i));
                            //temp.add(BigInteger.valueOf(coins[j]));
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



