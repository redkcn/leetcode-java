package io.github.redkcn.leetcode.medium;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author vicente
 * @date 2021/9/6
 */

public class MergeIntervalsTest {

    @Test
    public void testWithOverlap() {
        int[][] intervals = {{0, 3}, {1, 6}, {5, 9}, {1, 2}};
        int[][] expect = {{0, 9}};

        MergeIntervals mergeIntervals = new MergeIntervals();
        int[][] result = mergeIntervals.mergeIntervals(intervals);
        Assert.assertArrayEquals(expect, result);
    }

    @Test
    public void testWithoutOverlap() {
        int[][] intervals = {{0, 3}, {5, 6}, {7, 9}};
        int[][] expect = {{0, 3}, {5, 6}, {7, 9}};

        MergeIntervals mergeIntervals = new MergeIntervals();
        int[][] result = mergeIntervals.mergeIntervals(intervals);
        Assert.assertArrayEquals(expect, result);
    }

    @Test
    public void testWithMix() {
        int[][] intervals = {{0, 3}, {5, 6}, {6, 9}};
        int[][] expect = {{0, 3}, {5, 9}};

        MergeIntervals mergeIntervals = new MergeIntervals();
        int[][] result = mergeIntervals.mergeIntervals(intervals);
        Assert.assertArrayEquals(expect, result);
    }

}
