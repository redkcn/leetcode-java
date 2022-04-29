package io.github.redkcn.leetcode.medium;

import java.util.LinkedList;
import java.util.List;

/**
 * 46. Permutations
 * <p>
 * Given an array nums of distinct integers, return all the possible permutations. You can return the answer in any order.
 * <p>
 * 链接：https://leetcode-cn.com/problems/permutations
 *
 * @author vicente
 * @date 2022/3/27
 */

public class Permutations {

    private List<List<Integer>> choice = new LinkedList<>();

    public List<List<Integer>> permute(int[] nums) {
        LinkedList<Integer> track = new LinkedList<>();
        backtrack(nums, track);
        return choice;
    }

    void backtrack(int[] nums, LinkedList<Integer> track) {
        if (track.size() == nums.length) {
            choice.add(new LinkedList<>(track));
            return;
        }

        for (int value : nums) {
            if (track.contains(value)) {
                continue;
            }

            track.add(value);
            backtrack(nums, track);
            track.removeLast();
        }
    }

}
