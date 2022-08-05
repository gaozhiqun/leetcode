package algorithm.tree;

/**
 * @author zhiqungao@tencent.com
 * @date 2021/10/13 下午5:12
 */
public class SubtreeWithAllDepest {
    public static void main(String[] args) {

    }

    TreeNode result = null;
    int maxDepth = 0;

    public TreeNode subTreeWithAllDeepest(TreeNode root) {
        getDepth(root);
        return result;
    }

    private int getDepth(TreeNode cur) {
        if (cur == null) {
            return 0;
        }
        int depthL = getDepth(cur.left);
        int depthR = getDepth(cur.right);
        if (depthL == depthR && depthL > maxDepth) {
            result = cur;
        }
        return Math.max(depthL, depthR) + 1;
    }
}
