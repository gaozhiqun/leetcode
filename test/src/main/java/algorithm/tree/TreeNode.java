package algorithm.tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author zhiqungao@tencent.com
 * @date 2021/3/22 7:36 下午
 */
public class TreeNode {

    public int val;
    public TreeNode left;
    public TreeNode right;

    public static void main(String[] args) {

    }

    public TreeNode(int val) {
        this.val = val;
    }

    //NLR
    public List<TreeNode> preOrder(TreeNode root) {
        List<TreeNode> result = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode peek = stack.pop();
            result.add(peek);
            if (peek.right != null) {
                stack.push(peek.right);
            }
            if (peek.left != null) {
                stack.push(peek.left);
            }
        }
        return result;
    }

    //LNR
    public List<TreeNode> midOrder(TreeNode root) {
        List<TreeNode> result = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        while (cur != null || !stack.isEmpty()) {
            while (cur != null) {
                stack.push(cur);
                cur = cur.left;
            }

            if (!stack.isEmpty()) {
                cur = stack.pop();
                result.add(cur);
                if (cur.right == null) {
                    stack.push(cur.right);
                }
            }
        }
        return result;
    }

    //LRN 后序
    public List<TreeNode> postOrder(TreeNode root) {
        TreeNode pre = null;
        TreeNode cur = root;
        List<TreeNode> result = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        do {
            while (cur != null) {
                stack.push(cur);
                cur = cur.left;
            }
            cur = stack.peek();
            if (cur.right != null && pre != cur.right) {
                cur = cur.right;
            } else {
                cur = stack.pop();
                result.add(cur);
                pre = cur;
                cur = null;
            }
        } while (cur != null || !stack.isEmpty());
        return result;
    }

    //LRN 后序
    public List<TreeNode> postOrder2Stack(TreeNode root) {

        List<TreeNode> result = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        Stack<TreeNode> popStack = new Stack<>();
        while (!stack.isEmpty()) {
            TreeNode cur = stack.pop();
            popStack.push(cur);
            if (cur.left != null) {
                stack.push(cur);
            }
            if (cur.right != null) {
                stack.push(cur);
            }
        }
        while (!popStack.isEmpty()) {
            result.add(popStack.pop());
        }
        return result;
    }

    int result = Integer.MIN_VALUE;

    public int dfs(TreeNode node) {
        if (node == null) {
            return 0;
        }
        int l = dfs(node.left);
        int r = dfs(node.right);
        result = Math.max(result, node.val + (l > 0 ? l : 0) + (r > 0 ? r : 0));
        return node.val + Math.max(dfs(node.left), dfs(node.right));
    }


}
