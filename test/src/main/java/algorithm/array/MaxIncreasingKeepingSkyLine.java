package algorithm.array;

/**
 * @author zhiqungao@tencent.com
 * @date 2021/9/26 下午4:06
 */
public class MaxIncreasingKeepingSkyLine {

    public static void main(String[] args) {

    }

    public int maxIncreasingKeepingSkyLine(int[][] grid) {
        int result = 0;
        int m = grid.length;
        int n = grid[0].length;
        int[] hor = new int[m];
        int[] ver = new int[n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                hor[i] = Math.max(grid[i][j], hor[i]);
                ver[j] = Math.max(grid[i][j], ver[j]);
            }
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                result += Math.min(hor[i], ver[j]) - grid[i][j];
            }
        }
        return result;
    }
}
