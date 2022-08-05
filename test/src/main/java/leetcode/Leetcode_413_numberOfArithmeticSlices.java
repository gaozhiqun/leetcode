package leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author zhiqungao@tencent.com
 * @date 2021/12/13 下午3:13
 */
public class Leetcode_413_numberOfArithmeticSlices {
    public static void main(String[] args) {
        Leetcode_413_numberOfArithmeticSlices leetcode_416_canPartition = new Leetcode_413_numberOfArithmeticSlices();
        System.out.println(leetcode_416_canPartition.numberOfArithmeticSlices2(new int[]{
                1, 2, 3, 4
        }));

    }

    public int numberOfArithmeticSlices(int[] nums) {
        int n = nums.length;
        if (n == 1) {
            return 0;
        }

        int d = nums[0] - nums[1], t = 0;
        int ans = 0;
        // 因为等差数列的长度至少为 3，所以可以从 i=2 开始枚举
        //连续等差数列
        for (int i = 2; i < n; ++i) {
            if (nums[i - 1] - nums[i] == d) {
                ++t;
            } else {
                d = nums[i - 1] - nums[i];
                t = 0;
            }
            ans += t;
        }
        return ans;
    }

    public int numberOfArithmeticSlices2(int[] nums) {
        int ans = 0;
        int[] dp = new int[nums.length];
        for (int i = 2; i < nums.length; i++) {
            if (nums[i] - nums[i - 1] == nums[i - 1] - nums[i - 2]) {
                dp[i] = dp[i - 1] + 1;
                ans += dp[i];
            }
        }
        return ans;
    }


}

