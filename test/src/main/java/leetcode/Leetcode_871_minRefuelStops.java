package leetcode;

import algorithm.tree.TreeNode;

import java.util.*;

/**
 * @author zhiqungao@tencent.com
 * @date 2022/1/28 下午4:11
 */
public class Leetcode_871_minRefuelStops {
    public static void main(String[] args) {
        Leetcode_871_minRefuelStops l = new Leetcode_871_minRefuelStops();
    }

    //dp[i] 在N个加油站停留所能到达的最远距离


    public int minRefuelStops(int target, int startFuel, int[][] stations) {
        int N = stations.length;
        long[] dp = new long[N + 1];
        dp[0] = startFuel;
        for (int i = 0; i < N; ++i) {
            for (int t = i; t >= 0; --t) {
                if (dp[t] >= stations[i][0]) {
                    dp[t + 1] = Math.max(dp[t + 1], dp[t] + (long) stations[i][1]);
                }
            }
        }
        for (int i = 0; i <= N; ++i) {
            if (dp[i] >= target) {
                return i;
            }
        }
        return -1;
    }

    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        StringBuilder s1 = new StringBuilder();
        StringBuilder s2 = new StringBuilder();
        dfs(s1, root1);
        dfs(s2, root2);
        return s1.toString().equals(s2.toString());
    }

    public void dfs(StringBuilder sb, TreeNode root) {
        if (root.left == null && root.right == null) {
            sb.append(root.val);
            return;
        }
        if (root.left != null) {
            dfs(sb, root.left);
        }
        if (root.right != null) {
            dfs(sb, root.right);
        }
    }

}
