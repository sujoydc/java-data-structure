package org.sujoy.test.operation.bitwise;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class TestXOR {


    public static void main(String[] args) {
        int[] a = {1, 2, 3, 4, 5, 6, 7, 8};
        int[] b = {5, 4, 6, 8, 3, 2, 1};
        log.info("{}", missingNumber(b, a));
    }

    public static int missingNumber(int[] first,
                                    int[] second) {
        int xor_val = 0;
        for (int i : first) {
            xor_val ^= i;
        }
        for (int i : second) {
            xor_val ^= i;
        }
        return xor_val;
    }
}
