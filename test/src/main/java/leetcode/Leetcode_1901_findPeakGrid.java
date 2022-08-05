package leetcode;

/**
 * @author zhiqungao@tencent.com
 * @date 2022/6/28 上午11:38
 */
public class Leetcode_1901_findPeakGrid {
    /**
     * 每一行的最大值，其中一定存在一个最大值是峰值
     * @param mat
     * @return
     */
    public int[] findPeakGrid(int[][] mat) {
        int m = mat.length;
        int low = 0, high = m - 1, maxIndex = 0;
        while (low < high) {
            int mid = (high + low) / 2;
            maxIndex = getMaxIndex(mat[mid]);
            if (mat[mid][maxIndex] > mat[mid + 1][maxIndex]) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }
        return new int[]{low, getMaxIndex(mat[low])};
    }

    private int getMaxIndex(int[] row) {
        int idx = 0, max = row[0];
        for (int i = 1; i < row.length; ++i) {
            if (row[i] > max) {
                max = row[i];
                idx = i;
            }
        }
        return idx;
    }
}
