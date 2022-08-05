package leetcode;

import algorithm.tree.TreeNode;

import java.util.*;

/**
 * @author zhiqungao@tencent.com
 * @date 2022/1/12 上午10:26
 */
public class Leetcode_785_isBipartite {

    public static void main(String[] args) {
        Leetcode_785_isBipartite l = new Leetcode_785_isBipartite();
        System.out.println(l.letterCasePermutation("a1b2"));
    }

    private static final int UNCOLORED = 0;
    private static final int RED = 1;
    private static final int GREEN = 2;
    private int[] color;

    public boolean isBipartite(int[][] graph) {
        int n = graph.length;
        color = new int[n];
        Arrays.fill(color, UNCOLORED);
        for (int i = 0; i < n; ++i) {
            if (color[i] == UNCOLORED) {
                Queue<Integer> queue = new LinkedList<Integer>();
                queue.offer(i);
                color[i] = RED;
                while (!queue.isEmpty()) {
                    int node = queue.poll();
                    int cNei = color[node] == RED ? GREEN : RED;
                    for (int neighbor : graph[node]) {
                        if (color[neighbor] == UNCOLORED) {
                            queue.offer(neighbor);
                            color[neighbor] = cNei;
                        } else if (color[neighbor] != cNei) {
                            return false;
                        }
                    }
                }
            }
        }
        return true;
    }

    public List<String> letterCasePermutation(String s) {
        List<String> ret = new ArrayList<>();
        dfs(ret, s, new StringBuilder(), 0);
        return ret;
    }

    public void dfs(List<String> temp, String s, StringBuilder sb, int cur) {
        if (cur == s.length()) {
            temp.add(sb.toString());
            return;
        }
        char ch = s.charAt(cur);
        if (Character.isDigit(ch)) {
            sb.append(ch);
            dfs(temp, s, sb, cur + 1);
            sb.deleteCharAt(sb.length() - 1);
        } else {
            sb.append(Character.toLowerCase(ch));
            dfs(temp, s, sb, cur + 1);
            sb.deleteCharAt(sb.length() - 1);
            sb.append(Character.toUpperCase(ch));
            dfs(temp, s, sb, cur + 1);
            sb.deleteCharAt(sb.length() - 1);
        }
    }

    /**
     * LNR
     *
     * @param root
     * @return
     */
    int ans;

    public int minDiffInBST(TreeNode root) {
        ans = Integer.MAX_VALUE;
        dfs(root, new ArrayList<>());
        return ans;

    }

    private void dfs(TreeNode root, List<Integer> list) {
        if (root == null) {
            return;
        }
        dfs(root.left, list);
        if (list.size() > 0) {
            int pre = list.get(list.size() - 1);
            ans = Math.min(root.val - pre, ans);
        }
        list.add(root.val);
        dfs(root.right, list);
    }
}

