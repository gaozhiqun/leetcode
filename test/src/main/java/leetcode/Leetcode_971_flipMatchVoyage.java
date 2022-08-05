package leetcode;

import algorithm.tree.TreeNode;

import java.util.*;

/**
 * @author zhiqungao@tencent.com
 * @date 2022/3/28 下午9:03
 */
public class Leetcode_971_flipMatchVoyage {
    public static void main(String[] args) {
        Leetcode_971_flipMatchVoyage l = new Leetcode_971_flipMatchVoyage();
        TreeNode node0 = new TreeNode(1);
        TreeNode node1 = new TreeNode(2);
        TreeNode node2 = new TreeNode(3);
        node0.left = node1;
        node0.right = node2;
        System.out.println(l.flipMatchVoyage(node0, new int[]{1, 3, 2}));
    }


    /**
     * 先序遍历 与预期的遍历行程 voyage 相匹配 。
     *
     * @return
     */

    public List<Integer> flipMatchVoyage(TreeNode root, int[] voyage) {
        Stack<TreeNode> stack = new Stack<>();
        List<Integer> ret = new ArrayList<>();
        int i = 0;
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode cur = stack.pop();
            if (cur.val != voyage[i]) {
                break;
            }
            if (cur.left != null && cur.right != null && cur.right.val == voyage[i + 1]) {
                stack.push(cur.left);
                stack.push(cur.right);
                ret.add(cur.val);
            } else {
                if (cur.right != null) {
                    stack.push(cur.right);
                }
                if (cur.left != null) {
                    stack.push(cur.left);
                }
            }
            i++;
        }
        return i == voyage.length ? ret : Arrays.asList(-1);
    }


}
