package org.sujoy.grokking.dp;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Fibonacci {

    public static void main(String[] args) {
        int   fib   = 30;
        int[] store = new int[fib + 1];
        log.info("Fibonacci of {} is {}", fib, calFib(store, fib));
        log.info("Fibonacci of {} is {}", fib, fabTab(fib));
    }

    public static int calFib(int[] cache,
                             int n) {

        if (n < 2) {
            return n;
        }

        if (cache[n] != 0) {
            return cache[n];
        }

        cache[n] = calFib(cache, n - 1) + calFib(cache, n - 2);
        return cache[n];
    }

    public static int fabTab(int n) {
        if (n == 0) {
            return 1;
        }
        int[] tab = new int[n + 1];

        // base cases
        tab[0] = 0;
        tab[1] = 1;

        for (int i = 2; i <= n; i++) {
         tab[i] = tab[i-1] + tab[i-2];
        }

        return tab[n];
    }

}
