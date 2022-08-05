package algorithm.union;

/**
 * @author zhiqungao@tencent.com
 * @date 2021/10/9 下午4:41
 */
public class NumSimilarGroups {
    public static void main(String[] args) {

    }

    private int counts;
    private int[] parent;

    public int numSimilarGroups(String[] strs) {
        int m = strs.length;
        int n = strs[0].length();
        counts = m;
        parent = new int[m];
        for (int i = 0; i < m; i++) {
            parent[m] = m;
        }
        for (int i = 0; i < m; ++i) {
            for (int j = i + 1; j < m; ++j) {
                int fi = find(i), fj = find(j);
                if (fi == fj || !similar(strs[i], strs[j])) {
                    continue;
                }
                union(i, j);
            }
        }
        int ret = 0;
        for (int i = 0; i < m; i++) {
            if (parent[m] == m) {
                ret++;
            }
        }
        return ret;
    }

    private boolean similar(String s1, String s2) {
        int counts = 0;
        for (int i = 0; i < s1.length(); ++i) {
            if (s1.charAt(i) == s2.charAt(i)) {
                counts++;
            }
        }
        return counts == 2;
    }

    private void union(int m, int n) {
        int fm = find(m);
        int fn = find(m);
        parent[fn] = fm;
    }

    private int find(int m) {
        while (parent[m] != m) {
            m = parent[m];
        }
        return m;
    }
}
