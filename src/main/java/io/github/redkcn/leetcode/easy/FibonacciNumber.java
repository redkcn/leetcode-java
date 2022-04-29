package io.github.redkcn.leetcode.easy;

/**
 * 509. Fibonacci Number
 * <p>
 * The Fibonacci numbers, commonly denoted F(n) form a sequence, called the Fibonacci sequence, such that each number is the sum of the two preceding ones,
 * starting from 0 and 1. That is,
 * <p>
 * F(0) = 0, F(1) = 1 F(n) = F(n - 1) + F(n - 2), for n > 1. Given n, calculate F(n).
 * <p>
 * 链接：https://leetcode-cn.com/problems/fibonacci-number
 *
 * @author vicente
 * @date 2022/3/27
 */

public class FibonacciNumber {

    public int fib(int n) {
        int[] memo = new int[n + 1];
        return helper(memo, n);
    }

    private int helper(int[] memo, int n) {
        if (n == 0 || n == 1) {
            return n;
        }

        if (memo[n] != 0) {
            return memo[n];
        }

        memo[n] = helper(memo, n - 1) + helper(memo, n - 2);
        return memo[n];
    }

}
