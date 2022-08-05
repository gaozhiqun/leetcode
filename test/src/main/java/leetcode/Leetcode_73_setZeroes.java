package leetcode;


/**
 * @author zhiqungao@tencent.com
 * @date 2021/11/1 下午7:35
 */
public class Leetcode_73_setZeroes {

    public static void main(String[] args) {
        Leetcode_73_setZeroes l = new Leetcode_73_setZeroes();

    }

    public void setZeroes(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        boolean[] rSet = new boolean[m];
        boolean[] cSet = new boolean[n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; ++j) {
                if (matrix[i][j] == 0) {
                    rSet[i] = true;
                    cSet[j] = true;
                }
            }
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; ++j) {
                if (rSet[i] || cSet[j]) {
                    matrix[i][j] = 0;
                }
            }
        }
    }

}
