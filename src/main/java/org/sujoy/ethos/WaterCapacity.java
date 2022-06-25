package org.sujoy.ethos;


import lombok.extern.slf4j.Slf4j;

@Slf4j
public class WaterCapacity {

    /*

            |
          | |
       |  |||  |
    _|_||_||||||_|

    */
    public static void main(String[] args) {
        //int test = (1,2,3,4,5);
        int[] capacity = {0, 1, 0, 2, 1, 0, 3, 2, 4, 1, 1, 5, 0, 1};
        log.info("FindCapacity:{}", findCapacity(capacity));
    }

    public static int findCapacity(int[] inputs) {
        return -1;
    }
}
