package algorithm.tree;

import java.util.Stack;

/**
 * @author zhiqungao@tencent.com
 * @date 2021/8/26 上午10:58
 */
public class ConvertBST {
    public static void main(String[] args) {

    }

    public TreeNode convertBST(TreeNode root) {
        int sum = 0;
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        while (cur != null) {
            while (cur != null) {
                stack.push(cur);
                cur = cur.right;
            }

            if (!stack.isEmpty()) {
                cur = stack.pop();
                sum += cur.val;
                cur.val = sum;
                if (cur.left != null) {
                    stack.push(cur.left);
                }
            }
        }
        return root;
    }
}
