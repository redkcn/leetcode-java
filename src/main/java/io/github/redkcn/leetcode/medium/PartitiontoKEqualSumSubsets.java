package io.github.redkcn.leetcode.medium;

/**
 * 698. Partition to K Equal Sum Subsets
 * <p>
 * Given an integer array nums and an integer k, return true if it is possible to divide this array into k non-empty subsets whose sums are all equal.
 * <p>
 * 链接：https://leetcode-cn.com/problems/partition-to-k-equal-sum-subsets
 *
 * @author vicente
 * @date 2022/3/27
 */

public class PartitiontoKEqualSumSubsets {

    public boolean canPartitionKSubsets(int[] nums, int k) {
        if (k > nums.length) {
            return false;
        }

        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        if (sum % k != 0) {
            return false;
        }

        boolean[] used = new boolean[nums.length];
        int target = sum / k;

        return backtrack(k, 0, nums, 0, used, target);
    }

    boolean backtrack(int k, int bucket, int[] nums, int start, boolean[] used, int target) {
        if (k == 0) {
            return true;
        }

        if (bucket == target) {
            return backtrack(k - 1, 0, nums, 0, used, target);
        }

        for (int i = start; i < nums.length; i++) {
            if (used[i] || nums[i] + bucket > target) {
                continue;
            }

            used[i] = true;
            bucket += nums[i];
            if (backtrack(k, bucket, nums, i + 1, used, target)) {
                return true;
            }

            used[i] = false;
            bucket -= nums[i];
        }

        return false;
    }

}
