package algorithm.search.binary;

/**
 * @author zhiqungao@tencent.com
 * @date 2021/7/1 下午7:10
 */
public class KthSmallest {
    public static void main(String[] args) {

    }

    public int kthSmallest(int[][] matrix, int k) {
        int m = matrix.length;
        int l = matrix[0][0];
        int r = matrix[m - 1][m - 1];
        while (l < r) {
            int mid = r - (l + r) / 2;
            if (count(matrix, mid) < k) {
                l = mid + 1;
            } else {
                r = mid;
            }
        }
        return r;
    }

    private int count(int[][] matrix, int cur) {
        int count = 0;
        int i = matrix.length - 1, j = 0;
        while (i >= 0 && j < matrix.length) {
            while (i >= 0 && matrix[i][j] > cur) {
                i--;
            }
            if (i > -1) {
                count += i + 1;
            }
            j++;
        }
        return count;
    }
}
