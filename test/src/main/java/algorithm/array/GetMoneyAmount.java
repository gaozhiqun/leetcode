package algorithm.array;

/**
 * @author zhiqungao@tencent.com
 * @date 2021/7/1 下午3:53
 */
public class GetMoneyAmount {
    public static void main(String[] args) {
        GetMoneyAmount getMoneyAmount = new GetMoneyAmount();
        System.out.println(getMoneyAmount.getMoneyAmount(1));
        System.out.println(getMoneyAmount.getMoneyAmount(2));
        System.out.println(getMoneyAmount.getMoneyAmount(3));
        System.out.println(getMoneyAmount.getMoneyAmount(4));
        System.out.println(getMoneyAmount.getMoneyAmount(5));
        System.out.println(getMoneyAmount.getMoneyAmount(6));
    }

    public int getMoneyAmount2(int n) {
        int[] sums = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            sums[i] = sums[i - 1] + i;
        }
        int result = Integer.MAX_VALUE;
        for (int i = 1; i <= n; i++) {
            result = Math.min(Math.max(sums[i], sums[n] - sums[i - 1]), result);
        }
        return result;
    }

    public int getMoneyAmount(int n) {
        int[][] dp = new int[n + 1][n + 1];

        for (int len = 2; len <= n; len++) {
            for (int start = 1; start <= n - len + 1; start++) {
                int minres = Integer.MAX_VALUE;
                for (int piv = start + (len - 1) / 2; piv < start + len - 1; piv++) {
                    int res = piv + Math.max(dp[start][piv - 1], dp[piv + 1][start + len - 1]);
                    minres = Math.min(res, minres);
                }
                dp[start][start + len - 1] = minres;
            }

        }
        return dp[1][n];
    }



}
