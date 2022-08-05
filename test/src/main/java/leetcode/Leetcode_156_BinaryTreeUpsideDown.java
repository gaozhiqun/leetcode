package leetcode;


import algorithm.tree.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author zhiqungao@tencent.com
 * @date 2021/11/5 下午2:42
 */
public class Leetcode_156_BinaryTreeUpsideDown {

    public static void main(String[] args) {
        Leetcode_156_BinaryTreeUpsideDown l = new Leetcode_156_BinaryTreeUpsideDown();
    }


    public TreeNode upsideDown(TreeNode root) {
        if (root == null || root.left == null) {
            return root;
        }
        TreeNode l = root.left, r = root.right;
        TreeNode res = upsideDown(l);
        l.left = r;
        l.right = root;
        root.left = null;
        root.right = null;
        return res;

    }

    public int sumOfLeftLeaves(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int ans = 0;
        while (!queue.isEmpty()) {
            TreeNode cur = queue.poll();
            if (cur.left != null) {
                if (cur.left.left == null && cur.left.right == null) {
                    ans += cur.left.val;
                }
                queue.offer(cur.left);
            }
            if (cur.right != null) {
                queue.offer(cur.right);
            }
        }
        return ans;

    }
}