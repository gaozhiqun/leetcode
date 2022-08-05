package leetcode;

import algorithm.tree.TreeNode;

import java.util.*;

/**
 * @author zhiqungao@tencent.com
 * @date 2022/3/16 下午3:17
 */
public class Leetcode_998_insertIntoMaxTree {
    public static void main(String[] args) {
        Leetcode_998_insertIntoMaxTree l = new Leetcode_998_insertIntoMaxTree();
    }

    public TreeNode insertIntoMaxTree(TreeNode root, int val) {
        if (root == null) {
            return new TreeNode(val);
        }
        if (val > root.val) {
            TreeNode newRoot = new TreeNode(val);
            newRoot.left = root;
            return newRoot;
        }
        root.right = insertIntoMaxTree(root.right, val);
        return root;

    }

    public int findJudge(int n, int[][] trust) {
        int[] trustCnt = new int[n];
        boolean[] innocent = new boolean[n];
        for (int[] p : trust) {
            innocent[p[0] - 1] = true;
            trustCnt[p[1] - 1]++;
        }
        for (int i = 0; i < n; i++) {
            if (trustCnt[i] == (n - 1) && !innocent[i]) {
                return i + 1;
            }
        }
        return -1;

    }

}
