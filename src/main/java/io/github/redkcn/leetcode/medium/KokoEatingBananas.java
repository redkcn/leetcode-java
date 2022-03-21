package io.github.redkcn.leetcode.medium;

/**
 * 875. Koko Eating Bananas
 * <p>
 * Koko loves to eat bananas. There are n piles of bananas, the ith pile has piles[i] bananas. The guards have gone and will come back in h hours.
 * <p>
 * Koko can decide her bananas-per-hour eating speed of k. Each hour, she chooses some pile of bananas and eats k bananas from that pile. If the pile has less
 * than k bananas, she eats all of them instead and will not eat any more bananas during this hour.
 * <p>
 * Koko likes to eat slowly but still wants to finish eating all the bananas before the guards return.
 * <p>
 * Return the minimum integer k such that she can eat all the bananas within h hours.
 * <p>
 * 链接：https://leetcode-cn.com/problems/koko-eating-bananas
 *
 * @author vicente
 * @date 2022/3/13
 */
public class KokoEatingBananas {

    public static void main(String[] args) {
        KokoEatingBananas bananas = new KokoEatingBananas();

        int[] nums = {3, 6, 7, 11};
        int mixSpeed = bananas.minEatingSpeed(nums, 8);
        System.out.println(mixSpeed);
    }

    public int minEatingSpeed(int[] piles, int h) {
        int maxTime = 1;
        for (int pile : piles) {
            maxTime = Math.max(maxTime, pile);
        }

        int left = 1, right = maxTime - 1;
        while (left <= right) {
            int middle = left + (right - left) / 2;
            if (possible(piles, middle, h)) {
                left = middle + 1;
            } else {
                right = middle - 1;
            }
        }

        return left;
    }

    boolean possible(int[] piles, int speed, int hour) {
        int hours = 0;
        for (int pile : piles) {
            hours += Math.ceil((pile * 1.0) / speed);
        }

        return hours > hour;
    }

}
