package org.sujoy.recursion;


import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Factorial {

    public static void main(String[] args) {
        int number = 5;
        long start = System.nanoTime();
        log.info("{}! = {}", number, factorial(number));
        long end = System.nanoTime();
        log.info("{}", end - start);
        log.info("{}! = {}", number, factorialTail(number, 1));
        long moreEnd = System.nanoTime();
        log.info("{}", moreEnd - end);
    }

    public static int factorial(int number) {
        if(number == 1) {
            return 1;
        }

        return number * factorial(number - 1);
    }

    public static int factorialTail(int number, int result) {
        if(number == 0) {
            return result;
        }

        return factorialTail(number - 1, number * result);
    }



}
