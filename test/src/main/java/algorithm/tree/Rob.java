package algorithm.tree;

/**
 * @author zhiqungao@tencent.com
 * @date 2021/6/29 下午3:41
 */
public class Rob {
    public static void main(String[] args) {

    }

    public int rob(TreeNode root) {
        return Math.max(dfs(root, true), dfs(root, false));
    }

    public int dfs(TreeNode cur, boolean rob) {
        if (cur == null) {
            return 0;
        }
        if (rob) {
            return cur.val + dfs(cur.left, false) + dfs(cur.right, false);
        } else {
            return Math.max(dfs(cur.left, true), dfs(cur.left, false)) + Math.max(dfs(cur.right, true), dfs(cur.right, false));
        }
    }
}
