package algorithm.tree;

/**
 * @author zhiqungao@tencent.com
 * @date 2021/9/1 下午7:00
 */
public class TrimBST {
    public static void main(String[] args) {

    }

    public TreeNode trimBST(TreeNode root, int low, int high) {
        if (root == null) {
            return null;
        }
        if (root.val > high) {
            return trimBST(root.left, low, high);
        } else if (root.val < low) {
            return trimBST(root.right, low, high);
        }
        root.left = trimBST(root.left, low, high);
        root.right = trimBST(root.right, low, high);
        return root;
    }
}
