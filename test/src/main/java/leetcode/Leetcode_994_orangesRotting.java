package leetcode;

import algorithm.tree.TreeNode;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/**
 * @author zhiqungao@tencent.com
 * @date 2022/3/16 下午3:17
 */
public class Leetcode_994_orangesRotting {
    public static void main(String[] args) {
        Leetcode_994_orangesRotting l = new Leetcode_994_orangesRotting();
        System.out.println(l.orangesRotting(new int[][]{
                {2, 1, 1}, {1, 1, 0}, {0, 1, 1}
        }));
    }

    public int orangesRotting(int[][] grid) {
        int M = grid.length, N = grid[0].length;
        int K = 0;
        int[] dir1 = new int[]{-1, 0, 1, 0};
        int[] dir2 = new int[]{0, 1, 0, -1};
        Queue<int[]> roits = new LinkedList<>();
        for (int i = 0; i < M; ++i) {
            for (int j = 0; j < N; ++j) {
                if (grid[i][j] == 2) {
                    roits.offer(new int[]{i, j});
                } else if (grid[i][j] == 1) {
                    ++K;
                }
            }
        }
        int ret = 0;
        while (!roits.isEmpty()) {
            int size = roits.size();
            Set<int[]> nbs = new HashSet<>();
            for (int i = 0; i < size; ++i) {
                int[] cur = roits.poll();
                for (int j = 0; j < 4; ++j) {
                    int ni = cur[0] + dir1[j], nj = cur[1] + dir2[j];
                    if (ni >= 0 && nj >= 0 && ni < M && nj < N && grid[ni][nj] == 1) {
                        grid[ni][nj] = 2;
                        nbs.add(new int[]{ni, nj});
                    }
                }
            }
            roits.addAll(nbs);
            K -= roits.size();
            ++ret;
        }
        return K == 0 ? ret - 1 : -1;
    }


    public boolean isCousins(TreeNode root, int x, int y) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        boolean foundX = false, foundY = false;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; ++i) {
                TreeNode cur = queue.poll();
                if (x == cur.val) {
                    foundX = true;
                }
                if (y == cur.val) {
                    foundY = true;
                }
                if (cur.left != null && cur.right != null
                        && (cur.left.val == x && cur.right.val == y
                        || cur.right.val == x && cur.left.val == y)) {
                    return false;
                } else {
                    if (cur.left != null) {
                        queue.offer(cur.left);
                    }
                    if (cur.right != null) {
                        queue.offer(cur.right);
                    }
                }
            }
            if (foundX && foundY) {
                return true;
            } else if (foundX || foundY) {
                return false;
            }
        }
        return false;

    }


}
