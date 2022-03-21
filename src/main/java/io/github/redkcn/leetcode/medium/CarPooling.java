package io.github.redkcn.leetcode.medium;

/**
 * 1094. Car Pooling There is a car with capacity empty seats. The vehicle only drives east (i.e., it cannot turn around and drive west).
 * <p>
 * You are given the integer capacity and an array trips where trips[i] = [numPassengersi, fromi, toi] indicates that the ith trip has numPassengersi passengers
 * and the locations to pick them up and drop them off are fromi and toi respectively. The locations are given as the number of kilometers due east from the
 * car's initial location.
 * <p>
 * Return true if it is possible to pick up and drop off all passengers for all the given trips, or false otherwise.
 * <p>
 * 链接：https://leetcode-cn.com/problems/car-pooling
 *
 * @author vicente
 * @date 2022/3/13
 */
public class CarPooling {

    public static void main(String[] args) {
        int[][] trips = {{2, 1, 5,}, {3, 3, 7}};
        CarPooling pooling = new CarPooling();
        boolean result = pooling.carPooling(trips, 5);
    }

    public boolean carPooling(int[][] trips, int capacity) {
        int maxOff = 0;
        for (int[] trip : trips) {
            maxOff = Math.max(maxOff, trip[2]);
        }

        int[] diff = new int[maxOff + 1];
        for (int[] trip : trips) {
            diff[trip[1]] += trip[0];
            diff[trip[2]] -= trip[0];
        }

        int total = 0;
        for (int i = 0; i < diff.length; i++) {
            total += diff[i];
            if (total > capacity) {
                return false;
            }
        }

        return true;
    }

}
