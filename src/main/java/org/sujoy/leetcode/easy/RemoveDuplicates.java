package org.sujoy.leetcode.easy;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class RemoveDuplicates {

    public static void main(String[] args) {
        int[] inputs = {1,2,2,2,2,3,3,3,4,4,5,6,7,7,8,9};
        log.info("Unique Numbers:{}", removeDuplicates(inputs));
    }

    public static int removeDuplicates(int[] nums) {
        if(nums.length == 0) return 0;

        int prev = nums[0];
        int left = 0;
        for(int i =1; i< nums.length; i++){
           if(prev != nums[i]){
               nums[left + 1] = nums[i];
               left = left + 1;
               prev = nums[i];
           }
           // When we hit the last element
           if((i + 1) == nums.length){
               int p = left + 1;
               while(p <= i){
                   nums[p] = -200;
                   p++;
               }
           }
            log.info("Updated Array: {}", nums);
        }
        log.info("New Array: {}", nums);
        return left + 1;
    }
}
