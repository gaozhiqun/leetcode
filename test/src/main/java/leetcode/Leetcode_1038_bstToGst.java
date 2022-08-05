package leetcode;

import algorithm.tree.TreeNode;

/**
 * @author zhiqungao@tencent.com
 * @date 2022/4/7 上午10:49
 */
public class Leetcode_1038_bstToGst {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(4);
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(6);
        root.left = node1;
        root.right = node2;
        TreeNode node3 = new TreeNode(0);
        TreeNode node4 = new TreeNode(2);
        node1.left = node3;
        node1.right = node4;
        TreeNode node5 = new TreeNode(5);
        TreeNode node6 = new TreeNode(7);
        node2.left = node5;
        node2.right = node6;
        TreeNode node7 = new TreeNode(3);
        node4.right = node7;
        TreeNode node8 = new TreeNode(8);
        node6.right = node8;
        Leetcode_1038_bstToGst l = new Leetcode_1038_bstToGst();
        l.bstToGst(root);
        System.out.println(root.val);
    }


    public TreeNode bstToGst(TreeNode root) {
        dfsSum(root, 0);
        return root;
    }

    private int dfsSum(TreeNode cur, int preSum) {
        if (cur == null) {
            return 0;
        }
        int rSum = dfsSum(cur.right, preSum);
        int val = cur.val;
        cur.val += rSum + preSum;
        int lSum = dfsSum(cur.left, cur.val);
        return val + rSum + lSum;
    }
}
