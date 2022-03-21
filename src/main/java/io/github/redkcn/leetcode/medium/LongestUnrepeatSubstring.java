package io.github.redkcn.leetcode.medium;

import java.util.HashSet;
import java.util.Set;

/**
 * 3. Longest Substring Without Repeating Characters
 * <p>
 * Given a string s, find the length of the longest substring without repeating characters.
 * <p>
 * 链接：https://leetcode-cn.com/problems/longest-substring-without-repeating-characters
 *
 * @author vicente
 * @date 2022/3/13
 */
public class LongestUnrepeatSubstring {

    public static void main(String[] args) {
        LongestUnrepeatSubstring longest = new LongestUnrepeatSubstring();

        String str = "abcabcbb";
        int size = longest.lengthOfLongestSubstring(str);
        System.out.println(size);
    }

    public int lengthOfLongestSubstring(String str) {
        Set<Character> longestSubstring = new HashSet<>();
        int right = -1, longestSize = 0, length = str.length();
        for (int i = 0; i < length; i++) {
            if (i != 0) {
                longestSubstring.remove(str.charAt(i - 1));
            }

            while (right + 1 < length && !longestSubstring.contains(str.charAt(right + 1))) {
                longestSubstring.add(str.charAt(right + 1));
                right++;
            }

            longestSize = Math.max(longestSize, right - i + 1);
        }

        return longestSize;
    }

}
