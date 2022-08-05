package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zhiqungao@tencent.com
 * @date 2021/11/17 下午8:25
 */
public class Leetcode_803_hitBricks {

    public static void main(String[] args) {
        Leetcode_803_hitBricks l = new Leetcode_803_hitBricks();
    }

    int M, N;
    public static final int[][] DIRECTIONS = {{0, 1}, {1, 0}, {-1, 0}, {0, -1}};

    public int[] hitBricks(int[][] grid, int[][] hits) {
        this.M = grid.length;
        this.N = grid[0].length;
        int[][] copy = new int[M][N];
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                copy[i][j] = grid[i][j];
            }
        }
        for (int[] hit : hits) {
            copy[hit[0]][hit[1]] = 0;
        }
        int size = M * N;
        UnionFind unionFind = new UnionFind(size);
        for (int j = 0; j < N; j++) {
            if (copy[0][j] == 1) {
                unionFind.union(j, size);
            }
        }
        for (int i = 1; i < M; i++) {
            for (int j = 0; j < N; j++) {
                if (copy[i][j] == 1) {
                    // 如果上方也是砖块
                    if (copy[i - 1][j] == 1) {
                        unionFind.union(getNumber(i - 1, j), getNumber(i, j));
                    }
                    // 如果左边也是砖块
                    if (j > 0 && copy[i][j - 1] == 1) {
                        unionFind.union(getNumber(i, j - 1), getNumber(i, j));
                    }
                }
            }
        }
        int hitsLen = hits.length;
        int[] res = new int[hitsLen];
        for (int i = hitsLen - 1; i >= 0; i--) {
            int x = hits[i][0];
            int y = hits[i][1];
            if (grid[x][y] == 0) {
                continue;
            }
            int origin = unionFind.getSize(size);
            if (x == 0) {
                unionFind.union(y, size);
            }
            for (int[] direction : DIRECTIONS) {
                int newX = x + direction[0];
                int newY = y + direction[1];

                if (inArea(newX, newY) && copy[newX][newY] == 1) {
                    unionFind.union(getNumber(x, y), getNumber(newX, newY));
                }
            }
            int current = unionFind.getSize(size);
            res[i] = Math.max(0, current - origin - 1);
            copy[x][y] = 1;
        }
        return res;
    }

    public boolean inArea(int i, int j) {
        return i >= 0 && j >= 0 && i < M && j < N;
    }

    public int getNumber(int i, int j) {
        return i * M + j;
    }

    public int[] getPoint(int k) {
        return new int[]{k / M, k - (k / M) * M};
    }

    private class UnionFind {

        /**
         * 当前结点的父亲结点
         */
        private int[] parent;
        /**
         * 以当前结点为根结点的子树的结点总数
         */
        private int[] size;

        public UnionFind(int n) {
            parent = new int[n];
            size = new int[n];
            for (int i = 0; i < n; i++) {
                parent[i] = i;
                size[i] = 1;
            }
        }

        /**
         * 路径压缩，只要求每个不相交集合的「根结点」的子树包含的结点总数数值正确即可，因此在路径压缩的过程中不用维护数组 size
         *
         * @param x
         * @return
         */
        public int find(int x) {
            if (x != parent[x]) {
                parent[x] = find(parent[x]);
            }
            return parent[x];
        }

        public void union(int x, int y) {
            int rootX = find(x);
            int rootY = find(y);

            if (rootX == rootY) {
                return;
            }
            parent[rootX] = rootY;
            // 在合并的时候维护数组 size
            size[rootY] += size[rootX];
        }

        /**
         * @param x
         * @return x 在并查集的根结点的子树包含的结点总数
         */
        public int getSize(int x) {
            int root = find(x);
            return size[root];
        }
    }


}