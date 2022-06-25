package org.sujoy.nearest;

import java.util.Arrays;
import java.util.Stack;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class NearestSmallerToLeft {

    public static void main(String[] args) {
        int[] input = {4, 5, 2, 10, 8};
        log.info("Brute Force Result:{}", Arrays.toString(bruteForce(input)));
        log.info("Mono Stack Result:{}", Arrays.toString(monoStack(input)));
    }

    public static int[] monoStack(int[] input) {
        int[] res = new int[input.length];

        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < input.length; i++) {
            int current = input[i];

            if (stack.size() == 0) {
                res[i] = -1;
            } else if (stack.peek() < current) {
                res[i] = stack.peek();
            } else if (stack.peek() >= current) {
                while (stack.size() > 0 && stack.peek() >= current) {
                    stack.pop();
                }

                if (stack.size() == 0) {
                    res[i] = -1;
                } else {
                    res[i] = stack.peek();
                }

            }
            stack.push(current);
        }
        return res;
    }


    public static int[] bruteForce(int[] input) {
        int[] res = new int[input.length];
        res[0] = -1;
        int minusOne = -1;
        for (int i = 1; i < input.length; i++) {
            int current = input[i];
            int min     = Integer.MAX_VALUE;
            for (int j = i - 1; j >= 0; j--) {
                if (input[j] < current) {
                    min = Math.min(min, input[j]);
                }
            }

            if (min == Integer.MAX_VALUE) {
                res[i] = minusOne;
            } else {
                res[i] = min;
            }

        }

        return res;
    }
}
