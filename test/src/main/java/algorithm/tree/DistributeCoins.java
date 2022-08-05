package algorithm.tree;

/**
 * @author zhiqungao@tencent.com
 * @date 2021/10/26 下午2:03
 */
public class DistributeCoins {
    public static void main(String[] args) {

    }

    int ans;

    public int distributeCoins(TreeNode root) {
        ans = 0;
        getCount(root);
        return ans;
    }

    /**
     * 让cur及所有子节点都为1时，需要的额外数
     */
    public int getCount(TreeNode cur) {
        if (cur == null) {
            return 0;
        }
        int lCnt = getCount(cur.left);
        int rCnt = getCount(cur.right);
        ans += Math.abs(lCnt) + Math.abs(rCnt);
        return cur.val + lCnt + rCnt - 1;
    }
}
