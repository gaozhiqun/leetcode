package leetcode;

import algorithm.tree.TreeNode;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @author zhiqungao@tencent.com
 * @date 2021/11/17 下午8:25
 */
public class Leetcode_300_lengthOfLIS {
    public static void main(String[] args) {
        Leetcode_300_lengthOfLIS l = new Leetcode_300_lengthOfLIS();
        System.out.println(l.lengthOfLIS(new int[]{10, 9, 2, 5, 3, 7, 101, 18}));
        System.out.println(l.lengthOfLIS(new int[]{0, 1, 0, 3, 2, 3}));
        System.out.println(l.lengthOfLIS(new int[]{7, 7, 7, 7, 7, 7, 7}));


    }

    public int lengthOfLIS(int[] nums) {
        int m = nums.length;
        if (m == 0) {
            return 0;
        }
        int[] dp = new int[m];
        Arrays.fill(dp, 1);
        for (int i = 1; i < m; ++i) {
            for (int j = i - 1; j >= 0; j--) {
                if (nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[j] + 1, dp[i]);
                }
            }
        }
        return Arrays.stream(dp).max().getAsInt();
    }

}
