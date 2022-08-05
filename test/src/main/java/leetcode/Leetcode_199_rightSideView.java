package leetcode;


import algorithm.tree.TreeNode;

import java.util.*;

/**
 * @author zhiqungao@tencent.com
 * @date 2021/11/5 下午2:42
 */
public class Leetcode_199_rightSideView {

    public static void main(String[] args) {
        Leetcode_199_rightSideView l = new Leetcode_199_rightSideView();

    }

    public List<Integer> rightSideView(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        Queue<TreeNode> queue = new LinkedList<>();
        List<Integer> ans = new ArrayList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int m = queue.size();
            for (int i = 0; i < m; ++i) {
                TreeNode cur = queue.poll();
                if (i == m - 1) {
                    ans.add(cur.val);
                }
                if (cur.left != null) {
                    queue.offer(cur.left);
                }
                if (cur.right != null) {
                    queue.offer(cur.right);
                }
            }
        }
        return ans;

    }

}