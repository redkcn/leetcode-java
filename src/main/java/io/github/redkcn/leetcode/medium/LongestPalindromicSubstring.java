package io.github.redkcn.leetcode.medium;

/**
 * @author vicente
 * @date 2022/3/13
 */
public class LongestPalindromicSubstring {

    public String longestPalindrome(String s) {
        String result = "";
        for (int i = 0; i < s.length(); i++) {
            String first = palindrome(s, i, i);
            String second = palindrome(s, i, i + 1);

            result = result.length() > first.length() ? result : first;
            result = result.length() > second.length() ? result : second;
        }

        return result;
    }

    String palindrome(String str, int left, int right) {
        while (left >= 0 & right < str.length() && str.charAt(left) == str.charAt(right)) {
            left--;
            right++;
        }

        return str.substring(left + 1, right);
    }

}
