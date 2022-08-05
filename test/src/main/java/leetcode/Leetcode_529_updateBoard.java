package leetcode;


import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

/**
 * @author zhiqungao@tencent.com
 * @date 2021/12/14 上午10:48
 */
public class Leetcode_529_updateBoard {


    public static void main(String[] args) {
        Leetcode_529_updateBoard l = new Leetcode_529_updateBoard();
    }


    int[] dirX = {0, 1, 0, -1, 1, 1, -1, -1};
    int[] dirY = {1, 0, -1, 0, 1, -1, 1, -1};

    public char[][] updateBoard(char[][] board, int[] click) {
        int x = click[0], y = click[1];
        if (board[x][y] == 'M') {
            // 规则 1
            board[x][y] = 'X';
        } else {
            bfs(board, x, y);
        }
        return board;
    }

    public void bfs(char[][] board, int sx, int sy) {
        Queue<int[]> queue = new LinkedList<int[]>();
        boolean[][] vis = new boolean[board.length][board[0].length];
        queue.offer(new int[]{sx, sy});
        vis[sx][sy] = true;
        while (!queue.isEmpty()) {
            int[] pos = queue.poll();
            int cnt = 0, x = pos[0], y = pos[1];
            for (int i = 0; i < 8; ++i) {
                int tx = x + dirX[i];
                int ty = y + dirY[i];
                if (tx < 0 || tx >= board.length || ty < 0 || ty >= board[0].length) {
                    continue;
                }
                // 不用判断 M，因为如果有 M 的话游戏已经结束了
                if (board[tx][ty] == 'M') {
                    ++cnt;
                }
            }
            if (cnt > 0) {
                // 规则 3
                board[x][y] = (char) (cnt + '0');
            } else {
                // 规则 2
                board[x][y] = 'B';
                for (int i = 0; i < 8; ++i) {
                    int tx = x + dirX[i];
                    int ty = y + dirY[i];
                    // 这里不需要在存在 B 的时候继续扩展，因为 B 之前被点击的时候已经被扩展过了
                    if (tx < 0 || tx >= board.length || ty < 0 || ty >= board[0].length || board[tx][ty] != 'E' || vis[tx][ty]) {
                        continue;
                    }
                    queue.offer(new int[]{tx, ty});
                    vis[tx][ty] = true;
                }
            }
        }
    }

    public int findPairs(int[] nums, int k) {
        Map<Integer, Integer> cnts = new HashMap<>();
        for (int i : nums) {
            cnts.put(i, cnts.computeIfAbsent(i, f -> 0) + 1);
        }
        int ans = 0;

        for (int m : cnts.keySet()) {
            int n = cnts.getOrDefault(m + k, 0);
            if (k == 0) {
                if (n > 1) {
                    ++ans;
                }
            } else if (n > 0) {
                ++ans;
            }
        }
        return ans;

    }

}