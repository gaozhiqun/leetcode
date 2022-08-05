package algorithm.union;

/**
 * @author zhiqungao@tencent.com
 * @date 2021/10/21 下午5:27
 */
public class RemoveStones {
    public static void main(String[] args) {
        RemoveStones removeStones = new RemoveStones();
        System.out.println(removeStones.removeStones(new int[][]{
                {0, 0}, {0, 2}, {1, 1}, {2, 0}, {2, 2}
        }));
        System.out.println(removeStones.removeStones(new int[][]{
                {0, 0}, {0, 1}, {1, 0},{1,2}, {2, 1}, {2, 2}
        }));
    }

    public int removeStones(int[][] stones) {
        int m = stones.length;
        int[] p = new int[m];
        for (int i = 0; i < m; i++) {
            p[i] = i;
        }
        int ans = 0;
        for (int i = 0; i < m; i++) {
            for (int j = i + 1; j < m; j++) {
                if (stones[i][0] == stones[j][0] || stones[i][1] == stones[j][1]) {
                    union(i, j, p);
                }
            }
        }
        for (int i = 0; i < m; ++i) {
            if (p[i] != i) {
                ++ans;
            }
        }
        return ans;
    }

    private void union(int x, int y, int[] p) {
        int a = find(x, p);
        int b = find(y, p);
        p[b] = a;
    }

    private int find(int x, int[] p) {
        while (x != p[x]) {
            x = p[x];
        }
        return x;
    }
}
