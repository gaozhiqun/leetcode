package algorithm.union;

/**
 * @author zhiqungao@tencent.com
 * @date 2021/8/26 下午2:01
 */
public class FindCircleNum {
    public static void main(String[] args) {
        FindCircleNum findCircleNum = new FindCircleNum();
        System.out.println(findCircleNum.findCircleNum(new int[][]{
                {1, 1, 0}, {1, 1, 0}, {0, 0, 1}
        }));
    }

    public int findCircleNum(int[][] isConnected) {
        int m = isConnected.length;
        int[] union = new int[m];
        for (int i = 0; i < m; ++i) {
            union[i] = i;
        }
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < m; ++j) {
                if (isConnected[i][j] == 1) {
                    union(union, i, j);
                }
            }
        }
        int ret = 0;
        for (int i = 0; i < m; ++i) {
            if (union[i] == i) {
                ++ret;
            }
        }
        return ret;
    }

    private void union(int[] union, int p, int q) {
        union[find(union, p)] = find(union, q);
    }

    private int find(int[] union, int p) {
        if (union[p] != p) {
            union[p] = find(union, union[p]);
        }
        return union[p];
    }
}
