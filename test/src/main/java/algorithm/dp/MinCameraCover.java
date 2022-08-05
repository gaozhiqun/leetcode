package algorithm.dp;

import algorithm.tree.TreeNode;


/**
 * @author zhiqungao@tencent.com
 * @date 2021/10/25 下午5:24
 */
public class MinCameraCover {
    public static void main(String[] args) {

    }

    private int MAX_VALUE = 100_000_000;

    /**
     * leetcode 968 监控2叉树
     *
     * @param root
     * @return
     */
    public int minCameraCover(TreeNode root) {
        return Math.min(dp(root, true, true),
                dp(root, false, false));
    }

    /**
     * a: true,ture,b: true:false, c:false:false
     *
     * @param root
     * @return
     */
    public int minCameraCover2(TreeNode root) {
        int[] array = dp(root);
        return array[1];
    }

    private int[] dp(TreeNode cur) {
        if (cur == null) {
            return new int[]{MAX_VALUE, 0, 0};
        }
        int[] lArray = dp(cur.left);
        int[] rArray = dp(cur.left);
        int[] array = new int[3];
        array[0] = lArray[2] + rArray[2] + 1;
        array[1] = Math.min(array[0], Math.min(lArray[0] + rArray[1], lArray[0] + rArray[0]));
        array[2] = Math.min(array[0], rArray[1] + lArray[1]);
        return array;
    }

    public int dp(TreeNode cur, boolean cover, boolean lightUp) {
        if (cur == null) {
            if (lightUp) {
                return MAX_VALUE;
            } else {
                return 0;
            }
        }
        if (lightUp) {//0
            //1. 点亮并覆盖
            int a = dp(cur.left, true, true);
            int b = dp(cur.left, true, false);
            int c = dp(cur.right, true, true);
            int d = dp(cur.right, true, false);
            return 1 + Math.min(a, b) + Math.min(c, d);
        } else {
            int a = dp(cur.left, true, true);
            int b = dp(cur.left, false, false);
            int c = dp(cur.right, true, true);
            int d = dp(cur.right, false, false);
            if (cover) {
                return Math.min(a, b) + Math.min(c, d);
            } else {
                return Math.min(Math.min(a + c, a + d), b + c);
            }
        }
    }

}
