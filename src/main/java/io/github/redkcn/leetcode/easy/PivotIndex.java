package io.github.redkcn.leetcode.easy;

import java.util.Arrays;

/**
 * 724. Find Pivot Index
 * <p>Given an array of integers nums, calculate the pivot index of this array. </p>
 * <p>The pivot index is the index where the sum of all the numbers strictly to the left of the index is equal to the sum of all the numbers strictly to the
 * index's right. </p>
 * <p>If the index is on the left edge of the array, then the left sum is 0 because there are no elements to the left. This also applies to the
 * right edge of the array.</p>
 * <p>
 * Return the leftmost pivot index. If no such index exists, return -1.
 *
 * @author vicente
 * @date 2021/9/2
 */

public class PivotIndex {

    public Integer findPivotIndex(int[] nums) {
        int total = Arrays.stream(nums).sum();

        int leftSum = 0;
        for (int i = 0; i < nums.length; i++) {
            if (2 * leftSum + nums[i] == total) {
                return i;
            }
            leftSum += nums[i];
        }

        return -1;
    }

}
