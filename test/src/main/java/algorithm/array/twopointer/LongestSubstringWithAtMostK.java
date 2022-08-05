package algorithm.array.twopointer;

import java.util.HashMap;
import java.util.Map;

/**
 * @author zhiqungao@tencent.com
 * @date 2021/10/28 上午11:14
 */
public class LongestSubstringWithAtMostK {
    public static void main(String[] args) {
        LongestSubstringWithAtMostK longestSubstringWithAtMostTwo = new LongestSubstringWithAtMostK();
        System.out.println(longestSubstringWithAtMostTwo.lengthOfLongestSubstringTwoDistinct("eceba", 2));
    }

    public int lengthOfLongestSubstringTwoDistinct(String s, int k) {
        int l = 0, r = 0, ans = 0;
        Map<Character, Integer> counter = new HashMap<>();
        while (r < s.length()) {
            counter.put(s.charAt(r), counter.getOrDefault(s.charAt(r), 0) + 1);
            while (counter.size() > k) {
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
