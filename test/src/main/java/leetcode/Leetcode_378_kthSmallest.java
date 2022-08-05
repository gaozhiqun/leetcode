package leetcode;

import java.util.SortedMap;

/**
 * @author zhiqungao@tencent.com
 * @date 2021/12/6 下午8:18
 */
public class Leetcode_378_kthSmallest {
    public static void main(String[] args) {
        Leetcode_378_kthSmallest l = new Leetcode_378_kthSmallest();
        System.out.println(l.kthSmallest(new int[][]{
                {1, 5, 9}, {10, 11, 13}, {12, 13, 15}
        }, 8));
        System.out.println(l.kthSmallest(new int[][]{
                {-5}
        }, 1));

    }


    public int kthSmallest(int[][] matrix, int k) {
        int m = matrix.length;
        int n = matrix[0].length;
        int l = matrix[0][0];
        int r = matrix[m - 1][n - 1];
        while (l < r) {
            int target = l + (r - l) / 2;
            int cnts = getCnts(matrix, target);
            if (cnts >= k) {
                r = target;
            } else {
                l = target + 1;
            }
        }
        return l;
    }

    private int getCnts(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;
        int cnts = 0;
        for (int i = 0, j = n - 1; i < m && j >= 0; i++) {
            while (j >= 0 && matrix[i][j] > target) {
                --j;
            }
            cnts += j + 1;
        }
        return cnts;
    }

}
