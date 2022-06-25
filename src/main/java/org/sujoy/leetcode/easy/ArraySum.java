package org.sujoy.leetcode.easy;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ArraySum {

    public static void main(String[] args) {
        int[] arr = {-2,1,-3,4,-1,2,1,-5,4};
        log.info("Max Sum: {}", maxSubArray(arr));
    }

    public static int maxSubArray(int[] nums) {
        Set<Integer> sumSet = new HashSet<>();
        int sum = 0;
        int low = 0;
        boolean reset = false;
        for (int i = 0; i < nums.length; i++){
            int currNum = nums[i];
            int tempSum = currNum + sum;
            if( i == 0 ){
                sum = currNum;
            }else if(sum > tempSum){
                sum = tempSum;
            } else if(sum < tempSum){
                sumSet.add(sum);
                sum = currNum;
            }
        }

        return Collections.max(sumSet);

    }

}
