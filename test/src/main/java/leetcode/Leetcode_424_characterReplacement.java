package leetcode;

import java.util.*;

/**
 * @author zhiqungao@tencent.com
 * @date 2021/12/13 下午2:55
 */
public class Leetcode_424_characterReplacement {
    public static void main(String[] args) {
        Leetcode_424_characterReplacement l = new Leetcode_424_characterReplacement();
        System.out.println(l.characterReplacement("AABABBA", 1));
        System.out.println(l.characterReplacement("ABBB", 2));
        System.out.println(l.characterReplacement("BAAAB", 2));


    }

    /**
     * AABABBA
     *
     * @param s
     * @param k dp[n][k] = dp[i][k-1][]
     * @return
     */
    public int characterReplacement(String s, int k) {
        int[] num = new int[26];
        int n = s.length();
        int maxn = 0;
        int l = 0, r = 0;
        while (r < n) {
            num[s.charAt(r) - 'A']++;
            maxn = Math.max(maxn, num[s.charAt(r) - 'A']);
            if (r - l + 1 - maxn > k) {
                num[s.charAt(l) - 'A']--;
                l++;
            }
            r++;
        }
        return r - l;
    }


}

