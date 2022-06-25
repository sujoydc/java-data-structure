package org.sujoy.test.operation.bitwise;

import java.util.Arrays;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class TestBitWise {

    public static void main(String[] args) {
        rayInit();
    }

    public static void rayInit(){
        int[] retVal = new int[5];
        Arrays.setAll(retVal, i -> 1);


    }
    public static void bitXor(){
        int[] test = {2, 3, 4, 5, 6, 7, 8, 9, 5};
        int   xor  = 1;
        for (int i = 0; i < 9; i++) {
            log.info("xor of {} and {} = ", test[i], xor);
            xor = xor | test[i];
            log.info("{}", xor);
        }

        log.info("XOR: {}", xor);
    }
    public static void bitWise(){
        int[] test = {2, 3, 4, 5, 6, 7, 8, 9};
        int   xor  = 1;
        for (int i = 0; i < 8; i++) {
            log.info("xor of {} and {} = ", test[i], xor);
            xor = xor | test[i];
            log.info("{}", xor);
        }

        log.info("XOR: {}", xor);
    }

}

// 0000 0001 = 2 ^ 0 = 1
// 0000 0010 = 2 ^ 1 + 0 = 2
// 0000 0011 = 2 ^ 1 + 2 ^ 0 = 2 + 1 = 3
// 0000 0100 = 2 ^ 2 = 4
// 0000 0101 = 2 ^ 2 + 2 ^ 0 = 4 + 1 = 5
// 0000 0110 = 2 ^ 2 + 2 ^ 1 = 4 + 2 = 6
// 0000 0111 = 2 ^ 2 + 2 ^ 1 + 2 ^ 0 = 4 + 2 + 1 = 7
// 0000 1000 = 2 ^ 3 = 8
// 0000 1001 = 2 ^ 3 + 2 ^ 0 = 8 + 1 = 9
// 0000 1111 = 15


