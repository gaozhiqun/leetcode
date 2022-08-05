package leetcode;


import algorithm.tree.TreeNode;

import java.util.Stack;

/**
 * @author zhiqungao@tencent.com
 * @date 2021/11/5 下午2:42
 */
public class Leetcode_173_BstIterator {

    public static void main(String[] args) {
        Leetcode_173_BstIterator l = new Leetcode_173_BstIterator();
    }

    /**
     * 表示一个按中序遍历二叉搜索树（BST）的迭代器：
     * LNR
     */

    public static class BSTIterator {

        Stack<TreeNode> stack;
        TreeNode cur;

        public BSTIterator(TreeNode root) {
            stack = new Stack<>();
            cur = root;
        }

        public int next() {
            int val = -1;
            if (cur != null || !stack.isEmpty()) {
                while (cur != null) {
                    stack.push(cur);
                    cur = cur.left;
                }
                TreeNode l = stack.pop();
                val = l.val;
                cur = l.right;
            }
            return val;
        }

        public boolean hasNext() {
            return !(stack.isEmpty() && cur == null);
        }
    }
}