package leetcode;


import java.util.HashSet;
import java.util.Set;

/**
 * @author zhiqungao@tencent.com
 * @date 2022/6/26 下午8:29
 */
public class Leetcode_1080_sufficientSubset {


    private Boolean dfs(TreeNode node, int s, int limit) {
        if (node.left == null && node.right == null) {
            return s + node.val < limit;
        }
        boolean lTreeDeleted = true;
        boolean rTreeDeleted = true;
        if (node.left != null) {
            lTreeDeleted = dfs(node.left, s + node.val, limit);
        }
        if (node.right != null) {
            rTreeDeleted = dfs(node.right, s + node.val, limit);
        }

        if (lTreeDeleted) {
            node.left = null;
        }

        if (rTreeDeleted) {
            node.right = null;
        }
        return lTreeDeleted && rTreeDeleted;
    }

    public TreeNode sufficientSubset(TreeNode root, int limit) {
        boolean rootDeleted = dfs(root, 0, limit);
        if (rootDeleted) {
            return null;
        }
        return root;
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

}
