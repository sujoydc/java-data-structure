package org.sujoy.test;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class FindBits {

    public static void main(String[] args) {
        int n = 599090;
        int b = 32;
        log.info("Bits of {} = {}", n, toBinary(n, b));

    }

    public static String toBinary(int n, int numOfBits) {
        StringBuffer sb = new StringBuffer();
        for (long i = (1L << numOfBits - 1), j = 1; i > 0; i = i / 2, j++) {
            sb.append((i & n) == 0 ? "0" : "1");
            if(j % 8 == 0) sb.append(" ");
        }

        return sb.toString();
    }
}
