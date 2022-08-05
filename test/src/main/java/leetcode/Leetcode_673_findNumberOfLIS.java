package leetcode;

import java.util.*;

/**
 * @author zhiqungao@tencent.com
 * @date 2021/11/17 下午8:25
 */
public class Leetcode_673_findNumberOfLIS {

    public static void main(String[] args) {
        Leetcode_673_findNumberOfLIS l = new Leetcode_673_findNumberOfLIS();
        System.out.println(l.findNumberOfLIS(new int[]{1, 3, 5, 4, 7}));
        System.out.println(l.findNumberOfLIS(new int[]{2, 2, 2, 2, 2}));

    }

    public int findNumberOfLIS(int[] nums) {
        int m = nums.length;
        int[] dp = new int[m];
        int[] cnts = new int[m];
        Arrays.fill(dp, 1);
        Arrays.fill(cnts, 1);
        for (int i = 1; i < m; ++i) {
            for (int j = i - 1; j >= 0; --j) {
                if (nums[i] > nums[j] && dp[j] >= (dp[i] - 1)) {
                    if (dp[j] > dp[i] - 1) {
                        dp[i] = dp[j] + 1;
                        cnts[i] = cnts[j];
                    } else {
                        cnts[i] += cnts[j];
                    }
                }
            }
        }
        int maxLen = Arrays.stream(dp).max().getAsInt();
        int ret = 0;
        for (int i = 0; i < nums.length; ++i) {
            if (dp[i] == maxLen) {
                ret += cnts[i];
            }
        }
        return ret;
    }

}