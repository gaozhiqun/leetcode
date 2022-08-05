package leetcode;

import java.util.*;

/**
 * @author zhiqungao@tencent.com
 * @date 2021/12/10 上午11:24
 */
public class Leetcode_395_longestSubstring {
    public static void main(String[] args) {
        Leetcode_395_longestSubstring l = new Leetcode_395_longestSubstring();
        System.out.println(l.longestSubstring("aaabb", 3));
        System.out.println(l.longestSubstring("ababbc", 2));

    }

    public int longestSubstring(String s, int k) {
        if ("".equals(s)) {
            return 0;
        }
        int[] cnts = new int[26];
        for (char ch : s.toCharArray()) {
            cnts[ch - 'a']++;
        }
        for (int i = 0; i < 26; i++) {
            int ans = 0;
            if (cnts[i] > 0 && cnts[i] < k) {
                char split = (char) ('a' + i);
                String[] nexts = s.split(String.valueOf(split));
                for (String next : nexts) {
                    if (next.length() > 0) {
                        ans = Math.max(ans, longestSubstring(next, k));
                    }
                }
                return ans;
            }
        }
        return s.length();
    }


}



