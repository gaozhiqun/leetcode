package leetcode;

import algorithm.HanmingWeight;
import algorithm.tree.TreeNode;

import java.util.*;

/**
 * @author zhiqungao@tencent.com
 * @date 2022/4/2 下午2:38
 */
public class Leetcode_1017_baseNeg2 {
    public static void main(String[] args) {
        Leetcode_1017_baseNeg2 leetcode_1017_baseNeg2 = new Leetcode_1017_baseNeg2();
        System.out.println(leetcode_1017_baseNeg2.videoStitching(new int[][]{{0, 2}, {4, 6}, {8, 10}, {1, 9}, {1, 5}, {5, 9}}, 10));
        System.out.println(leetcode_1017_baseNeg2.videoStitching(new int[][]{{0, 1}, {1, 2}}, 5));
        System.out.println(leetcode_1017_baseNeg2.videoStitching(new int[][]{{0, 1}, {6, 8}, {0, 2}, {5, 6}, {0, 4}, {0, 3}, {6, 7}, {1, 3}, {4, 7}, {1, 4}, {2, 5}, {2, 6}, {3, 4}, {4, 5}, {5, 7}, {6, 9}}, 9));
    }


    List<Integer> baseK(int N, int K) {
        if (N == 0) {
            return Arrays.asList(0);
        }
        List<Integer> res = new ArrayList<>();
        while (N != 0) {
            int r = ((N % K) + Math.abs(K)) % Math.abs(K);
            res.add(r);
            N -= r;
            N /= K;
        }
        Collections.reverse(res);
        return res;
    }

    public String baseNeg2(int N) {
        List<Integer> nums = baseK(N, -2);
        StringBuilder res = new StringBuilder();
        for (int x : nums) {
            res.append(x);
        }
        return res.toString();
    }

    public String removeOuterParentheses(String s) {
        LinkedList<Character> linkedList = new LinkedList<>();
        int b = 0;
        StringBuilder sb = new StringBuilder();
        for (char ch : s.toCharArray()) {
            linkedList.addLast(ch);
            if (ch == '(') {
                ++b;
            } else {
                --b;
            }
            if (b == 0) {
                linkedList.pollFirst();
                linkedList.pollLast();
                while (!linkedList.isEmpty()) {
                    sb.append(linkedList.pollFirst());
                }
            }
        }
        return sb.toString();

    }


    public boolean queryString(String s, int n) {
        for (int i = 1; i <= n; i++) {
            if (!s.contains(Integer.toBinaryString(i))) {
                return false;
            }
        }
        return true;
    }

    int ret;

    public int sumRootToLeaf(TreeNode root) {
        ret = 0;
        dfs(root, 0);
        return ret;
    }

    private void dfs(TreeNode root, int val) {
        if (root == null) {
            return;
        }
        val = (val << 1) + root.val;
        if (root.left == null && root.right == null) {
            ret += val;
            return;
        }
        dfs(root.left, val);
        dfs(root.right, val);
    }

    public List<Boolean> camelMatch(String[] queries, String pattern) {
        List<Boolean> ret = new ArrayList<>();
        for (String q : queries) {
            ret.add(match(q, pattern));
        }
        return ret;
    }

    private boolean match(String query, String pattern) {
        int index = 0;
        for (char c : query.toCharArray()) {
            if (index == pattern.length()) {
                if (c < 'a' || c > 'z') {
                    return false;
                }
            } else {
                if (c == pattern.charAt(index)) {
                    index++;
                } else if (c < 'a' || c > 'z') {
                    return false;
                }
            }
        }
        return index == pattern.length();
    }

    public int videoStitching(int[][] clips, int time) {
        int[] dp = new int[time + 1];
        Arrays.fill(dp, Integer.MAX_VALUE / 3);
        dp[0] = 0;
        for (int i = 1; i <= time; i++) {
            for (int[] clip : clips) {
                if (clip[0] < i && i <= clip[1]) {
                    dp[i] = Math.min(dp[i], dp[clip[0]] + 1);
                }
            }
        }
        return dp[time] == Integer.MAX_VALUE / 3 ? -1 : dp[time];
    }

    public boolean divisorGame(int n) {
        return n % 2 == 0;
    }

    int ans;

    public int maxAncestorDiff(TreeNode root) {
        ans = 0;
        dfs(root, root.val, root.val);
        return ans;
    }

    private void dfs(TreeNode cur, int min, int max) {
        if (cur == null) {
            return;
        }
        ans = Math.max(ans, Math.max(Math.abs(cur.val - min), Math.abs(cur.val - max)));
        min = Math.min(cur.val, min);
        max = Math.max(cur.val, max);
        dfs(cur.left, min, max);
        dfs(cur.right, min, max);
    }

}
