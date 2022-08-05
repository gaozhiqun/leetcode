package algorithm.dp;

import java.util.Arrays;

/**
 * @author zhiqungao@tencent.com
 * @date 2021/7/1 下午5:17
 */
public class WiggleMaxLength {
    public static void main(String[] args) {

    }

    /**
     * dp[i][j] == dp[i][m] + dp[k] + dp[n][j]
     *
     * @param nums
     * @return
     */

    public int wiggleMaxLength(int[] nums) {
        int m = nums.length;
        int[] up = new int[m];
        int[] down = new int[m];
        Arrays.fill(up, 1);
        Arrays.fill(down, 1);
        for (int i = 1; i < m; i++) {
            if (nums[i] > nums[i - 1]) {
                up[i] = up[i - 1] + 1;
                down[i] = down[i - 1];
            } else if (nums[i] < nums[i - 1]) {
                up[i] = up[i - 1];
                down[i] = down[i - 1] + 1;
            } else {
                up[i] = up[i - 1];
                down[i] = down[i - 1];
            }
        }
        return Math.max(up[m - 1], down[m - 1]);


    }
}
