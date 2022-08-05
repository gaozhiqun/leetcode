package algorithm.tree;

/**
 * @author zhiqungao@tencent.com
 * @date 2021/10/27 下午8:22
 */
public class SmallestFromLeaf {
    public static void main(String[] args) {

    }

    String ans = null;

    public String smallestFromLeaf(TreeNode root) {
        dfs("", root);
        return ans;
    }

    private void dfs(String s, TreeNode cur) {
        if (cur == null) {
            if (ans == null) {
                ans = s;
            }
            if (ans.compareTo(s) > 0) {
                ans = s;
            }
            return;
        }
        s = (char) (cur.val + 'a') + s;
        dfs(s, cur.left);
        dfs(s, cur.right);
    }
}
