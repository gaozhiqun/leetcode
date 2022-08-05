package algorithm.dp;

import java.util.Arrays;
import java.util.Map;

/**
 * @author zhiqungao@tencent.com
 * @date 2021/9/1 下午7:19
 */
public class FindNumberOfLIS {
    public static void main(String[] args) {
        FindNumberOfLIS findNumberOfLIS = new FindNumberOfLIS();
        System.out.println(findNumberOfLIS.findNumberOfLIS(new int[]{1, 1, 1, 1, 1}));
        System.out.println(findNumberOfLIS.findNumberOfLIS(new int[]{1, 3, 5, 4, 7}));
    }

    public int findNumberOfLIS(int[] nums) {
        int m = nums.length;
        int dp[] = new int[m];
        int cnts[] = new int[m];
        Arrays.fill(cnts, 1);
        int max = 1;
        int cnt = 0;
        for (int i = 0; i < nums.length; i++) {
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    if (dp[j] + 1 > dp[i]) {
                        cnts[i] = 1;
                        dp[i] = Math.max(dp[i], dp[j] + 1);
                    } else if (dp[j] + 1 == dp[i]) {
                        cnts[i]++;
                    }
                    max = Math.max(dp[i], max);
                }
            }
        }
        for (int i = 0; i < m; ++i) {
            if (dp[i] == max) {
                cnt += cnts[i];
            }
        }
        return cnt;
    }
}
