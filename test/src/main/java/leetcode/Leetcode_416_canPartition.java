package leetcode;

import java.util.*;

/**
 * @author zhiqungao@tencent.com
 * @date 2021/12/13 下午3:13
 */
public class Leetcode_416_canPartition {
    public static void main(String[] args) {
        Leetcode_416_canPartition leetcode_416_canPartition = new Leetcode_416_canPartition();
        System.out.println(leetcode_416_canPartition.canPartition(new int[]{
                1, 2, 3, 5
        }));
    }

    /**
     * 1 <= nums.length <= 200
     * 1 <= nums[i] <= 100
     */

    public boolean canPartition(int[] nums) {
        int n = nums.length;
        if (n < 2) {
            return false;
        }
        int sum = 0, maxNum = 0;
        for (int num : nums) {
            sum += num;
            maxNum = Math.max(maxNum, num);
        }
        if (sum % 2 != 0) {
            return false;
        }
        int target = sum / 2;
        if (maxNum > target) {
            return false;
        }
        boolean[] dp = new boolean[target + 1];
        dp[0] = true;
        for (int i = 0; i < n; i++) {
            int num = nums[i];
            for (int j = target; j >= num; --j) {
                dp[j] |= dp[j - num];
            }
        }
        return dp[target];
    }

}

