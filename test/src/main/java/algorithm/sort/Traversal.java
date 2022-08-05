package algorithm.sort;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author zhiqungao@tencent.com
 * @date 2022/6/14 下午8:14
 */
public class Traversal {


    public static class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);
        TreeNode node6 = new TreeNode(6);
        TreeNode node7 = new TreeNode(7);
        node1.left = node2;
        node1.right = node3;
        node2.left = node4;
        node2.right = node5;
        node3.left = node6;
        node3.right = node7;
        Traversal traversal = new Traversal();
        int[][] ret = traversal.threeOrders(null);
        System.out.println(ret);

        System.out.println(traversal.preOrder(node1));
        System.out.println(traversal.midOrder(node1));
        System.out.println(traversal.postOrder(node1));

    }

    public int[][] threeOrders(TreeNode root) {
        if (root == null) {
            return new int[3][0];
        }
        // write code here
        int[][] ret = new int[3][];
        ret[0] = list2Arr(preOrder(root));
        ret[1] = list2Arr(midOrder(root));
        ret[2] = list2Arr(postOrder(root));
        return ret;
    }

    private int[] list2Arr(List<Integer> arr) {
        int[] ret = new int[arr.size()];
        int i = 0;
        for (int n : arr) {
            ret[i++] = n;
        }
        return ret;
    }


    /**
     * NLR
     *
     * @param root
     * @return
     */
    private List<Integer> preOrder(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        List<Integer> ret = new ArrayList<>();
        while (!stack.isEmpty()) {
            TreeNode peek = stack.pop();
            ret.add(peek.val);
            if (peek.right != null) {
                stack.push(peek.right);
            }
            if (peek.left != null) {
                stack.push(peek.left);
            }
        }
        return ret;
    }

    /**
     * LNR
     *
     * @param root
     * @return
     */
    private List<Integer> midOrder(TreeNode root) {
        List<Integer> ret = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        do {
            while (cur != null) {
                stack.push(cur);
                cur = cur.left;
            }
            cur = stack.pop();
            ret.add(cur.val);
            cur = cur.right;
        } while (cur != null || !stack.isEmpty());
        return ret;
    }

    /**
     * LRN
     *
     * @param root
     * @return
     */
    private List<Integer> postOrder(TreeNode root) {
        List<Integer> ret = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        Stack<TreeNode> popStack = new Stack<>();
        TreeNode cur = root;
        stack.push(cur);
        while (!stack.isEmpty()) {
            cur = stack.pop();
            popStack.push(cur);
            if (cur.left != null) {
                stack.push(cur.left);
            }
            if (cur.right != null) {
                stack.push(cur.right);
            }
        }
        while (!popStack.isEmpty()) {
            ret.add(popStack.pop().val);
        }
        return ret;
    }

}
