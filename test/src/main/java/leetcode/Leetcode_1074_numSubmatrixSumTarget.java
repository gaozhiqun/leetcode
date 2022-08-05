package leetcode;

import javax.swing.plaf.nimbus.AbstractRegionPainter;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author zhiqungao@tencent.com
 * @date 2022/5/9 下午3:04
 */
public class Leetcode_1074_numSubmatrixSumTarget {
    public static void main(String[] args) {
        Leetcode_1074_numSubmatrixSumTarget l = new Leetcode_1074_numSubmatrixSumTarget();
        System.out.println(l.numSubmatrixSumTarget(new int[][]{
                {0, 1, 0}, {1, 1, 1}, {0, 1, 0}
        }, 0));
        System.out.println(l.numSubmatrixSumTarget(new int[][]{
                {1, -1}, {-1, 1}
        }, 0));

    }


    public int numSubmatrixSumTarget(int[][] matrix, int target) {
        int ans = 0;
        int m = matrix.length, n = matrix[0].length;
        for (int i = 0; i < m; ++i) {
            int[] sum = new int[n];
            for (int j = i; j < m; ++j) {
                for (int c = 0; c < n; ++c) {
                    sum[c] += matrix[j][c];
                }
                ans += getSum(sum, target);
            }
        }
        return ans;
    }

    private int getSum(int[] arr, int target) {
        int ret = 0, sum = 0;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        for (int n : arr) {
            sum += n;
            ret += map.getOrDefault(sum - target, 0);
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }
        return ret;
    }


};