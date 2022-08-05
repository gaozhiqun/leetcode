package leetcode;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author zhiqungao@tencent.com
 * @date 2021/11/1 下午7:35
 */
public class Leetcode_55_generateMatrix {

    public static void main(String[] args) {
        Leetcode_55_generateMatrix l = new Leetcode_55_generateMatrix();
        int [][] matrix = l.generateMatrix(4);
        for (int [] i: matrix){
            System.out.println(Arrays.asList(i));
        }
    }


    public int[][] generateMatrix(int N) {
        int m = N, n = N;
        int[][] matrix = new int[m][n];
        int counter = 1;
        int b = 0, t = m - 1, l = 0, r = n - 1;
        while (b <= t && l <= r) {
            //L->R
            for (int i = l; i <= r; ++i) {
                matrix[b][i] = counter++;
            }
            for (int i = b + 1; i <= t; ++i) {
                matrix[i][r] = counter++;
            }
            if (l < r && b < t) {
                for (int i = r - 1; i > l; i--) {
                    matrix[t][i] = counter++;
                }
                for (int i = t; i > b; i--) {
                    matrix[i][l] = counter++;
                }
            }
            ++b;
            --r;
            --t;
            ++l;
        }
        return matrix;

    }
}
