package leetcode;

import algorithm.tree.TreeNode;

import javax.management.MBeanAttributeInfo;
import java.util.*;

/**
 * @author zhiqungao@tencent.com
 * @date 2021/11/17 下午8:25
 */
public class Leetcode_698_canPartitionKSubsets {

    public static void main(String[] args) {
        Leetcode_698_canPartitionKSubsets l = new Leetcode_698_canPartitionKSubsets();
        /**
         * [2,2,2,2,3,4,5]
         * 4
         */
        System.out.println(l.canPartitionKSubsets(new int[]{2, 2, 2, 2, 3, 4, 5}, 4));
        System.out.println(l.canPartitionKSubsets(new int[]{4, 3, 2, 3, 5, 2, 1}, 4));
    }

    /**
     * 1 <= k <= len(nums) <= 16
     * 0 < nums[i] < 10000
     *
     * @param nums
     * @param k
     * @return
     */

    public boolean canPartitionKSubsets(int[] nums, int k) {
        if (k == 1) {
            return true;
        }

        int len = nums.length;
        Arrays.sort(nums);
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        if (sum % k != 0) {
            return false;
        }
        int target = sum / k;
        if (nums[len - 1] > target) {
            return false;
        }

        int size = 1 << len;
        boolean[] dp = new boolean[size];
        dp[0] = true;
        int[] currentSum = new int[size];
        for (int i = 0; i < size; i++) {
            // 总是基于 dp[i] = true 的前提下进行状态转移
            if (!dp[i]) {
                continue;
            }

            // 基于当前状态，添加一个数以后
            for (int j = 0; j < len; j++) {
                if ((i & (1 << j)) != 0) {
                    continue;
                }
                int next = i | (1 << j);
                if (dp[next]) {
                    continue;
                }
                if ((currentSum[i] % target) + nums[j] <= target) {
                    currentSum[next] = currentSum[i] + nums[j];
                    dp[next] = true;
                } else {
                    break;
                }
            }
        }
        return dp[size - 1];
    }


}