package algorithm.tree;

import java.util.*;

/**
 * @author zhiqungao@tencent.com
 * @date 2021/10/28 下午7:40
 */
public class InsertIntoMaxTree {
    public TreeNode insertIntoMaxTree(TreeNode root, int val) {
        if (root == null || val > root.val) {
            TreeNode node = new TreeNode(val);
            node.left = root;
            return node;
        }
        root.right = insertIntoMaxTree(root.right, val);
        return root;
    }


    public int successor(TreeNode root) {
        root = root.right;
        while (root.left != null) {
            root = root.left;
        }
        return root.val;
    }

    public int predecessor(TreeNode root) {
        root = root.left;
        while (root.right != null) {
            root = root.right;
        }
        return root.val;
    }

    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) {
            return null;
        }
        if (key > root.val) {
            root.right = deleteNode(root.right, key);
        } else if (key < root.val) {
            root.left = deleteNode(root.left, key);
        } else {
            if (root.left == null && root.right == null) {
                root = null;
            } else if (root.right != null) {
                root.val = successor(root);
                root.right = deleteNode(root.right, root.val);
            } else {
                root.val = predecessor(root);
                root.left = deleteNode(root.left, root.val);
            }
        }
        return root;
    }


    public StringBuilder postorder(TreeNode root, StringBuilder sb) {
        if (root == null) {
            return sb;
        }
        postorder(root.left, sb);
        postorder(root.right, sb);
        sb.append(root.val);
        sb.append(' ');
        return sb;
    }

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder sb = postorder(root, new StringBuilder());
        if (sb.length() > 0) {
            sb.deleteCharAt(sb.length() - 1);
        }
        return sb.toString();
    }

    public TreeNode helper(Integer lower, Integer upper, ArrayDeque<Integer> nums) {
        if (nums.isEmpty()) {
            return null;
        }
        int val = nums.getLast();
        if (val < lower || val > upper) {
            return null;
        }
        nums.removeLast();
        TreeNode root = new TreeNode(val);
        root.right = helper(val, upper, nums);
        root.left = helper(lower, val, nums);
        return root;
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data.isEmpty()) {
            return null;
        }

        ArrayDeque<Integer> nums = new ArrayDeque<Integer>();
        for (String s : data.split("\\s+")) {
            nums.add(Integer.valueOf(s));
        }

        return helper(Integer.MIN_VALUE, Integer.MAX_VALUE, nums);
    }


}
