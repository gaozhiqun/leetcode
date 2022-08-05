package algorithm.array;

/**
 * @author zhiqungao@tencent.com
 * @date 2021/3/16 2:36 下午
 */
public class RotatingMatrix {

    public static void main(String[] args) {
        RotatingMatrix rotatingMatrix = new RotatingMatrix();
        // System.out.println(rotatingMatrix.spiralMatrix3(1, 4, 0, 0));
        System.out.println(rotatingMatrix.spiralMatrix3(5, 6, 1, 4));

    }

    public int[][] spiralMatrix3(int rows, int cols, int rStart, int cStart) {
        int[][] result = new int[rows * cols][2];
        result[0] = new int[]{rStart, cStart};
        int k = 1, t = 1, rCur = rStart, cCur = cStart;
        int[][][] dirs = new int[][][]{{{0, 1}, {1, 0}}, {{0, -1}, {-1, 0}}};
        while (t < result.length) {
            //right
            //down
            for (int[][] subDir : dirs) {
                for (int[] dir : subDir) {
                    for (int i = 0; i < k; i++) {
                        rCur += dir[0];
                        cCur += dir[1];
                        if (rCur >= 0 && rCur < rows && cCur >= 0 && cCur < cols) {
                            result[t++] = new int[]{rCur, cCur};
                        }
                        if (t == result.length) {
                            return result;
                        }
                    }
                }
                k++;
            }
        }
        return result;
    }


}
