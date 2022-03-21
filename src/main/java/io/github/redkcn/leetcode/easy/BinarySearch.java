package io.github.redkcn.leetcode.easy;

/**
 * 704. Binary Search
 * <p>
 * Given an array of integers nums which is sorted in ascending order, and an integer target, write a function to search target in nums. If target exists, then
 * return its index. Otherwise, return -1.
 * <p>
 * You must write an algorithm with O(log n) runtime complexity.
 * <p>
 * 链接：https://leetcode-cn.com/problems/binary-search
 *
 * @author vicente
 * @date 2022/3/13
 */
public class BinarySearch {

    public int search(int[] nums, int target) {
        int left = 0, right = nums.length - 1;

        while (left <= right) {
            int middle = left + (right - left) / 2;
            if (nums[middle] == target) {
                return middle;
            }

            if (nums[middle] < target) {
                left = middle + 1;
            } else if (nums[middle] > target) {
                right = middle - 1;
            }
        }

        return -1;
    }

}
