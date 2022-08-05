package algorithm.array;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zhiqungao@tencent.com
 * @date 2021/7/5 下午8:08
 */
public class FindAnagrams {
    public static void main(String[] args) {

    }

    public List<Integer> findAnagrams(String s, String p) {
        int m = s.length(), n = p.length();
        List<Integer> result = new ArrayList<>();
        int[] counts = new int[26];
        int[] demands = new int[26];
        for (int i = 0; i < m; i++) {
            boolean same = true;
            counts[s.charAt(i) - 'a']++;
            if (i > n - 1) {
                counts[s.charAt(i - n) - 'a']--;
            }
            for (int j = 0; j < 26; j++) {
                if (counts[j] != demands[j]) {
                    same = false;
                }
            }
            if (same) {
                result.add(i - n);
            }
        }
        return result;
    }
}
