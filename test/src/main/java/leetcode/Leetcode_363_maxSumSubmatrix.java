package leetcode;

import java.util.TreeSet;

/**
 * @author zhiqungao@tencent.com
 * @date 2021/12/6 下午8:18
 */
public class Leetcode_363_maxSumSubmatrix {
    public static void main(String[] args) {

    }


    public int maxSumSubmatrix(int[][] matrix, int k) {
        int ans = Integer.MIN_VALUE;
        int m = matrix.length, n = matrix[0].length;
        for (int i = 0; i < m; ++i) { // 枚举上边界
            int[] sum = new int[n];//sum和
            for (int j = i; j < m; ++j) { // 枚举下边界
                for (int c = 0; c < n; ++c) {
                    sum[c] += matrix[j][c]; // 更新每列的元素和
                }
                TreeSet<Integer> sumSet = new TreeSet<Integer>();
                sumSet.add(0);
                int s = 0;
                for (int v : sum) {
                    s += v;
                    Integer ceil = sumSet.ceiling(s - k);
                    if (ceil != null) {
                        ans = Math.max(ans, s - ceil);
                    }
                    sumSet.add(s);
                }
            }
        }
        return ans;
    }
}
