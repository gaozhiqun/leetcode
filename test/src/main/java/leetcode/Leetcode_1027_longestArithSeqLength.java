package leetcode;


import algorithm.tree.TreeNode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

/**
 * @author zhiqungao@tencent.com
 * @date 2022/4/6 下午2:16
 */
public class Leetcode_1027_longestArithSeqLength {
    public static void main(String[] args) {
        Leetcode_1027_longestArithSeqLength l = new Leetcode_1027_longestArithSeqLength();
        TreeNode node = l.recoverFromPreorder("1-401--349---90--88");
        System.out.println(node);
    }

    public int longestArithSeqLength(int[] nums) {
        Map<Integer, Map<Integer, Integer>> lensMap = new HashMap<>();
        int ret = 0;
        for (int i = 0; i < nums.length; ++i) {
            Map<Integer, Integer> curMap = lensMap.computeIfAbsent(i, f -> new HashMap<>());
            for (int j = 0; j < i; ++j) {
                int g = nums[i] - nums[j];
                Map<Integer, Integer> preMap = lensMap.computeIfAbsent(j, f -> new HashMap<>());
                int len = preMap.getOrDefault(g, 1);
                int max = Math.max(len + 1, curMap.getOrDefault(g, 1));
                ret = Math.max(ret, max);
                curMap.put(g, max);
            }
        }
        return ret;
    }

    public int longestArithSeqLengthDp(int[] nums) {
        int N = nums.length;
        if (N == 1) {
            return 0;
        }
        int[][] dp = new int[N][1001];
        int ans = 0;
        for (int i = 0; i < nums.length; ++i) {
            for (int j = 0; j < i; ++j) {
                int d = nums[i] - nums[j] + 500;
                dp[i][d] = Math.max(dp[i][d], dp[j][d] + 1);
                ans = Math.max(ans, dp[i][d]);
            }
        }
        return ans + 1;
    }


    public TreeNode recoverFromPreorder(String traversal) {
        return buildNode(traversal, 0);
    }

    private TreeNode buildNode(String traversal, int depth) {
        int i = 0;
        int N = traversal.length();
        int ls = N, le = N;
        int rs = N, re = N;
        int digit = 0;
        while (i < N && Character.isDigit(traversal.charAt(i))) {
            digit = digit * 10 + (traversal.charAt(i) - '0');
            i++;
        }
        TreeNode node = new TreeNode(digit);
        ++depth;
        int curDepth = 0;
        while (i < traversal.length()) {
            if (traversal.charAt(i) == '-') {
                ++curDepth;
            } else {
                if (curDepth == depth) {
                    if (ls == N) {
                        ls = i;
                    } else {
                        rs = i;
                        le = i - depth;
                    }
                }
                curDepth = 0;
            }
            ++i;
        }
        if (ls < N) {
            node.left = buildNode(traversal.substring(ls, le), depth);
        }

        if (rs < N) {
            node.right = buildNode(traversal.substring(rs, re), depth);
        }
        return node;
    }


}
