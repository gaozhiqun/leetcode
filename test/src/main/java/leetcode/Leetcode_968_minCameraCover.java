package leetcode;

import algorithm.tree.TreeNode;

import java.util.*;

/**
 * @author zhiqungao@tencent.com
 * @date 2022/3/28 下午7:11
 */
public class Leetcode_968_minCameraCover {
    public static void main(String[] args) {
        Leetcode_968_minCameraCover l = new Leetcode_968_minCameraCover();
    }

    private static final int PLACED = 0; //放置
    private static final int MONITORED = 1;// 监控
    private static final int NONE = 2; // 既不放置也没监控到
    private static final int MAX = Integer.MAX_VALUE / 3;


    public int minCameraCover(TreeNode root) {
        int[] ans = minCamera(root);
        return Math.min(ans[0], ans[1]);
    }

    public int[] minCamera(TreeNode root) {
        int[] dp = new int[3];
        if (root == null) {
            return new int[]{MAX, 0, 0};
        }
        int[] left = minCamera(root.left);
        int[] right = minCamera(root.right);
        dp[PLACED] = Math.min(left[PLACED], Math.min(left[MONITORED], left[NONE]))
                + Math.min(right[PLACED], Math.min(right[MONITORED], right[NONE])) + 1;
        dp[MONITORED] = Math.min(left[PLACED] + Math.min(right[PLACED], right[MONITORED]),
                right[PLACED] + Math.min(left[PLACED], left[MONITORED]));
        dp[NONE] = left[MONITORED] + right[MONITORED];
        return dp;
    }


}
