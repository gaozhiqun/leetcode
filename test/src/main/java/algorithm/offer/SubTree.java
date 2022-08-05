package algorithm.offer;

import algorithm.tree.TreeNode;

/**
 * @author zhiqungao@tencent.com
 * @date 2021/6/9 2:52 下午
 */
public class SubTree {
    public static void main(String[] args) {

    }

    public boolean isSubStructure(TreeNode a, TreeNode b) {
        if (isSame(a, b)) {
            return true;
        }
        return isSame(a.left, b) || isSame(a.right, b);
    }

    public boolean isSame(TreeNode a, TreeNode b) {
        if (a == null && b == null) {
            return true;
        }
        if (a != null && b != null) {
            return a.val == b.val;
        }
        return false;
    }
}
