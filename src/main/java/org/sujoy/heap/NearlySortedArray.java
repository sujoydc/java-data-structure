package org.sujoy.heap;

import java.util.Comparator;
import java.util.PriorityQueue;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class NearlySortedArray {

    public static void main(String[] args) {
        int[] input = {6, 5, 3, 2, 8, 10, 9};

        log.info("Num:{}", nearlySort(input, 4));
    }

    public static int[] nearlySort(int[] input,
                                   int k) {
        int[]                  response = new int[input.length];
        PriorityQueue<Integer> queue    = new PriorityQueue<>(Comparator.comparingInt(Integer::intValue));

        for (int i = 0; i < input.length; i++) {
            queue.add(input[i]);
            if (queue.size() > k) {
                response[i - k] = queue.poll();
            }

            if (i == input.length - 1) {
                while (queue.size() > 0) {
                    response[i - (--k)] = queue.poll();
                }
            }
        }

        return response;
    }

}
