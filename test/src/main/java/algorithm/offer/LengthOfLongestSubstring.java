package algorithm.offer;

import java.util.HashMap;
import java.util.Map;

/**
 * @author zhiqungao@tencent.com
 * @date 2021/6/10 2:37 下午
 */
public class LengthOfLongestSubstring {
    public static void main(String[] args) {
        LengthOfLongestSubstring lengthOfLongestSubstring = new LengthOfLongestSubstring();
        System.out.println(lengthOfLongestSubstring.lengthOfLongestSubstring("abcabcbb"));
    }

    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> posMap = new HashMap<>();
        int result = Integer.MIN_VALUE;
        int l = -1;
        for (int i = 0; i < s.length(); i++) {
            char cur = s.charAt(i);
            l = Math.max(posMap.getOrDefault(cur, -1), l);
            result = Math.max(result, i - l);
            posMap.put(cur, i);
        }
        return result;
    }
}
