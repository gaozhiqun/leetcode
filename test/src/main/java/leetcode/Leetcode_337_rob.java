package leetcode;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * @author zhiqungao@tencent.com
 * @date 2021/12/2 下午9:11
 */
public class Leetcode_337_rob {

    public static void main(String[] args) {
        Leetcode_337_rob l = new Leetcode_337_rob();
        TreeNode node00 = new TreeNode(3);
        TreeNode node01 = new TreeNode(2);
        TreeNode node02 = new TreeNode(3);
        TreeNode node03 = new TreeNode(3);
        TreeNode node04 = new TreeNode(1);
        node00.left = node01;
        node00.right = node02;
        node01.right = node03;
        node02.right = node04;
        System.out.println(l.rob(node00));
    }
    Map<TreeNode, Integer> f = new HashMap<TreeNode, Integer>();
    Map<TreeNode, Integer> g = new HashMap<TreeNode, Integer>();

    public int rob(TreeNode root) {
        dfs(root);
        return Math.max(f.getOrDefault(root, 0), g.getOrDefault(root, 0));
    }

    public void dfs(TreeNode node) {
        if (node == null) {
            return;
        }
        dfs(node.left);
        dfs(node.right);
        f.put(node, node.val + g.getOrDefault(node.left, 0) + g.getOrDefault(node.right, 0));
        g.put(node, Math.max(f.getOrDefault(node.left, 0), g.getOrDefault(node.left, 0)) + Math.max(f.getOrDefault(node.right, 0), g.getOrDefault(node.right, 0)));
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
