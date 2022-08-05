package algorithm.dp;

/**
 * @author zhiqungao@tencent.com
 * @date 2021/7/7 下午8:10
 */
public class GetMaxRepetitions {
    public static void main(String[] args) {

    }

    public int getMaxRepetitions(String s1, int n1, String s2, int n2) {
        int l1 = s1.length() * n1;
        boolean[] dp = new boolean[l1 + 1];
        dp[0] = true;
        int min = Integer.MAX_VALUE;
        for (int i = 1; i <= s2.length(); i++) {
            for (int j = l1; j >= i; j--) {
                if (s2.charAt(i - 1) == s1.charAt((j - 1) % s1.length())) {
                    dp[j] = dp[j - 1];
                    if (i == s2.length() && dp[j]) {
                        min = Math.min(min, j);
                    }
                }
            }
        }
        if (min < Integer.MAX_VALUE) {
            return l1 / min / n2;
        }
        return 0;
    }
}
