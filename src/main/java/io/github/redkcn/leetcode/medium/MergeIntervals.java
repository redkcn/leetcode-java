package io.github.redkcn.leetcode.medium;

import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;

/**
 * 56. Merge Intervals
 * <p>
 * Given an array of intervals where intervals[i] = [starti, endi], merge all overlapping intervals, and return an array of the non-overlapping intervals that
 * cover all the intervals in the input.
 *
 * @author vicente
 * @date 2021/9/5
 */

public class MergeIntervals {

    public int[][] mergeIntervals(int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));
        LinkedList<int[]> mergedList = new LinkedList<>();
        for (int[] interval : intervals) {
            if (mergedList.isEmpty() || mergedList.getLast()[1] < interval[0]) {
                mergedList.add(interval);
            } else {
                mergedList.getLast()[1] = Math.max(mergedList.getLast()[1], interval[1]);
            }
        }

        return mergedList.toArray(new int[mergedList.size()][]);
    }

}
