package leetcode;

import algorithm.tree.TreeNode;

import java.util.*;

/**
 * @author zhiqungao@tencent.com
 * @date 2022/6/27 下午2:21
 */
public class Leetcode_1110_delNodes {


    public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
        if (root == null) {
            return new ArrayList<>();
        }
        List<TreeNode> nodes = new ArrayList<>();
        Set<Integer> deleteNodes = new HashSet<>();
        for (int i : to_delete) {
            deleteNodes.add(i);
        }
        if (!deleteNodes.contains(root.val)) {
            nodes.add(root);
        }
        delete(null, root, deleteNodes, nodes);
        return nodes;
    }

    private void delete(TreeNode pre, TreeNode cur, Set<Integer> deleteNodes, List<TreeNode> nodes) {
        if (cur == null) {
            return;
        }
        if (deleteNodes.contains(cur.val)) {
            if (pre != null) {
                if (pre.left == cur) {
                    pre.left = null;
                } else {
                    pre.right = null;
                }
            }
            if (cur.left != null && !deleteNodes.contains(cur.left.val)) {
                nodes.add(cur.left);
            }
            if (cur.right != null && !deleteNodes.contains(cur.right.val)) {
                nodes.add(cur.right);
            }
        }
        delete(cur, cur.left, deleteNodes, nodes);
        delete(cur, cur.right, deleteNodes, nodes);
    }

}
