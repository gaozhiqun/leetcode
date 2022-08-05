package leetcode;

import algorithm.tree.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author zhiqungao@tencent.com
 * @date 2022/6/27 下午3:59
 */
public class Leetcode_1123_lcaDeepestLeaves {
    public static void main(String[] args) {
        TreeNode node3 = new TreeNode(3);
        TreeNode node5 = new TreeNode(5);
        TreeNode node1 = new TreeNode(1);
        TreeNode node6 = new TreeNode(6);
        TreeNode node2 = new TreeNode(2);
        TreeNode node0 = new TreeNode(0);
        TreeNode node8 = new TreeNode(8);
        TreeNode node7 = new TreeNode(7);
        TreeNode node4 = new TreeNode(4);
        Leetcode_1123_lcaDeepestLeaves l = new Leetcode_1123_lcaDeepestLeaves();
        node3.left = node5;
        node3.right = node1;
        node5.left = node6;
        node5.right = node2;
        node2.left = node7;
        node2.right = node4;
        node1.left = node0;
        node1.right = node8;

        TreeNode node = l.lcaDeepestLeaves(node3);
        System.out.println(node.val);
    }

    public TreeNode lcaDeepestLeaves(TreeNode cur) {
        int ld = getDepth(cur.left);
        int rd = getDepth(cur.right);
        if (ld == rd) {
            return cur;
        } else if (ld > rd) {
            return lcaDeepestLeaves(cur.left);
        } else {
            return lcaDeepestLeaves(cur.right);
        }

    }

    private int getDepth(TreeNode cur) {
        if (cur == null) {
            return 0;
        }
        return Math.max(getDepth(cur.left), getDepth(cur.right)) + 1;
    }


    public TreeNode lcaDeepestLeaves2(TreeNode root) {
        if (root == null || root.left == null && root.right == null) {
            return root;
        }
        LinkedList<LinkedList<TreeNode>> dfsRet = new LinkedList<>();
        dfs(dfsRet, new LinkedList<>(), root);
        if (dfsRet.size() == 1) {
            return dfsRet.get(0).pollLast();
        }
        TreeNode cur = null;
        outter:
        while (true) {
            List<TreeNode> nexts = new ArrayList<>();
            for (LinkedList<TreeNode> list : dfsRet) {
                nexts.add(list.pollLast());
            }
            cur = nexts.get(0);
            for (TreeNode node : nexts) {
                if (node != cur) {
                    continue outter;
                }
            }
            return cur;
        }
    }

    private void dfs(LinkedList<LinkedList<TreeNode>> dfsRet, LinkedList<TreeNode> temp, TreeNode cur) {
        if (cur == null) {
            if (!dfsRet.isEmpty() && dfsRet.peekLast().size() < temp.size()) {
                dfsRet.clear();
            }
            if (dfsRet.isEmpty() || temp.size() == dfsRet.peekLast().size()) {
                dfsRet.add(new LinkedList<>(temp));
            }
            return;
        }
        temp.addLast(cur);
        dfs(dfsRet, temp, cur.left);
        dfs(dfsRet, temp, cur.right);
        temp.pollLast();
    }


}
