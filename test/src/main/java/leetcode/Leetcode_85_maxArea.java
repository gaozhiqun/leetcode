package leetcode;


import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

/**
 * @author zhiqungao@tencent.com
 * @date 2021/11/1 下午7:35
 */
public class Leetcode_85_maxArea {

    public static void main(String[] args) {
        Leetcode_85_maxArea l = new Leetcode_85_maxArea();
        System.out.println(l.maximalRectangle(new char[][]{
                {'1', '0', '1', '0', '0'}, {'1', '0', '1', '1', '1'}, {'1', '1', '1', '1', '1'}, {'1', '0', '0', '1', '0'}
        }));
    }

    public int maximalRectangle(char[][] matrix) {
        int m = matrix.length;
        if (m == 0) {
            return 0;
        }
        int n = matrix[0].length;
        int[][] height = new int[m][n];
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                if (matrix[i][j] == '1') {
                    height[i][j] = 1;
                    if (i > 0) {
                        height[i][j] += height[i - 1][j];
                    }
                }
            }
        }
        int ans = 0;
        for (int i = 0; i < m; ++i) {
            ans = Math.max(ans, calculate(height[i]));
        }
        return ans;
    }

    private int calculate(int[] row) {
        int[] l = new int[row.length], r = new int[row.length];
        Arrays.fill(r, row.length);
        Arrays.fill(l, -1);
        Deque<Integer> incrStack = new ArrayDeque<Integer>();
        for (int i = 0; i < row.length; ++i) {
            while (!incrStack.isEmpty() && row[incrStack.peek()] > row[i]) {
                r[incrStack.pop()] = i;
            }
            l[i] = (incrStack.isEmpty() ? -1 : incrStack.peek());
            incrStack.push(i);
        }
        int ans = 0;
        for (int i = 0; i < row.length; ++i) {
            ans = Math.max(ans, (r[i] - l[i] - 1) * row[i]);
        }
        return ans;
    }
}
