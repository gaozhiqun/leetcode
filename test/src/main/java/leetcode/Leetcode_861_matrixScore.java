package leetcode;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author zhiqungao@tencent.com
 * @date 2022/1/28 下午4:11
 */
public class Leetcode_861_matrixScore {
    public static void main(String[] args) {
        Leetcode_861_matrixScore l = new Leetcode_861_matrixScore();

    }

    public int matrixScore(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int ret = m * (1 << (n - 1));

        for (int j = 1; j < n; j++) {
            int nOnes = 0;
            for (int i = 0; i < m; i++) {
                if (grid[i][0] == 1) {
                    nOnes += grid[i][j];
                } else {
                    nOnes += (1 - grid[i][j]); // 如果这一行进行了行反转，则该元素的实际取值为 1 - grid[i][j]
                }
            }
            int k = Math.max(nOnes, m - nOnes);
            ret += k * (1 << (n - j - 1));
        }
        return ret;
    }
    public int shortestSubarray(int[] nums, int k) {
        int n = nums.length;
        long[] sums = new long[n + 1];
        for (int i = 1; i <= nums.length; ++i) {
            sums[i] = nums[i - 1] + sums[i - 1];
        }
        int ret = nums.length + 1;
        Deque<Integer> monoq = new LinkedList();
        for (int r = 0; r < sums.length; ++r) {
            while (!monoq.isEmpty() && sums[r] <= sums[monoq.getLast()]) {
                monoq.removeLast();
            }
            while (!monoq.isEmpty() && sums[r] >= sums[monoq.getFirst()] + k) {
                ret = Math.min(ret, r - monoq.removeFirst());
            }
            monoq.addLast(r);
        }
        return ret==n+1?-1:ret;
    }

}
