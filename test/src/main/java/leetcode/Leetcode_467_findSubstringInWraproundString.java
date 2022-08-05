package leetcode;

import java.util.Random;

/**
 * @author zhiqungao@tencent.com
 * @date 2021/12/14 上午10:48
 */
public class Leetcode_467_findSubstringInWraproundString {

    public int findSubstringInWraproundString(String p) {
        int[] dp = new int[26];
        char[] array = p.toCharArray();
        int len = 0;
        for (int i = 0; i < array.length; i++) {
            if (i > 0 && (array[i] - array[i - 1] - 1) % 26 == 0) {
                len++;
            } else {
                len = 1;
            }
            dp[array[i] - 'a'] = Math.max(dp[array[i] - 'a'], len);
        }
        int result = 0;
        for (int i : dp) {
            result += i;
        }
        return result;
    }
}
