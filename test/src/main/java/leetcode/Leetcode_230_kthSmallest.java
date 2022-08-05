package leetcode;


import algorithm.tree.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zhiqungao@tencent.com
 * @date 2021/11/5 下午2:42
 */
public class Leetcode_230_kthSmallest {

    public static void main(String[] args) {
        Leetcode_230_kthSmallest l = new Leetcode_230_kthSmallest();
        TreeNode root = new TreeNode(3);
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(4);
        TreeNode node3 = new TreeNode(2);
        root.left = node1;
        root.right = node2;
        node1.right = node3;
        System.out.println(l.kthSmallest(root, 1));
    }


    public int kthSmallest(TreeNode root, int k) {
        int l = getCount(root.left);
        if (l == k - 1) {
            return root.val;
        } else if (l < k) {
            return kthSmallest(root.right, k - l - 1);
        } else {
            return kthSmallest(root.left, k);
        }

    }

    private int getCount(TreeNode cur) {
        if (cur == null) {
            return 0;
        }
        return 1 + getCount(cur.left) + getCount(cur.right);
    }




}