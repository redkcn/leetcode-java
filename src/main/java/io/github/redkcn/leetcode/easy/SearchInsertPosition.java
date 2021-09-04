package io.github.redkcn.leetcode.easy;

/**
 * 35. Search Insert Position
 * <p>
 * Given a sorted array of distinct integers and a target value, return the index if the target is found. If not, return the index where it would be if it were
 * inserted in order.
 * <p>
 * You must write an algorithm with O(log n) runtime complexity.
 *
 * @author vicente
 * @date 2021/9/3
 */

public class SearchInsertPosition {

    /**
     * use bisection method to search insert position
     *
     * @param nums
     * @param target
     * @return
     */
    public Integer searchInsertPosition(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int middle = (left + right) / 2;
            if (nums[middle] == target) {
                return middle;
            } else if (nums[middle] < target) {
                left = middle + 1;
            } else {
                right = middle - 1;
            }
        }

        return left;
    }

}
