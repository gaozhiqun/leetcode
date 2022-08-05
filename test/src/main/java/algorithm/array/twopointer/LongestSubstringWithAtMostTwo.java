package algorithm.array.twopointer;

import java.util.HashMap;
import java.util.Map;

/**
 * @author zhiqungao@tencent.com
 * @date 2021/10/28 上午11:14
 */
public class LongestSubstringWithAtMostTwo {
    public static void main(String[] args) {
        LongestSubstringWithAtMostTwo longestSubstringWithAtMostTwo = new LongestSubstringWithAtMostTwo();
        System.out.println(longestSubstringWithAtMostTwo.lengthOfLongestSubstringTwoDistinct("ccaabbb"));
    }

    public int lengthOfLongestSubstringTwoDistinct(String s) {
        int l = 0, r = 0, ans = 0;
        Map<Character, Integer> counter = new HashMap<>();
        while (r < s.length()) {
            counter.put(s.charAt(r), counter.getOrDefault(s.charAt(r), 0) + 1);
            while (counter.size() > 2) {
                int cnt = counter.get(s.charAt(l));
                cnt--;
                if (cnt == 0) {
                    counter.remove(s.charAt(l));
                } else {
                    counter.put(s.charAt(l), cnt);
                }
                ++l;
            }
            ans = Math.max(ans, r - l + 1);
            r++;
        }
        return ans;
    }
}
