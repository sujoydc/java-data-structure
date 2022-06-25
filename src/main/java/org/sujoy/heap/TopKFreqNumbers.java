package org.sujoy.heap;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.PriorityQueue;
import java.util.Set;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.tuple.ImmutablePair;
import org.apache.commons.lang3.tuple.Pair;

@Slf4j
public class TopKFreqNumbers {

    public static void main(String[] args) {
        int[] input = {1, 1, 1, 3, 2, 2, 4};

        log.info("Num:{}", topKFrequentNumber(input, 3));
    }

    public static int[] topKFrequentNumber(int[] input,
                                           int k) {
        int[] response = new int[k];

        Map<Integer, Integer> freqMap = new HashMap<>();

        for (int i = 0; i < input.length; i++) {
            int freq = freqMap.getOrDefault(input[i], 0);
            freqMap.put(input[i], ++freq);
        }

        PriorityQueue<Pair<Integer, Integer>> priorityQueue = new PriorityQueue<>(Comparator.comparingInt(Pair::getKey));

        Set<Entry<Integer, Integer>> entries = freqMap.entrySet();

        for (Entry<Integer, Integer> entry : entries) {
            Pair<Integer, Integer> tempPair = new ImmutablePair<>(entry.getValue(), entry.getKey());
            priorityQueue.add(tempPair);
            if(priorityQueue.size() > k){
                priorityQueue.poll();
            }
        }

        int p = k - 1;
        while (priorityQueue.size() > 0){
            int temp = priorityQueue.poll().getValue();
            response[p--] = temp;
        }

        return response;
    }
}
