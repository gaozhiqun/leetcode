package leetcode;


import java.util.HashSet;
import java.util.Set;

/**
 * @author zhiqungao@tencent.com
 * @date 2021/11/17 下午8:25
 */
public class Leetcode_827_largestIsland {

    public static void main(String[] args) {
        Leetcode_827_largestIsland l = new Leetcode_827_largestIsland();
//        System.out.println(l.largestIsland(new int[][]{{1, 0}, {0, 1}}));
//        System.out.println(l.largestIsland(new int[][]{{1, 1}, {1, 1}}));
        System.out.println(l.largestIsland(new int[][]{{1, 1}, {1, 0}}));
    }

    int M, N;

    public static int[] DIRS = new int[]{-1, 0, 1, 0, -1};

    public int largestIsland(int[][] grid) {
        M = grid.length;
        N = grid[0].length;
        int size = M * N;
        UnionFind unionFind = new UnionFind(size + 1);
        int ret = 0;
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                if (grid[i][j] == 1) {
                    if (inArea(i + 1, j) && grid[i + 1][j] == 1) {
                        int cur = unionFind.union(getIndex(i, j), getIndex(i + 1, j));
                        ret = Math.max(ret, cur);
                    }
                    if (inArea(i, j + 1) && grid[i][j + 1] == 1) {
                        int cur = unionFind.union(getIndex(i, j), getIndex(i, j + 1));
                        ret = Math.max(ret, cur);
                    }
                }
            }
        }


        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                if (grid[i][j] == 0) {
                    for (int d1 = 0; d1 < 4; ++d1) {
                        int ni1 = i + DIRS[d1], nj1 = j + DIRS[d1 + 1];
                        if (inArea(ni1, nj1) && grid[ni1][nj1] == 1) {
                            ret = Math.max(ret, unionFind.sizeTotal[unionFind.find(getIndex(ni1, nj1))] + 1);
                            for (int d2 = d1 + 1; d2 < 4; ++d2) {
                                int ni2 = i + DIRS[d2], nj2 = j + DIRS[d2 + 1];
                                if (inArea(ni2, nj2) && grid[ni2][nj2] == 1 && unionFind.find(getIndex(ni1, nj1)) != unionFind.find(getIndex(ni2, nj2))) {
                                    ret = Math.max(ret, unionFind.sizeTotal[unionFind.find(getIndex(ni1, nj1))] + unionFind.sizeTotal[unionFind.find(getIndex(ni2, nj2))] + 1);
                                }
                            }
                        }

                    }
                }
            }
        }
        return ret;
    }

    private int getIndex(int i, int j) {
        return i * M + j;
    }

    private boolean inArea(int i, int j) {
        return i >= 0 && j >= 0 && i < M && j < N;
    }


    public static class UnionFind {
        private int n;
        private int[] parent;
        private int[] sizeTotal;

        public UnionFind(int n) {
            this.n = n;
            parent = new int[n];
            sizeTotal = new int[n];
            for (int i = 0; i < n; ++i) {
                parent[i] = i;
                sizeTotal[i] = 1;
            }
        }

        public int find(int x) {
            while (x != parent[x]) {
                x = parent[x];
            }
            return x;
        }

        private int union(int x, int y) {
            int p1 = find(x);
            int p2 = find(y);
            if (p1 != p2) {
                parent[p2] = p1;
                sizeTotal[p1] += sizeTotal[p2];
            }
            return sizeTotal[p1];
        }
    }
}