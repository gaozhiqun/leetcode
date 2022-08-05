package leetcode;


import algorithm.tree.TreeNode;

import java.util.*;

/**
 * @author zhiqungao@tencent.com
 * @date 2021/12/14 上午10:48
 */
public class Leetcode_514_findRotateSteps {


    public static void main(String[] args) {
        Leetcode_514_findRotateSteps l = new Leetcode_514_findRotateSteps();
        System.out.println(l.findRotateSteps("godding", "gd"));
    }

    List<Integer>[] pos;

    public int findRotateSteps(String ring, String key) {
        pos = new List[26];
        for (int i = 0; i < 26; i++) {
            pos[i] = new ArrayList<Integer>();
        }
        for (int i = 0; i < ring.length(); i++) {
            char ch = ring.charAt(i);
            pos[ch - 'a'].add(i);
        }
        return dfs(ring, 0, 0, key);
    }

    private int dfs(String ring, int cur, int m, String key) {
        if (cur >= key.length()) {
            return 0;
        }
        char ch = key.charAt(cur);
        List<Integer> nexts = pos[ch - 'a'];
        int min = Integer.MAX_VALUE;
        for (int next : nexts) {
            min = Math.min(min, Math.min(ring.length() - m + next, Math.abs(m - next)) + dfs(ring, cur + 1, next, key));
        }
        return min + 1;
    }

    public int findRotateSteps2(String ring, String key) {
        int n = ring.length(), m = key.length();
        List<Integer>[] pos = new List[26];
        for (int i = 0; i < 26; ++i) {
            pos[i] = new ArrayList<Integer>();
        }
        for (int i = 0; i < n; ++i) {
            pos[ring.charAt(i) - 'a'].add(i);
        }
        int[][] dp = new int[m][n];
        for (int i = 0; i < m; ++i) {
            Arrays.fill(dp[i], 0x3f3f3f);
        }
        for (int i : pos[key.charAt(0) - 'a']) {
            dp[0][i] = Math.min(i, n - i) + 1;
        }
        for (int i = 1; i < m; ++i) {
            for (int j : pos[key.charAt(i) - 'a']) {
                for (int k : pos[key.charAt(i - 1) - 'a']) {
                    dp[i][j] = Math.min(dp[i][j], dp[i - 1][k] + Math.min(Math.abs(j - k), n - Math.abs(j - k)) + 1);
                }
            }
        }
        return Arrays.stream(dp[m - 1]).min().getAsInt();
    }

    public List<Integer> largestValues(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        List<Integer> ans = new ArrayList<>();
        while (!queue.isEmpty()) {
            int size = queue.size();
            int max = Integer.MIN_VALUE;
            for (int i = 0; i < size; i++) {
                TreeNode cur = queue.poll();
                max = Math.max(max, cur.val);
                if (cur.left != null) {
                    queue.offer(cur.left);
                }
                if (cur.right != null) {
                    queue.offer(cur.right);
                }
            }
            ans.add(max);
        }
        return ans;
    }





}