package leetcode;

/**
 * @author zhiqungao@tencent.com
 * @date 2021/11/17 下午8:25
 */
public class Leetcode_808_soupDivide {

    public static void main(String[] args) {
        Leetcode_808_soupDivide l = new Leetcode_808_soupDivide();
        System.out.println(l.expressiveWords("heeellooo", new String[]{"hello", "hi", "helo"}));
    }

    /*
         有 A 和 B 两种类型的汤。一开始每种类型的汤有 N 毫升。有四种分配操作：

        提供 100ml 的汤A 和 0ml 的汤B。
        提供 75ml 的汤A 和 25ml 的汤B。
        提供 50ml 的汤A 和 50ml 的汤B。
        提供 25ml 的汤A 和 75ml 的汤B。
        当我们把汤分配给某人之后，汤就没有了。每个回合，我们将从四种概率同为0.25的操作中进行分配选择。如果汤的剩余量不足以完成某次操作，我们将尽可能分配。当两种类型的汤都分配完时，停止操作。

        注意不存在先分配100 ml汤B的操作。

        需要返回的值： 汤A先分配完的概率 + 汤A和汤B同时分配完的概率 / 2。
     */


    public double soupServings(int N) {
        N = N / 25 + (N % 25 > 0 ? 1 : 0);
        if (N >= 500) {
            return 1.0;
        }

        double[][] memo = new double[N + 1][N + 1];
        for (int s = 0; s <= 2 * N; ++s) {
            for (int i = 0; i <= N; ++i) {
                int j = s - i;
                if (j < 0 || j > N) continue;
                double ans = 0.0;
                if (i == 0) ans = 1.0;
                if (i == 0 && j == 0) ans = 0.5;
                if (i > 0 && j > 0) {
                    ans = 0.25 * (memo[M(i - 4)][j] + memo[M(i - 3)][M(j - 1)] +
                            memo[M(i - 2)][M(j - 2)] + memo[M(i - 1)][M(j - 3)]);
                }
                memo[i][j] = ans;

            }
        }
        return memo[N][N];
    }

    public int M(int x) {
        return Math.max(0, x);
    }


    public int expressiveWords(String s, String[] words) {
        int ret = 0;
        for (String l : words) {
            if (canExpend(l, s)) {
                ++ret;
            }
        }
        return ret;
    }

    private boolean canExpend(String s, String l) {
        int i = 0, j = 0;
        while (i < s.length() && j < l.length()) {
            if (s.charAt(i) != l.charAt(j)) {
                return false;
            }
            int aCnt = 1, bCnt = 1;
            while (i < s.length() - 1 && s.charAt(i) == s.charAt(i + 1)) {
                ++i;
                ++aCnt;
            }
            while (j < l.length() - 1 && l.charAt(j) == l.charAt(j + 1)) {
                ++j;
                ++bCnt;
            }
            if (!(aCnt < 3 && aCnt != bCnt || aCnt < bCnt)) {
                return false;
            }
            ++i;
            ++j;
        }
        return i == s.length() && j == l.length();
    }

}