package algorithm.dp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author zhiqungao@tencent.com
 * @date 2021/7/1 上午10:44
 */
public class LargestDivisibleSubSets {

    public List<Integer> largestDivisibleSubSets(int[] nums) {
        int[] dp = new int[nums.length + 1];
        Arrays.fill(dp, 1);
        List<Integer> result = new ArrayList<>();
        int curMax = 1;
        int curIndex = 1;
        for (int i = 1; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] % nums[j] == 0) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            if (dp[i] > curMax) {
                curMax = dp[i];
                curIndex = i;
            }
        }
        for (int i = curIndex; i >= 0; i--) {
            if (nums[curIndex] % nums[i] == 0) {
                result.add(nums[i]);
            }
        }
        return result;
    }
}
