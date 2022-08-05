package algorithm.tree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author zhiqungao@tencent.com
 * @date 2021/9/1 下午2:47
 */
public class PrintTree {
    public static void main(String[] args) {

    }

    public List<List<String>> printTree(TreeNode root) {
        int depth = getDepth(root);
        int length = (int) Math.pow(2, depth) - 1;
        String[][] result = new String[depth][length];
        for (int i = 0; i < depth; i++) {
            Arrays.fill(result[i], "");
        }
        recursiveSet(root, result, depth, 0, length);
        List<List<String>> list = new ArrayList<>();
        for (String[] row : result) {
            list.add(Arrays.asList(row));
        }
        return list;
    }

    private void recursiveSet(TreeNode cur, String[][] result, int depth, int l, int r) {
        int mid = l + (r - l) / 2;
        result[depth][mid] = String.valueOf(cur.val);
        if (cur.left != null) {
            recursiveSet(cur.left, result, depth + 1, l, mid - 1);
        }
        if (cur.right != null) {
            recursiveSet(cur.right, result, depth + 1, mid + 1, r);
        }
    }

    public int getDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return 1 + Math.max(getDepth(root.left), getDepth(root.right));
    }

}
