package algorithm.array.twopointer;

import java.util.HashMap;
import java.util.Map;

/**
 * @author zhiqungao@tencent.com
 * @date 2021/10/28 上午11:21
 */
public class CharacterReplacement {
    public static void main(String[] args) {
        CharacterReplacement characterReplacement = new CharacterReplacement();
        System.out.println(characterReplacement.characterReplacement(
                "aababba", 1
        ));
        System.out.println(characterReplacement.characterReplacement(
                "ABAB", 2
        ));
    }

    public int characterReplacement(String s, int k) {
        int l = 0, r = 0, ans = 0;
        int N = s.length();
        Map<Character, Integer> counter = new HashMap<>();
        while (r < N) {
            counter.put(s.charAt(r), counter.getOrDefault(s.charAt(r), 0) + 1);
            while (getCounts(counter) > k) {
                counter.put(s.charAt(l), counter.get(s.charAt(l)) - 1);
                ++l;
            }
            ans = Math.max(ans, r - l + 1);
            r++;
        }
        return ans;
    }

    private int getCounts(Map<Character, Integer> counter) {
        int max = 0, sum = 0;
        for (int i : counter.values()) {
            max = Math.max(i, max);
            sum += i;
        }
        return sum - max;
    }
}
