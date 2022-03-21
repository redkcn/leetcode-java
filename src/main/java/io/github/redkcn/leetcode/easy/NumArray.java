package io.github.redkcn.leetcode.easy;

/**
 * 303.
 * @author vicente
 * @date 2022/3/9
 */
public class NumArray {

    private int[] sum;

    NumArray(int[] nums) {
        sum = new int[nums.length + 1];
        for (int i = 0; i < nums.length; i++) {
            sum[i + 1] = sum[i] + nums[i];
        }
    }

    int sumArrange(int left, int right) {
        return sum[right + 1] - sum[left];
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, -7, 0, 1, 8, -3, 9};
        NumArray array = new NumArray(nums);
        System.out.println(array.sumArrange(1, 3));
    }

}
