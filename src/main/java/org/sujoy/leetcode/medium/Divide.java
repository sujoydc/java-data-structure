package org.sujoy.leetcode.medium;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Divide {

    public static void main(String[] args) {
        int dividend = -2147483648;
        int divisor  = 2;

        log.info("Algo: {}", divide(dividend, divisor));
        log.info("Real: {}", dividend / divisor);

    }

    public static int divide(int dividend,
                             int divisor) {
        log.info("Working with > Dividend: {} and Divisor: {}", dividend, divisor);
        if (divisor == 1) {
            return dividend;
        }

        int sign = (dividend < 0 && divisor < 0) ? 1
                                                 : (dividend < 0 || divisor < 0) ? -1 : 1;

        if (dividend == Integer.MIN_VALUE) {
            dividend = -1 * Integer.MIN_VALUE;
        } else {
            dividend = Math.abs(dividend);
        }

        if (divisor == Integer.MIN_VALUE) {
            divisor = Integer.MAX_VALUE;
        } else {
            divisor = Math.abs(divisor);
        }

        if (dividend == 0) {
            return 0;
        }

        int i = 0;

        log.info("Before Loop > Dividend: {} and Divisor: {} and i:{}", dividend, divisor, i);
        while (dividend >= divisor) {
            if(dividend - divisor < 8) {
                log.info(" In Loop > Dividend: {} and Divisor: {} and i:{}", dividend, divisor, i);
            }
            dividend -= divisor;
            i++;
        }

        return i * sign;

    }

}
