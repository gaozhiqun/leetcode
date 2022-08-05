package algorithm;

/**
 * @author zhiqungao@tencent.com
 * @date 2021/3/5 7:33 下午
 */
public class TwoDemensionalSearch {

    private int[][] sumMatrix;

    TwoDemensionalSearch(int[][] matrix) {
        sumMatrix = new int[matrix.length][matrix[0].length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[j].length; j++) {
                if (i == 0 && j == 0) {
                    sumMatrix[i][j] = matrix[i][j];
                } else if (i == 0) {
                    sumMatrix[i][j] = matrix[i][j - 1] + matrix[i][j];
                } else if (j == 0) {
                    sumMatrix[i][j] = matrix[j][i - 1] + matrix[i][j];
                } else {
                    sumMatrix[i][j] = matrix[i][j - 1] + matrix[i][j] + matrix[i - 1][j];
                }
            }
        }
    }

    private int getValue(int i, int j, int k, int m) {
        return 2 * sumMatrix[i][j] + sumMatrix[k][m] - sumMatrix[0][i] - sumMatrix[j][0];
    }
}
