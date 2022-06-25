package org.sujoy.leetcode.easy;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ReverseInteger {

    public static void main(String[] args) {
        int input = -123456789;
        log.info("Reversed:{}", reverse(input));
    }

    public static int reverse(int x) {

        StringBuilder sb = new StringBuilder();

        int retVal = 0;

        boolean isNeg = x < 0;
        if (isNeg) {
            x *= -1;
        }

        boolean isZero = true;

        while (true) {
            if (x == 0) {
                break;
            } else if (x / 10 == 0) {
                sb.append(x);
                break;
            }

            if (isZero && x % 10 == 0) {
                x /= 10;
                continue;
            }
            isZero = false;
            sb.append(x % 10);
            x /= 10;
        }
        try {
            retVal = Integer.parseInt(sb.toString());
        } catch (Exception e) {
            log.error("Error: ", e.getMessage());
            return retVal;
        }
        return (isNeg) ? -retVal : retVal;
    }
}
