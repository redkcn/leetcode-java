package io.github.redkcn.leetcode.difficult;

import java.util.HashMap;
import java.util.LinkedHashSet;

/**
 * 460. LFU Cache
 * <p>
 * Design and implement a data structure for a Least Frequently Used (LFU) cache.
 * <p>
 * Implement the LFUCache class:
 * <p>
 * LFUCache(int capacity) Initializes the object with the capacity of the data structure. int get(int key) Gets the value of the key if the key exists in the
 * cache. Otherwise, returns -1. void put(int key, int value) Update the value of the key if present, or inserts the key if not already present. When the cache
 * reaches its capacity, it should invalidate and remove the least frequently used key before inserting a new item. For this problem, when there is a tie (i.e.,
 * two or more keys with the same frequency), the least recently used key would be invalidated. To determine the least frequently used key, a use counter is
 * maintained for each key in the cache. The key with the smallest use counter is the least frequently used key.
 * <p>
 * When a key is first inserted into the cache, its use counter is set to 1 (due to the put operation). The use counter for a key in the cache is incremented
 * either a get or put operation is called on it.
 * <p>
 * The functions get and put must each run in O(1) average time complexity.
 * <p>
 * 链接：https://leetcode-cn.com/problems/lfu-cache
 *
 * @author vicente
 * @date 2022/3/23
 */
public class LFUCache {

    private HashMap<Integer, Integer> data;
    private HashMap<Integer, Integer> keyToFreq;
    private HashMap<Integer, LinkedHashSet<Integer>> freqToKeys;

    private int minFreq;
    private int capacity;

    public LFUCache(int capacity) {
        data = new HashMap<>();
        keyToFreq = new HashMap<>();
        freqToKeys = new HashMap<>();

        minFreq = 0;
        this.capacity = capacity;
    }

    public int get(int key) {
        if (!data.containsKey(key)) {
            return -1;
        }

        int value = data.get(key);
        increaseFreq(key);
        return value;
    }

    public void put(int key, int value) {
        if (data.containsKey(key)) {
            data.put(key, value);
            increaseFreq(key);
            return;
        }

        if (data.size() >= capacity) {
            removeMinFreqKey();
        }

        data.put(key, value);
        keyToFreq.put(key, 1);
        freqToKeys.putIfAbsent(1, new LinkedHashSet<>());
        freqToKeys.get(1).add(key);
        this.minFreq = 1;
    }

    private void increaseFreq(int key) {
        int oldFreq = keyToFreq.get(key);
        int newFreq = oldFreq + 1;
        keyToFreq.put(key, newFreq);

        freqToKeys.get(oldFreq).remove(key);
        freqToKeys.putIfAbsent(newFreq, new LinkedHashSet<>());
        freqToKeys.get(newFreq).add(key);

        if (freqToKeys.get(oldFreq).isEmpty()) {
            freqToKeys.remove(oldFreq);

            if (oldFreq == minFreq) {
                minFreq++;
            }
        }
    }

    private void removeMinFreqKey() {
        LinkedHashSet<Integer> minFreqKeys = freqToKeys.get(this.minFreq);
        int oldestKey = minFreqKeys.iterator().next();
        minFreqKeys.remove(oldestKey);
        if (minFreqKeys.isEmpty()) {
            freqToKeys.remove(this.minFreq);
        }

        data.remove(oldestKey);
        keyToFreq.remove(oldestKey);
    }

}
