package leetcode;


/**
 * @author zhiqungao@tencent.com
 * @date 2021/11/1 下午7:35
 */
public class Leetcode_74_searchMatrix {

    public static void main(String[] args) {
        Leetcode_74_searchMatrix l = new Leetcode_74_searchMatrix();
        System.out.println(l.searchMatrix(new int[][]{
                {1}
        }, 0));
        System.out.println(l.searchMatrix(new int[][]{
                {1, 3, 5, 7}, {10, 11, 16, 20}, {23, 30, 34, 60}
        }, 3));

    }

    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;
        int[] firsts = new int[m];
        for (int i = 0; i < m; ++i) {
            firsts[i] = matrix[i][0];
        }
        int r = findLessThan(firsts, target);
        if (r < 0) {
            return false;
        }
        int i = findLessThan(matrix[r], target);
        if (i < 0) {
            return false;
        }
        return matrix[r][i] == target;
    }

    public int findLessThan(int[] array, int target) {
        int l = 0, r = array.length - 1;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (array[mid] > target) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return r;
    }
}
