import java.util.Arrays;

/**
 * @author zhiqungao@tencent.com
 * @date 2021/3/3 5:36 下午
 */
public class LongestSubstringWhthoutRepeating {
    public static void main(String[] args) {
        LongestSubstringWhthoutRepeating longestSubstringWhthoutRepeating = new LongestSubstringWhthoutRepeating();
        System.out.println(longestSubstringWhthoutRepeating.longestSubstringWithoutRepeating("abcccas"));

    }

    public int longestSubstringWithoutRepeating(String s) {
        int[] lastShow = new int[128];
        Arrays.fill(lastShow, -1);
        int ans = 0;
        for (int i = 0, j = 0; j < s.length(); j++) {
            char ch = s.charAt(j);
            i = Math.max(i, lastShow[ch]);
            ans = Math.max(ans, j - i + 1);
            lastShow[ch] = j + 1;
        }
        return ans;
    }
}
