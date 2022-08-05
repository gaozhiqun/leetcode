package algorithm.array.twopointer;

/**
 * @author zhiqungao@tencent.com
 * @date 2021/10/28 下午3:21
 */
public class NumberOfSubString {
    public static void main(String[] args) {
        NumberOfSubString numberOfSubString = new NumberOfSubString();
        System.out.println(numberOfSubString.numberOfSubstrings("abcabc"));
    }

    /**
     * leetcode 1358
     *
     * @param s
     * @return
     */
    public int numberOfSubstrings(String s) {
        int[] freq = new int[3];
        int len = s.length();
        int ans = 0;
        for (int l = 0, r = -1; l < len; l++) {
            while (r < len && !(freq[0] > 0 && freq[1] > 0 && freq[2] > 0)) {
                if (++r == len) {
                    break;
                }
                freq[s.charAt(r) - 'a']++;
            }
            ans += len - r;
            freq[s.charAt(l) - 'a']--;
        }
        return ans;
    }
}
