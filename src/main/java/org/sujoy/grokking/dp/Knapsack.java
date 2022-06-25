package org.sujoy.grokking.dp;

import java.util.Arrays;
import java.util.stream.IntStream;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Knapsack {

    public static void main(String[] args) {
        Knapsack ks        = new Knapsack();
        int[]    profits   = {4, 5, 3, 7};
        int[]    weights   = {2, 3, 1, 4};
        int      maxProfit = ks.solveKnapsack(profits, weights, 5);
        log.info("Total knapsack profit for 5 ---> {} ", maxProfit);
        maxProfit = ks.solveKnapsack(profits, weights, 6);
        log.info("Total knapsack profit for 6 ---> {} ", maxProfit);
    }

    public int solveKnapsack(int[] profits,
                             int[] weights,
                             int capacity) {
        int[][] cache = new int[profits.length + 1][capacity + 1];

        // Rows
        IntStream.range(0, profits.length + 1)
                 .forEach(i -> {
                     // Columns
                     IntStream.range(0, capacity + 1)
                              .forEach(j -> {
                                  cache[i][j] = -1;
                              });
                 });
        log.info("Before: {}", Arrays.deepToString(cache));
        int val = this.knapsackRecursive(profits, weights, capacity, profits.length, cache);
        //log.info("After: {}", Arrays.deepToString(cache));
        return val;
    }

    private int knapsackRecursive(int[] profits,
                                  int[] weights,
                                  int capacity,
                                  int n,
                                  int[][] cache) {
        // base checks
        if (capacity <= 0 || n == 0) {
            return 0;
        }

        if (cache[n][capacity] != -1) {
            return cache[n][capacity];
        }

        int firstProfit = 0;
        if (weights[n - 1] <= capacity) {
            firstProfit = profits[n - 1] + knapsackRecursive(profits, weights, capacity - weights[n - 1], n - 1, cache);
        }
        int secondProfit = knapsackRecursive(profits, weights, capacity, n - 1, cache);

        cache[n][capacity] = Math.max(firstProfit, secondProfit);

        log.info("For index={}, capacity={}, Profit={}", n, capacity, cache[n][capacity]);
        return cache[n][capacity];
    }
}
