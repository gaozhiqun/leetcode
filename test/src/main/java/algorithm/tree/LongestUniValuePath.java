package algorithm.tree;

/**
 * @author zhiqungao@tencent.com
 * @date 2021/9/2 下午6:54
 */
public class LongestUniValuePath {
    public static void main(String[] args) {
        LongestUniValuePath longestUniValuePath = new LongestUniValuePath();
        TreeNode node1 = new TreeNode(5);
        TreeNode node2 = new TreeNode(4);
        TreeNode node3 = new TreeNode(5);
        TreeNode node4 = new TreeNode(1);
        TreeNode node5 = new TreeNode(1);
        TreeNode node6 = new TreeNode(5);
        node1.left = node2;
        node1.right = node3;
        node2.left = node4;
        node2.right = node5;
        node3.right = node6;
        System.out.println(longestUniValuePath.longestUniValuePath(node1));
    }

    public int longestUniValuePath(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int result = 1;
        int l = longestUniValuePath(root.left);
        int r = longestUniValuePath(root.right);
        if (root.left != null && root.left.val == root.val) {
            result += l + 1;
        }
        if (root.right != null && root.right.val == root.val) {
            result += r + 1;
        }
        return Math.max(Math.max(result, l), r);
    }
}
