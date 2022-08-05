package leetcode;


import algorithm.tree.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author zhiqungao@tencent.com
 * @date 2021/12/14 上午10:48
 */
public class Leetcode_509_findBottomLeftValue {

    public static void main(String[] args) {
        Leetcode_509_findBottomLeftValue l = new Leetcode_509_findBottomLeftValue();
    }

    public int findBottomLeftValue(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int ans = root.val;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode cur = queue.poll();
            ans = cur.val;
            if (cur.right != null) {
                queue.offer(cur.right);
            }
            if (cur.left != null) {
                queue.offer(cur.left);
            }
        }
        return ans;

    }
}