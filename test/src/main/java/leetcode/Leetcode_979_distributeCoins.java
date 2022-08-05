package leetcode;

import algorithm.tree.TreeNode;

/**
 * @author zhiqungao@tencent.com
 * @date 2022/3/29 下午4:31
 */
public class Leetcode_979_distributeCoins {
    public static void main(String[] args) {
        TreeNode node0 = new TreeNode(1);
        TreeNode node1 = new TreeNode(0);
        TreeNode node2 = new TreeNode(0);
        TreeNode node3 = new TreeNode(3);
        node0.left = node1;
        node0.right = node2;
        node1.right = node3;
        Leetcode_979_distributeCoins l = new Leetcode_979_distributeCoins();
        System.out.println(l.distributeCoins(node0));

        node0 = new TreeNode(0);
        node1 = new TreeNode(3);
        node2 = new TreeNode(0);
        node0.left = node1;
        node0.right = node2;
        System.out.println(l.distributeCoins(node0));

        node0 = new TreeNode(3);
        node1 = new TreeNode(0);
        node2 = new TreeNode(0);
        node0.left = node1;
        node0.right = node2;
        System.out.println(l.distributeCoins(node0));

        node0 = new TreeNode(1);
        node1 = new TreeNode(0);
        node2 = new TreeNode(2);
        node0.left = node1;
        node0.right = node2;
        System.out.println(l.distributeCoins(node0));


    }


    public int distributeCoins(TreeNode root) {
        int[] ret = dfs(root);
        return ret[0];
    }

    private int[] dfs(TreeNode cur) {
        if (cur == null) {
            return new int[]{0, 0};
        }
        int[] l = dfs(cur.left);
        int[] r = dfs(cur.right);
        int lackOrMore = l[1] + r[1] + cur.val - 1;
        int move = l[0] + r[0] + Math.abs(l[1]) + Math.abs(r[1]);
        return new int[]{move, lackOrMore};
    }
}
