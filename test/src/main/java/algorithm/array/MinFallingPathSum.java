package algorithm.array;

/**
 * @author zhiqungao@tencent.com
 * @date 2021/10/20 下午3:58
 */
public class MinFallingPathSum {
    public static void main(String[] args) {
        MinFallingPathSum minFallingPathSum = new MinFallingPathSum();
        System.out.println(minFallingPathSum.minFallingPathSum(new int[][]{
                {2, 1, 3}, {6, 5, 4}, {7, 8, 9}
        }));
        System.out.println(minFallingPathSum.minFallingPathSum2(new int[][]{
                {2, 1, 3}, {6, 5, 4}, {7, 8, 9}
        }));
    }

    int[] neighbors = new int[]{-1, 0, 1};

    public int minFallingPathSum2(int[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        for (int i = 1; i < matrix.length; i++) {
            for (int j = 0; j < n; ++j) {
                int min = matrix[i - 1][j];
                if (j - 1 >= 0) {
                    min = Math.min(matrix[i - 1][j - 1], min);
                }
                if (j + 1 < n) {
                    min = Math.min(matrix[i - 1][j + 1], min);
                }
                matrix[i][j] += min;
            }
        }
        int ans = Integer.MAX_VALUE;
        for (int j = 0; j < m; j++) {
            ans = Math.min(ans, matrix[m - 1][j]);
        }
        return ans;
    }

    public int minFallingPathSum(int[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        int ans = Integer.MAX_VALUE;
        for (int j = 0; j < m; j++) {
            ans = Math.min(ans, dfs(0, 0, j, matrix));
        }
        return ans;
    }

    private int dfs(int curSum, int i, int j, int[][] matrix) {
        curSum += matrix[i][j];
        if (i == matrix.length - 1) {
            return curSum;
        }
        int temp = Integer.MAX_VALUE;
        for (int next : neighbors) {
            if (j + next > 0 && j + next < matrix[0].length) {
                temp = Math.min(dfs(curSum, i + 1, j + next, matrix), temp);
            }
        }
        return temp;
    }
}
