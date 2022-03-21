package io.github.redkcn.leetcode.medium;

import java.util.LinkedHashMap;

/**
 * 146. LRU Cache
 * <p>
 * Design a data structure that follows the constraints of a Least Recently Used (LRU) cache.
 * <p>
 * Implement the LRUCache class:
 * <p>
 * LRUCache(int capacity) Initialize the LRU cache with positive size capacity. int get(int key) Return the value of the key if the key exists, otherwise return
 * -1. void put(int key, int value) Update the value of the key if the key exists. Otherwise, add the key-value pair to the cache. If the number of keys exceeds
 * the capacity from this operation, evict the least recently used key. The functions get and put must each run in O(1) average time complexity.
 * <p>
 * 链接：https://leetcode-cn.com/problems/lru-cache
 *
 * @author vicente
 * @date 2022/3/22
 */
public class LRUCache {

    private int capacity;
    private LinkedHashMap<Integer, Integer> cache;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        cache = new LinkedHashMap<>();
    }

    public int get(int key) {
        if (cache.containsKey(key)) {
            // 记得要把访问的数据移动到链表尾部
            makeRecently(key);
            return cache.get(key);
        }

        return -1;
    }

    public void put(int key, int value) {
        if (cache.containsKey(key)) {
            // 更新值且移动到链表尾部
            cache.put(key, value);
            makeRecently(key);
            return;
        }

        if (cache.size() >= this.capacity) {
            int oldest = cache.keySet().iterator().next();
            cache.remove(oldest);
        }

        cache.put(key, value);
    }

    private void makeRecently(int key) {
        int value = cache.get(key);
        cache.remove(key);
        cache.put(key, value);
    }

}
