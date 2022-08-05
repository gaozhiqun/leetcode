package leetcode;

import algorithm.tree.TreeNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

/**
 * @author zhiqungao@tencent.com
 * @date 2022/3/28 下午9:03
 */
public class Leetcode_973_kClosest {
    public static void main(String[] args) {
        Leetcode_973_kClosest l = new Leetcode_973_kClosest();
    }


    /**
     * 先序遍历 与预期的遍历行程 voyage 相匹配 。
     *
     * @return
     */

    public int[][] kClosest(int[][] points, int k) {
        int[][] ret = new int[k][2];
        Arrays.sort(points, (a, b) -> {
            return a[1] * a[1] - b[1] * b[1] + a[0] * a[0] - b[0] * b[0];
        });
        System.arraycopy(points, 0, ret, 0, k);
        return ret;
    }


}
