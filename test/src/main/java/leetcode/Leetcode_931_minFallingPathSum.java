package leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author zhiqungao@tencent.com
 * @date 2022/3/23 下午4:14
 */
public class Leetcode_931_minFallingPathSum {
    public static void main(String[] args) {
        Leetcode_931_minFallingPathSum l = new Leetcode_931_minFallingPathSum();
    }

    public int minFallingPathSum(int[][] matrix) {
        int M = matrix.length;
        if (M == 0) {
            return 0;
        }
        int N = matrix[0].length;
        for (int i = 1; i < M; ++i) {
            for (int j = 0; j < N; ++j) {
                int min = matrix[i - 1][j];
                if (j > 0) {
                    min = Math.min(min, matrix[i - 1][j - 1]);
                }
                if (j < N - 1) {
                    min = Math.min(min, matrix[i - 1][j + 1]);
                }
                matrix[i][j] += min;
            }
        }
        return Arrays.stream(matrix[M - 1]).min().getAsInt();
    }
}
