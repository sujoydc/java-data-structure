package org.sujoy.nearest;

import java.util.Arrays;
import java.util.Stack;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class NearestGreaterToLeft {

    public static void main(String[] args) {
        int[] input = {100, 80, 60, 70, 75, 80, 110, 85};
        //int[] input = {2, 3, 5, 7, 4};
        //log.info("Brute Force Result:{}", Arrays.toString(bruteForce(input)));
        log.info("Mono Stack Result:{}", Arrays.toString(monoStack(input)));
    }

    public static int[] monoStack(int[] input) {
        int[] res = new int[input.length];

        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < input.length; i++) {
            if (stack.size() == 0) {
                res[i] = -1;
            } else if (input[stack.peek()] > input[i]) {
                res[i] = i - stack.peek();
            } else if (input[stack.peek()] <= input[i]) {
                while (stack.size() > 0 && input[stack.peek()] <= input[i]) {
                    stack.pop();
                }

                if (stack.size() == 0) {
                    res[i] = -1;
                } else {
                    res[i] = i - stack.peek();
                }
            }

            // Push the index into the stack but compare with the actual value
            stack.push(i);
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
