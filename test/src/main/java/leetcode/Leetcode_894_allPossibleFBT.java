package leetcode;

import algorithm.tree.TreeNode;

import java.util.*;

/**
 * @author zhiqungao@tencent.com
 * @date 2022/2/22 下午4:38
 */
public class Leetcode_894_allPossibleFBT {
    public static void main(String[] args) {
        Leetcode_894_allPossibleFBT l = new Leetcode_894_allPossibleFBT();
        List<TreeNode> ret = l.allPossibleFBT(7);
        System.out.println(ret.size());

    }

    Map<Integer, List<TreeNode>> map = new HashMap<>();

    public List<TreeNode> allPossibleFBT(int n) {
        if (n % 2 == 0) {
            return new ArrayList<>();
        }
        return buildTreeNode(n);
    }

    public List<TreeNode> buildTreeNode(int n) {
        if (map.containsKey(n)) {
            return map.get(n);
        }
        List<TreeNode> ret = new ArrayList<>();
        if (n == 1) {
            TreeNode newNode = new TreeNode(0);
            ret.add(newNode);
        } else {
            --n;
            for (int k = 1; k < n; k += 2) {
                List<TreeNode> lNodes = buildTreeNode(k);
                List<TreeNode> rNodes = buildTreeNode(n - k);
                for (TreeNode lnode : lNodes) {
                    for (TreeNode rnode : rNodes) {
                        TreeNode newNode = new TreeNode(0);
                        newNode.left = deepCopy(lnode);
                        newNode.right = deepCopy(rnode);
                        ret.add(newNode);
                    }
                }
            }
        }
        map.put(n, ret);
        return map.get(n);
    }

    private TreeNode deepCopy(TreeNode node) {
        if (node == null) {
            return null;
        }
        TreeNode newNode = new TreeNode(0);
        newNode.left = deepCopy(node.left);
        newNode.right = deepCopy(node.right);
        return newNode;
    }

}
