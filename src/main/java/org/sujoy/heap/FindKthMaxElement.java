package org.sujoy.heap;

import java.util.Comparator;
import java.util.PriorityQueue;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class FindKthMaxElement {

    public static void main(String[] args) {
        int[] input = {7, 10, 4, 3, 20, 15};

        log.info("Num:{}", getKthMax(input, 3));
    }

    public static int getKthMax(int[] input,
                                int k) {

        PriorityQueue<Integer> queue = new PriorityQueue<>(Comparator.comparingInt(Integer::intValue));

        for (int i = 0; i < input.length; i++) {
            queue.add(input[i]);
            if (queue.size() > k) {
                queue.poll();
            }
        }

        return queue.poll();
    }

}
