package leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author zhiqungao@tencent.com
 * @date 2022/5/5 下午5:17
 */
public class Leetcode_1048_longestStrChain {

    int ans = 0;

    public int longestStrChain(String[] words) {
        Map<String, Integer> map = new HashMap<>();
        Arrays.sort(words, (a, b) -> (a.length() - b.length()));
        int minVal = words[0].length(), maxLen = 1;
        for (String word : words) {
            int m = word.length();
            int len = 1;
            if (m > minVal) {
                for (int i = 0; i < m; i++) {
                    String s = word.substring(0, i) + word.substring(i + 1);
                    len = Math.max(len, map.getOrDefault(s, 0) + 1);
                }
            }
            maxLen = Math.max(maxLen, len);
            map.put(word, len);
        }
        return maxLen;
    }
}
