package algorithm.tree;

/**
 * @author zhiqungao@tencent.com
 * @date 2021/8/27 下午2:04
 */
public class AddOneRow {
    public static void main(String[] args) {

    }

    public TreeNode addOneRow(TreeNode root, int val, int depth) {
        if (depth == 1) {
            TreeNode newNode = new TreeNode(val);
            newNode.left = root;
            return root;
        }
        insert(root, val, depth - 1);
        return root;
    }

    public void insert(TreeNode parent, int val, int depth) {
        if (depth == 1) {
            TreeNode newLNode = new TreeNode(val);
            newLNode.left = parent.left;
            parent.left = newLNode;
            TreeNode newRNode = new TreeNode(val);
            newRNode.right = parent.right;
            parent.right = newRNode;
        }
        if (parent.left != null) {
            insert(parent.left, val, depth - 1);
        }
        if (parent.right != null) {
            insert(parent.right, val, depth - 1);
        }
    }
}
