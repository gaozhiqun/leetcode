package leetcode;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.TreeMap;

/**
 * @author zhiqungao@tencent.com
 * @date 2021/11/17 下午7:07
 */
public class Leetcode_240_searchMatrix {
    public static void main(String[] args) {
        Leetcode_240_searchMatrix l = new Leetcode_240_searchMatrix();
    }

    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length, n = matrix[0].length, i = 0, j = n - 1;
        while (i < m && j >= 0) {
            if (matrix[i][j] == target) {
                return true;
            } else if (matrix[i][j] > target) {
                --j;
            } else {
                ++i;
            }
        }
        return false;
    }


}
