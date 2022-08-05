package leetcode;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * @author zhiqungao@tencent.com
 * @date 2022/3/24 下午4:39
 */
public class Leetcode_947_removeStones {
    public static void main(String[] args) {
        Leetcode_947_removeStones l = new Leetcode_947_removeStones();
        System.out.println(l.removeStones(new int[][]{
                {0, 0}, {0, 1}, {1, 0}, {1, 2}, {2, 1}, {2, 2}
        }));
        System.out.println(l.removeStones(new int[][]{
                {0, 0}, {0, 2}, {1, 1}, {2, 0}, {2, 2}
        }));
    }


    public int removeStones(int[][] stones) {
        int N = stones.length;
        int[] parent = new int[N];
        for (int i = 0; i < N; ++i) {
            parent[i] = i;
        }
        for (int i = 0; i < N; ++i) {
            for (int j = i + 1; j < N; ++j) {
                if (stones[i][0] == stones[j][0] || stones[i][1] == stones[j][1]) {
                    union(parent, i, j);
                }
            }
        }
        return getCnt(parent);

    }

    private int find(int[] parent, int x) {
        while (parent[x] != x) {
            x = parent[x];
        }
        return x;
    }

    private void union(int[] parent, int x, int y) {
        int p1 = find(parent, x);
        int p2 = find(parent, y);
        parent[p2] = p1;
    }

    private int getCnt(int[] parent) {
        int ret = 0;
        for (int i = 0; i < parent.length; ++i) {
            if (i != parent[i]) {
                ++ret;
            }
        }
        return ret;
    }


}
