package io.github.redkcn.leetcode.easy;

import java.util.Arrays;

/**
 * 300. Longest Increasing Subsequence
 * <p>
 * Given an integer array nums, return the length of the longest strictly increasing subsequence.
 * <p>
 * A subsequence is a sequence that can be derived from an array by deleting some or no elements without changing the order of the remaining elements. For
 * example, [3,6,2,7] is a subsequence of the array [0,3,1,6,2,2,7].
 * <p>
 * 链接：https://leetcode-cn.com/problems/longest-increasing-subsequence
 *
 * @author vicente
 * @date 2022/3/27
 */

public class LongestIncreasingSubsequence {

    public int lengthOfLIS(int[] nums) {
        int[] dp = new int[nums.length];
        Arrays.fill(dp, 1);

        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }

        int res = 0;
        for (int j : dp) {
            res = Math.max(res, j);
        }

        return res;
    }

}
