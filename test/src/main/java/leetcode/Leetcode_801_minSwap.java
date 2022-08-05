package leetcode;

import java.util.Arrays;

/**
 * @author zhiqungao@tencent.com
 * @date 2021/11/17 下午8:25
 */
public class Leetcode_801_minSwap {

    public static void main(String[] args) {
        Leetcode_801_minSwap l = new Leetcode_801_minSwap();
        System.out.println(l.minSwap(new int[]{0, 3, 5, 8, 9}, new int[]{2, 1, 4, 6, 9}));
        System.out.println(l.minSwap(new int[]{1, 3, 5, 4}, new int[]{1, 2, 3, 7}));
    }


    public int minSwap(int[] nums1, int[] nums2) {
        if (nums1.length <= 1) {
            return 0;
        }
        int N = nums1.length;
        int MAX = 1000_000_007;
        int[][] dp = new int[N + 1][2];
        for (int[] row : dp) {
            Arrays.fill(row, MAX);
        }
        dp[0][0] = 0;
        dp[0][1] = 0;
        dp[1][0] = 0;
        dp[1][1] = 1;
        for (int i = 1; i < N; ++i) {
            if (dp[i][0] < MAX) {
                //i-1没交换
                if (nums1[i] > nums1[i - 1] && nums2[i] > nums2[i - 1]) {
                    //不需要交换
                    dp[i + 1][0] = Math.min(dp[i + 1][0], dp[i][0]);
                }
                if (nums1[i] > nums2[i - 1] && nums2[i] > nums1[i - 1]) {
                    //需要交换
                    dp[i + 1][1] = Math.min(dp[i + 1][1], dp[i][0] + 1);
                }
            }
            if (dp[i][1] < MAX) {
                //i-1进行了交换
                if (nums1[i] > nums2[i - 1] && nums2[i] > nums1[i - 1]) {
                    //不需要交换
                    dp[i + 1][0] = Math.min(dp[i + 1][0], dp[i][1]);
                }
                if (nums1[i] > nums1[i - 1] && nums2[i] > nums2[i - 1]) {
                    //需要交换
                    dp[i + 1][1] = Math.min(dp[i + 1][1], dp[i][1] + 1);
                }
            }
        }
        int ret = Math.min(dp[N][0], dp[N][1]);
        return MAX == ret ? -1 : ret;
    }
}