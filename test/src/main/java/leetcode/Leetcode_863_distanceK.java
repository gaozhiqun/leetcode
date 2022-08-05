package leetcode;

import algorithm.tree.TreeNode;

import java.util.*;

/**
 * @author zhiqungao@tencent.com
 * @date 2022/1/28 下午4:11
 */
public class Leetcode_863_distanceK {
    public static void main(String[] args) {
        Leetcode_863_distanceK l = new Leetcode_863_distanceK();

    }

    private Map<Integer, TreeNode> parents;
    private List<Integer> ret;

    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        parents = new HashMap<>();
        ret = new ArrayList<>();
        findParents(root);
        findAns(target, null, 0, k);
        return ret;
    }

    public void findParents(TreeNode node) {
        if (node.left != null) {
            parents.put(node.left.val, node);
            findParents(node.left);
        }
        if (node.right != null) {
            parents.put(node.right.val, node);
            findParents(node.right);
        }
    }

    public void findAns(TreeNode node, TreeNode from, int depth, int k) {
        if (node == null) {
            return;
        }
        if (depth == k) {
            ret.add(node.val);
        }
        if (node.left != from) {
            findAns(node.left, node, depth + 1, k);
        }
        if (node.right != from) {
            findAns(node.right, node, depth + 1, k);
        }
        if (parents.get(node.val) != from) {
            findAns(parents.get(node.val), node, depth + 1, k);
        }
    }


}
