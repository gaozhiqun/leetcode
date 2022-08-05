package leetcode;

import java.util.Arrays;

/**
 * @author zhiqungao@tencent.com
 * @date 2021/11/17 下午8:25
 */
public class Leetcode_741_cherryPick {

    public static void main(String[] args) {
        Leetcode_741_cherryPick l = new Leetcode_741_cherryPick();
        System.out.println(l.cherryPickup(new int[][]{
                {0, 1, -1}, {1, 0, -1}, {1, 1, 1}
        }));
    }


    /**
     * 0 表示这个格子是空的，所以你可以穿过它。
     * 1 表示这个格子里装着一个樱桃，你可以摘到樱桃然后穿过它。
     * -1 表示这个格子里有荆棘，挡着你的路。
     * 从位置 (0, 0) 出发，最后到达 (N-1, N-1) ，只能向下或向右走，并且只能穿越有效的格子（即只可以穿过值为0或者1的格子）；
     */
    private int[][][] memo;
    private int[][] grid;
    private int N;

    public int cherryPickup(int[][] grid) {
        this.grid = grid;
        N = grid.length;
        memo = new int[N][N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                Arrays.fill(memo[i][j], Integer.MIN_VALUE);
            }
        }
        return Math.max(0, dfs(0, 0, 0));
    }

    public int dfs(int x1, int y1, int x2) {
        int y2 = x1 + y1 - x2;

        if (x1 == N || y2 == N || y1 == N || x2 == N || grid[x1][y1] == -1 || grid[x2][y2] == -1) {
            return -1;
        }
        if (x1 == N - 1 && y1 == N - 1) {
            return grid[x1][y1];
        }

        if (memo[x1][y1][x2] != Integer.MIN_VALUE) {
            return memo[x1][y1][x2];
        }

        int res = Math.max(Math.max(dfs(x1, y1 + 1, x2 + 1), dfs(x1 + 1, y1, x2 + 1)),
                Math.max(dfs(x1, y1 + 1, x2), dfs(x1 + 1, y1, x2)));

        if (res < 0) {
            return memo[x1][y1][x2] = -1;
        }
        res += grid[x1][y1];
        if (x1 != x2) {
            res += grid[x2][y2];
        }
        return memo[x1][y1][x2] = res;
    }


    public int dominantIndex(int[] nums) {
        Arrays.sort(nums);
        int l = nums.length - 1, r = nums.length - 1, ret = 0;
        while (l >= 0) {
            while (l >= 0 && nums[l] * 2 > nums[r]) {
                --l;
            }
            ret += (l + 1);
            --r;
        }
        return ret;
    }



}