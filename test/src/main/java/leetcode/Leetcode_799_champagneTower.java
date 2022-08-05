package leetcode;

/**
 * @author zhiqungao@tencent.com
 * @date 2021/11/17 下午8:25
 */
public class Leetcode_799_champagneTower {

    public static void main(String[] args) {
        Leetcode_799_champagneTower l = new Leetcode_799_champagneTower();
        System.out.println(l.champagneTower(1, 1, 1));
        System.out.println(l.champagneTower(2, 1, 1));
    }


    public double champagneTower(int poured, int query_row, int query_glass) {
        double[][] dp = new double[query_row + 1][query_row + 1];
        dp[0][0] = poured;
        for (int i = 0; i < query_row; i++) {
            for (int j = 0; j <= i; j++) {
                if (dp[i][j] > 1.0) {
                    double remain = dp[i][j] - 1.0;
                    dp[i][j] = 1.0;
                    dp[i + 1][j] += (remain / 2);
                    dp[i + 1][j + 1] += (remain / 2);
                }
            }
        }
        return dp[query_row][query_glass] > 1.0 ? 1.0 : dp[query_row][query_glass];

    }


}