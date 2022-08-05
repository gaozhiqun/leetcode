package algorithm.dp;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/**
 * @author zhiqungao@tencent.com
 * @date 2021/3/24 6:53 下午
 */
public class LongestSubstring {
    public static void main(String[] args) {

    }

    /**
     * 至少有K个重复的字串，分治，懒得写了
     */
    public int longestSubstring(String s, int k) {
        return helper(s, 0, s.length(), k);
    }

    private int helper(String s, int l, int r, int k) {
        if (r - l < k) {
            return 0;
        }
        int[] counts = new int[26];
        for (int i = l; i < r; i++) {
            counts[s.charAt(i) - 'a']++;
        }
        int min = Integer.MAX_VALUE;
        int minIndex = -1;
        for (int i = 0; i < counts.length; i++) {
            if (counts[i] > 0 && counts[i] < min) {
                min = counts[i];
                minIndex = min;
            }
        }
        if (minIndex > -1 && min >= k) {
            return r - l;
        }
        int newl = 0;
        int result = Integer.MIN_VALUE;
        for (int i = l; i < r; i++) {
            if (s.charAt(i) - 'a' == minIndex) {
                result = Math.max(helper(s, newl, i, k), result);
                newl = i + 1;
            }
        }
        result = Math.max(helper(s, newl, r, k), result);
        return result;
    }


}
