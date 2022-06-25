package org.sujoy.recursion;


import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Fibonacci {

    public static void main(String[] args) {
        int number = 5;
        long start = System.nanoTime();
        log.info("{}! = {}", number, fibonacci(number));
        long end = System.nanoTime();
        log.info("{}", end - start);
        log.info("{}! = {}", number, fibonacciTail(number, 1));
        long moreEnd = System.nanoTime();
        log.info("{}", moreEnd - end);
    }

    public static int fibonacci(int number) {
        return -1;
    }

    public static int fibonacciTail(int number, int result) {
        if(number == 0) {
            return result;
        }

        return fibonacciTail(number - 1, number * result);
    }

}
