package io.github.redkcn.leetcode.easy;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author vicente
 * @date 2021/9/3
 */

public class PivotIndexTest {

    @Test
    public void testNormal() {
        int[] nums = {1, 7, 3, 6, 5, 6};
        PivotIndex index = new PivotIndex();
        int pivotIndex = index.findPivotIndex(nums);
        Assert.assertEquals(pivotIndex, 3);
    }

    @Test
    public void testFarLeft() {
        int[] nums = {2, 1, -1};
        PivotIndex index = new PivotIndex();
        int pivotIndex = index.findPivotIndex(nums);
        Assert.assertEquals(pivotIndex, 0);
    }

    @Test
    public void testSingle() {
        int[] nums = {2};
        PivotIndex index = new PivotIndex();
        int pivotIndex = index.findPivotIndex(nums);
        Assert.assertEquals(pivotIndex, 0);
    }

    @Test
    public void testNotExists() {
        int[] nums = {2, 1, 5};
        PivotIndex index = new PivotIndex();
        int pivotIndex = index.findPivotIndex(nums);
        Assert.assertEquals(pivotIndex, -1);
    }

}
