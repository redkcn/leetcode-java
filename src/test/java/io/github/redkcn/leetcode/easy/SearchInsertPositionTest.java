package io.github.redkcn.leetcode.easy;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author vicente
 * @date 2021/9/3
 */

public class SearchInsertPositionTest {

    @Test
    public void testForSearch() {
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

}
