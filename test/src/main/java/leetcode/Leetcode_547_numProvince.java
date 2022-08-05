package leetcode;


/**
 * @author zhiqungao@tencent.com
 * @date 2021/12/14 上午10:48
 */
public class Leetcode_547_numProvince {


    public static void main(String[] args) {
        Leetcode_547_numProvince l = new Leetcode_547_numProvince();
        System.out.println(l.findCircleNum(new int[][]{
                {1, 1, 0}, {1, 1, 0}, {0, 0, 1}
        }));
        System.out.println(l.findCircleNum(new int[][]{
                {1, 0, 0}, {0, 1, 0}, {0, 0, 1}
        }));

    }

    public int findCircleNum(int[][] isConnected) {
        int m = isConnected.length;
        int[] parent = new int[m];
        for (int i = 0; i < m; i++) {
            parent[i] = i;
        }
        for (int i = 0; i < m; i++) {
            for (int j = i + 1; j < m; j++) {
                if (isConnected[i][j] == 1) {
                    union(i, j, parent);
                }
            }
        }
        int ans = 0;
        for (int i = 0; i < m; i++) {
            if (parent[i] == i) {
                ++ans;
            }
        }

        return ans;
    }

    private int find(int m, int[] parent) {
        while (parent[m] != m) {
            m = parent[m];
        }
        return m;
    }

    private void union(int m, int n, int[] parent) {
        int p1 = find(m, parent);
        int p2 = find(n, parent);
        parent[p1] = p2;
    }
}