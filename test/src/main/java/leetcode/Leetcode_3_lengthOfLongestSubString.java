package leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author zhiqungao@tencent.com
 * @date 2021/10/29 上午10:49
 */
public class Leetcode_3_lengthOfLongestSubString {
    public static void main(String[] args) {
        Leetcode_3_lengthOfLongestSubString leetcode_3_lengthOfLongestSubString = new Leetcode_3_lengthOfLongestSubString();
        System.out.println(leetcode_3_lengthOfLongestSubString.lengthOfLongestSubString("abcabcbb"));
        System.out.println(leetcode_3_lengthOfLongestSubString.lengthOfLongestSubString("bbbb"));
        System.out.println(leetcode_3_lengthOfLongestSubString.lengthOfLongestSubString("pwwkew"));
        System.out.println(leetcode_3_lengthOfLongestSubString.lengthOfLongestSubString(""));
    }

    public int lengthOfLongestSubString(String s) {
        if ("".equals(s)) {
            return 0;
        }
        int l = -1, ans = 0;
        Map<Character, Integer> idxMap = new HashMap<>();
        for (int r = 0; r < s.length(); r++) {
            l = Math.max(idxMap.getOrDefault(s.charAt(r), -1), l);
            ans = Math.max(ans, r - l);
            idxMap.put(s.charAt(r), r);
        }
        return ans;
    }
}
