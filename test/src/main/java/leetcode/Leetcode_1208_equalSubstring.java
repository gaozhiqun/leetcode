package leetcode;

import java.util.Arrays;

/**
 * @author zhiqungao@tencent.com
 * @date 2022/7/13 下午9:17
 */
public class Leetcode_1208_equalSubstring {
    public static void main(String[] args) {
        Leetcode_1208_equalSubstring l = new Leetcode_1208_equalSubstring();
        System.out.println(l.equalSubstring("krrgw", "zjxss", 19));

    }

    /**
     * "krrgw"
     * "zjxss"
     * 19
     *
     * @param s
     * @param t
     * @param maxCost
     * @return
     */

    public int equalSubstring(String s, String t, int maxCost) {
        int n = s.length();
        int[] diff = new int[n];
        for (int i = 0; i < n; i++) {
            diff[i] = Math.abs(s.charAt(i) - t.charAt(i));
        }
        int maxLength = 0;
        int start = 0, end = 0;
        int sum = 0;
        while (end < n) {
            sum += diff[end];
            while (sum > maxCost) {
                sum -= diff[start];
                start++;
            }
            maxLength = Math.max(maxLength, end - start + 1);
            end++;
        }
        return maxLength;
    }


}
