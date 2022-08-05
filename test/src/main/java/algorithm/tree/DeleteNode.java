package algorithm.tree;

/**
 * @author zhiqungao@tencent.com
 * @date 2021/7/6 下午7:31
 */
public class DeleteNode {
    public static void main(String[] args) {

    }

    public TreeNode deleteNode(TreeNode root, int key) {
        if (root.val > key) {
            deleteNode(root.left, key);
        } else if (root.val < key) {
            deleteNode(root.right, key);
        }
        TreeNode parent = null;
        TreeNode cur = root;
        while (cur.left != null || cur.right != null) {
            if (cur.left != null) {
                cur.val = cur.left.val;
                cur = cur.left;
            } else {
                cur.val = cur.right.val;
                cur = cur.right;
            }
        }
        return cur;
    }
}
