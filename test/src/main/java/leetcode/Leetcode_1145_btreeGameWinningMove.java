package leetcode;

import algorithm.tree.TreeNode;

/**
 * @author zhiqungao@tencent.com
 * @date 2022/6/27 下午9:50
 */
public class Leetcode_1145_btreeGameWinningMove {


    boolean ret;
    int x, n;

    public boolean btreeGameWinningMove(TreeNode root, int n, int x) {
        ret = false;
        this.x = x;
        this.n = n;
        int total = getCnt(root);
        return ret;
    }

    private int getCnt(TreeNode cur) {
        if (cur == null) {
            return 0;
        }
        int lCnt = getCnt(cur.left);
        int rCnt = getCnt(cur.right);
        int total = lCnt + rCnt + 1;
        if (cur.val == x) {
            if ((lCnt > n / 2 || rCnt > n / 2 || total <= n / 2)) {
                ret = true;
            }
        }
        return total;
    }

}
