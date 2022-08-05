package leetcode;


import java.util.ArrayList;
import java.util.List;

/**
 * @author zhiqungao@tencent.com
 * @date 2021/11/1 下午7:35
 */
public class Leetcode_54_spiralOrder {

    public static void main(String[] args) {
        Leetcode_54_spiralOrder l = new Leetcode_54_spiralOrder();
        System.out.println(l.spiralOrder(new int[][]{
                {1, 2, 3}, {4, 5, 6}, {7, 8, 9}
        }));

        System.out.println(l.spiralOrder(new int[][]{
                {1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}
        }));

    }


    public List<Integer> spiralOrder(int[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        int b = 0, t = m - 1, l = 0, r = n - 1;
        List<Integer> ans = new ArrayList<>();
        while (b <= t && l <= r) {
            //L->R
            for (int i = l; i <= r; ++i) {
                ans.add(matrix[b][i]);
            }
            for (int i = b + 1; i <= t; ++i) {
                ans.add(matrix[i][r]);
            }
            if (l < r && b < t) {
                for (int i = r - 1; i > l; i--) {
                    ans.add(matrix[t][i]);
                }
                for (int i = t; i > b; i--) {
                    ans.add(matrix[i][l]);
                }
            }
            ++b;
            --r;
            --t;
            ++l;
        }
        return ans;

    }
}
