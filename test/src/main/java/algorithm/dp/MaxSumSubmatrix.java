package algorithm.dp;

/**
 * @author zhiqungao@tencent.com
 * @date 2021/6/30 上午10:52
 */
public class MaxSumSubmatrix {
    public static void main(String[] args) {

    }

    public int maxSumSubmatrix(int[][] matrix, int k) {
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] sum = new int[m][n];
        for (int i = 0; i < m; i++) {
            int rowSum = 0;
            for (int j = 0; j < n; j++) {
                rowSum += matrix[i][j];
                if (i > 0) {
                    sum[i][j] = sum[i - 1][j] + rowSum;
                } else {
                    sum[i][j] = rowSum;
                }
            }
        }
        return -1;
    }
}