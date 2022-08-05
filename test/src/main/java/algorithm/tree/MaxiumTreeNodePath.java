package algorithm.tree;

/**
 * @author zhiqungao@tencent.com
 * @date 2021/4/26 3:55 下午
 */
public class MaxiumTreeNodePath {
    public static void main(String[] args) {

    }

    int max = Integer.MIN_VALUE;

    public int maxLength(TreeNode root) {
        maxLength(root);
        return max;

    }

    // 表示子节点到当前节点的最大距离，包括当前节点
    public int helper(TreeNode cur) {
        if (cur == null) {
            return 0;
        }
        int lMax = Math.max(helper(cur.left), 0);
        int rMax = Math.max(helper(cur.right), 0);
        int price = cur.val + lMax + rMax;
        max = Math.max(max, price);
        return cur.val + lMax + rMax;
    }

}
