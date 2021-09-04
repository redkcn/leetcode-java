package io.github.redkcn.leetcode.easy;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author vicente
 * @date 2021/9/3
 */

public class SearchInsertPositionTest {

    @Test
    public void testForNormalSearch() {
        int[] nums = {0, 3, 6, 8};
        int target = 6;
        SearchInsertPosition position = new SearchInsertPosition();
        int index = position.searchInsertPosition(nums, target);
        Assert.assertEquals(2, index);
    }

    @Test
    public void testForNotExists() {
        int[] nums = {0, 3, 6, 8};
        int target = 5;
        SearchInsertPosition position = new SearchInsertPosition();
        int index = position.searchInsertPosition(nums, target);
        Assert.assertEquals(2, index);
    }

    @Test
    public void testForLeft() {
        int[] nums = {1, 3, 6, 8};
        int target = 0;
        SearchInsertPosition position = new SearchInsertPosition();
        int index = position.searchInsertPosition(nums, target);
        Assert.assertEquals(0, index);
    }

    @Test
    public void testForRight() {
        int[] nums = {1, 3, 6, 8};
        int target = 9;
        SearchInsertPosition position = new SearchInsertPosition();
        int index = position.searchInsertPosition(nums, target);
        Assert.assertEquals(4, index);
    }

    @Test
    public void testForMiddle() {
        int[] nums = {1, 3, 6, 8, 10};
        int target = 6;
        SearchInsertPosition position = new SearchInsertPosition();
        int index = position.searchInsertPosition(nums, target);
        Assert.assertEquals(2, index);
    }

}
