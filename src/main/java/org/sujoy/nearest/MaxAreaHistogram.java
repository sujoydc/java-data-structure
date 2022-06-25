package org.sujoy.nearest;

import java.util.Arrays;
import java.util.Stack;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class MaxAreaHistogram {

    public static void main(String[] args) {
        int[] input = {6, 2, 5, 4, 5, 1, 6};
        //log.info("Mono Stack Result:{}", monoStack(input));
        Integer i = Integer.parseInt("001");
        log.info("Num:{}", i);
    }

    public static int monoStack(int[] input) {
        int[] area = new int[input.length];
        int[] nsr  = new int[input.length];
        int[] nsl  = new int[input.length];

        Stack<Integer> stackRight = new Stack<>();
        Stack<Integer> stackLeft  = new Stack<>();

        for (int i = 0, j = input.length - 1; i < input.length && j > -1; i++, j--) {
            calculateNearestSmallerRight(input, nsr, stackRight, j);
            calculateNearestSmallerLeft(input, nsl, stackLeft, i);
        }

        for (int i = 0; i < input.length; i++) {
            area[i] = ((nsr[i] - nsl[i]) - 1) * input[i];
        }

        return Arrays.stream(area)
                     .max()
                     .getAsInt();
    }

    private static void calculateNearestSmallerRight(int[] input,
                                                     int[] nsr,
                                                     Stack<Integer> stackRight,
                                                     int index) {
        if (stackRight.size() == 0) {
            nsr[index] = input.length + 1;
        } else if (input[stackRight.peek()] < input[index]) {
            nsr[index] = stackRight.peek();
        } else if (input[stackRight.peek()] >= input[index]) {
            while (stackRight.size() > 0 && input[stackRight.peek()] >= input[index]) {
                stackRight.pop();
            }

            if (stackRight.size() == 0) {
                nsr[index] = input.length + 1;
            } else {
                nsr[index] = stackRight.peek();
            }

        }

        stackRight.push(index);
    }

    private static void calculateNearestSmallerLeft(int[] input,
                                                    int[] nsl,
                                                    Stack<Integer> stackLeft,
                                                    int index) {
        if (stackLeft.size() == 0) {
            nsl[index] = -1;
        } else if (input[stackLeft.peek()] < input[index]) {
            nsl[index] = stackLeft.peek();
        } else if (input[stackLeft.peek()] >= input[index]) {
            while (stackLeft.size() > 0 && input[stackLeft.peek()] >= input[index]) {
                stackLeft.pop();
            }

            if (stackLeft.size() == 0) {
                nsl[index] = -1;
            } else {
                nsl[index] = stackLeft.peek();
            }

        }

        stackLeft.push(index);
    }

}
