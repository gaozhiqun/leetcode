package leetcode;

/**
 * @author zhiqungao@tencent.com
 * @date 2021/11/17 下午8:25
 */
public class Leetcode_304_NumMatrix {

    public static class NumMatrix {
        int[][] sums;
        int[][] matrix;
        int m, n;

        public NumMatrix(int[][] matrix) {
            this.m = matrix.length;
            this.n = matrix[0].length;
            this.matrix = matrix;
            this.sums = new int[m][n];
            for (int i = 0; i < m; ++i) {
                for (int j = 0; j < n; ++j) {
                    if (j == 0) {
                        sums[i][j] = matrix[i][j];
                    } else {
                        sums[i][j] = sums[i][j - 1] + matrix[i][j];
                    }
                }
            }
            for (int j = 0; j < n; ++j) {
                for (int i = 1; i < m; ++i) {
                    sums[i][j] += sums[i - 1][j];
                }
            }

        }

        public int sumRegion(int row1, int col1, int row2, int col2) {
            return sums[row2][col2]
                    + sums[row1][col1]
                    - (row1 > 0 ? sums[row1 - 1][col2] : 0)
                    - (col1 > 0 ? sums[row2][col1 - 1] : 0);
        }
    }


}
