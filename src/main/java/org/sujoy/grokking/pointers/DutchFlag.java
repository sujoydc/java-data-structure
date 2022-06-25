package org.sujoy.grokking.pointers;


import lombok.extern.slf4j.Slf4j;

@Slf4j
public class DutchFlag {

    public static void main(String[] args) {
        int[] inputs = new int[]{1, 0, 2, 0, 0, 2, 1, 1, 2, 0, 1};
        log.info("Original: {}", inputs);
        sort(inputs);
    }

    public static void sort(int[] arr) {

        int low  = 0;
        int high = arr.length - 1;

        for (int i = 0; i <= high; ) {
            if (arr[i] == 0) {
                swap(arr, i, low);
                i++;
                low++;
            } else if (arr[i] == 1) {
                i++;
            } else {
                swap(arr, i, high);
                high--;
            }
        }

        log.info("Sorted  : {}", arr);
    }

    public static void swap(int[] arr,
                            int left,
                            int right) {
        int temp = arr[left];
        arr[left] = arr[right];
        arr[right] = temp;
    }

}
