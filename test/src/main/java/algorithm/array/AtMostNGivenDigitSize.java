package algorithm.array;

/**
 * @author zhiqungao@tencent.com
 * @date 2021/10/18 下午7:43
 */
public class AtMostNGivenDigitSize {

    public static void main(String[] args) {

    }

    public int atMostNGivenDigitSet(String[] digit, int n) {
        String target = String.valueOf(n);
        int m = target.length();
        int[] dp = new int[m];
        dp[m] = 1;
        /**
         * 后K位比target少的数字
         */
        for (int i = m - 1; i >= 0; --i) {
            int targetI = target.charAt(i);
            for (String d : digit) {
                if (Integer.valueOf(d) < targetI) {
                    dp[i] += Math.pow(digit.length, m - i - 1);
                } else if (Integer.valueOf(d) == targetI) {
                    dp[i] += dp[i + 1];
                }
            }
        }
        for (int i = 1; i < m; ++i) {
            dp[0] += Math.pow(digit.length, i);
        }
        return dp[0];
    }


}
