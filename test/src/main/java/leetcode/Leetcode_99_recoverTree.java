package leetcode;



import java.util.*;

/**
 * @author zhiqungao@tencent.com
 * @date 2021/11/1 下午7:35
 */
public class Leetcode_99_recoverTree {

    /**
     * 10
     */

    public static void main(String[] args) {
        Leetcode_99_recoverTree l = new Leetcode_99_recoverTree();
    }

    public void recoverTree(TreeNode root) {
        List<TreeNode> inorder = inorderTraversal(root);
        TreeNode a = null, b = null;
        for (int i = 1; i < inorder.size(); i++) {
            if (inorder.get(i).val < inorder.get(i - 1).val) {
                a = inorder.get(i);
            }
            if (inorder.get(inorder.size() - i).val < inorder.get(inorder.size() - i - 1).val) {
                b = inorder.get(inorder.size() - i);
            }
        }
        int temp = a.val;
        a.val = b.val;
        b.val = temp;
    }

    List<TreeNode> inorderTraversal(TreeNode root) {
        List<TreeNode> ans = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        while (cur != null || !stack.isEmpty()) {
            while (cur != null) {
                stack.push(cur);
                cur = cur.left;
            }
            TreeNode l = stack.pop();
            ans.add(l);
            cur = l.right;
        }
        return ans;
    }

    public List<Integer> preorderTraversal(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        List<Integer> ans = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            ans.add(node.val);
            if (node.right != null) {
                stack.push(node.right);
            }
            if (node.left != null) {
                stack.push(node.left);
            }
        }
        return ans;

    }


    /**
     * LRN
     *
     * @param root
     * @return
     */
    public List<Integer> postorderTraversal(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        List<Integer> ans = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root, pre = null;
        do {
            while (cur != null) {
                stack.push(cur);
                cur = cur.left;
            }
            cur = stack.peek();
            if (cur.right != null && pre != cur.right) {
                cur = cur.right;
            } else {
                pre = stack.pop();
                ans.add(pre.val);
                cur = null;
            }
        } while (cur != null || !stack.isEmpty());
        return ans;
    }


    public static class TreeNode {
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
