package leetcode;

import algorithm.tree.TreeNode;

import java.util.Arrays;

/**
 * @author zhiqungao@tencent.com
 * @date 2021/11/17 下午8:25
 */
public class Leetcode_622_addOneRow {

    public static void main(String[] args) {
        Leetcode_622_addOneRow l = new Leetcode_622_addOneRow();

    }

    public TreeNode addOneRow(TreeNode root, int val, int depth) {
        if (root == null) {
            return root;
        }
        if (depth == 1) {
            TreeNode node = new TreeNode(val);
            node.left = root;
            return node;
        } else if (depth == 2) {
            TreeNode left = root.left;
            TreeNode right = root.right;
            root.left = new TreeNode(val);
            root.right = new TreeNode(val);
            root.left.left = left;
            root.right.right = right;
        } else {
            addOneRow(root.left, val, depth - 1);
            addOneRow(root.right, val, depth - 1);
        }
        return root;
    }

    public int maximumProduct(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        return Math.max(nums[0] * nums[1] * nums[n - 1], nums[n - 3] * nums[n - 2] * nums[n - 1]);
    }

}