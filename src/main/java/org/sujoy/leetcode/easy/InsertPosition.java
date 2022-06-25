package org.sujoy.leetcode.easy;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class InsertPosition {

    public static void main(String[] args) {
        int[] inputs = {1,3};
        log.info("Insert Position:{}", searchInsert(inputs, 1));
    }

    public static int searchInsert(int[] nums,
                                   int target) {
        int left  = 0;
        int right = nums.length;

        while (true) {
            int mid = (right + left) / 2;

            if ((right - left) <= 2) {
                return (target > nums[mid])  ? mid + 1 :
                       (target <= nums[left]) ? left : mid;
            } else if (nums[mid] == target) {
                return mid;
            } else if (target > nums[mid]) {
                left = mid;
            } else {
                right = mid;
            }
        }
    }
}

