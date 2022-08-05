package leetcode;

import java.util.*;

/**
 * @author zhiqungao@tencent.com
 * @date 2021/11/17 下午8:25
 */
public class Leetcode_710_blackList {

    public static void main(String[] args) {
        Leetcode_710_blackList l = new Leetcode_710_blackList();
        System.out.println(l.findLength(new int[]{1, 2, 3, 2, 1}, new int[]{3, 2, 1, 4, 7}));
    }

    public static class Solution {

        Random random;
        int m;
        Map<Integer, Integer> map;

        public Solution(int n, int[] blacklist) {
            Arrays.sort(blacklist);
            map = new HashMap<>();
            m = n - blacklist.length;
            random = new Random(1007);
            for (int l = 0, r = blacklist.length - 1, last = n - 1; l <= r; l++) {
                int next = blacklist[l];
                while (r >= 0 && last == blacklist[r]) {
                    --last;
                    --r;
                }
                map.put(next, last--);
            }
        }

        public int pick() {
            int rand = random.nextInt(m);
            return map.getOrDefault(rand, rand);
        }
    }

    public int minimumDeleteSum(String s1, String s2) {
        int m = s1.length(), n = s2.length();
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 0; i < m; ++i) {
            dp[i + 1][0] = dp[i][0] + s1.codePointAt(i);
        }
        for (int j = 0; j < n; ++j) {
            dp[0][j + 1] = dp[0][j] + s2.codePointAt(j);
        }

        for (int i = 1; i <= m; ++i) {
            for (int j = 1; j <= n; ++j) {
                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.min(dp[i][j - 1] + s2.codePointAt(j - 1),
                            dp[i - 1][j] + s1.codePointAt(i - 1));
                }
            }
        }
        return dp[m][n];
    }

    public int numSubarrayProductLessThanK(int[] nums, int k) {
        int ret = 0, l = 0, multi = 1;
        for (int r = 0; r < nums.length; r++) {
            multi *= nums[r];
            while (l <= r && multi >= k) {
                multi /= nums[l++];
            }
            ret += (r - l + 1);
        }
        return ret;
    }

    public int maxProfit(int[] prices, int fee) {
        int n = prices.length;
        int noHold = 0, hold = -prices[0];
        for (int i = 1; i < n; ++i) {
            noHold = Math.max(noHold, hold + prices[i] - fee);
            hold = Math.max(hold, noHold - prices[i]);
        }
        return noHold;
    }

    /**
     * 问最后一个字符是否必定为一个一比特字符
     *
     * @param bits
     * @return
     */
    public boolean isOneBitCharacter(int[] bits) {
        int i = bits.length - 2;
        while (i >= 0 && bits[i] > 0) {
            i--;
        }
        return (bits.length - i) % 2 == 0;
    }


    public int findLength(int[] nums1, int[] nums2) {
        int[][] dp = new int[nums1.length + 1][nums2.length + 1];
        int max = 0;
        for (int i = 0; i < nums1.length; i++) {
            for (int j = 0; j < nums2.length; j++) {
                if (nums1[i] == nums2[j]) {
                    dp[i + 1][j + 1] = 1 + dp[i][j];
                    max = Math.max(max, dp[i + 1][j + 1]);
                }
            }
        }
        return max;
    }

}