package leetcode;

import algorithm.tree.TreeNode;

/**
 * @author zhiqungao@tencent.com
 * @date 2021/11/17 下午8:25
 */
public class Leetcode_814_pruneTree {

    public static void main(String[] args) {
        Leetcode_814_pruneTree l = new Leetcode_814_pruneTree();
    }

    public TreeNode pruneTree(TreeNode root) {
        if (!containsOne(root)) {
            return null;
        }
        return root;
    }

    public boolean containsOne(TreeNode cur) {
        if (cur == null) {
            return false;
        }
        boolean containL = containsOne(cur.left);
        boolean containR = containsOne(cur.right);
        if (!containL) {
            cur.left = null;
        }
        if (!containR) {
            cur.right = null;
        }
        return containL || containR || cur.val == 1;
    }

}