package io.github.redkcn.leetcode.easy;

import java.util.HashMap;
import java.util.Stack;

/**
 * 496. Next Greater Element I The next greater element of some element x in an array is the first greater element that is to the right of x in the same array.
 * <p>
 * You are given two distinct 0-indexed integer arrays nums1 and nums2, where nums1 is a subset of nums2.
 * <p>
 * For each 0 <= i < nums1.length, find the index j such that nums1[i] == nums2[j] and determine the next greater element of nums2[j] in nums2. If there is no
 * next greater element, then the answer for this query is -1.
 * <p>
 * Return an array ans of length nums1.length such that ans[i] is the next greater element as described above.
 * <p>
 * 链接：https://leetcode-cn.com/problems/next-greater-element-i
 *
 * @author vicente
 * @date 2022/3/19
 */
public class NextGreaterElementI {

    public static void main(String[] args) {
        int[] nums1 = {3, 1, 5, 7, 9, 2, 6};
        int[] nums2 = {1, 2, 3, 5, 6, 7, 9, 11};

        NextGreaterElementI elementI = new NextGreaterElementI();
        int[] res = elementI.nextGreaterElement(nums1, nums2);
        for (int i : res) {
            System.out.printf(i + " ");
        }
    }

    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Stack<Integer> stack = new Stack<>();
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = nums2.length - 1; i >= 0; i--) {
            int num = nums2[i];
            if (stack.isEmpty()) {
                stack.push(num);
                map.put(num, -1);
                continue;
            }

            while (!stack.isEmpty() && stack.peek() < num) {
                stack.pop();
            }

            map.put(num, stack.isEmpty() ? -1 : stack.peek());
            stack.push(num);
        }

        int[] res = new int[nums1.length];
        for (int i = 0; i < nums1.length; i++) {
            res[i] = map.get(nums1[i]);
        }

        return res;
    }

}
