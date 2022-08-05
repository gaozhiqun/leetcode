package leetcode;


import java.util.Arrays;

/**
 * @author zhiqungao@tencent.com
 * @date 2021/12/14 上午10:48
 */
public class Leetcode_517_findMinMoves {


    public static void main(String[] args) {
        Leetcode_517_findMinMoves l = new Leetcode_517_findMinMoves();
        System.out.println(l.findMinMoves(new int[]{1, 0, 5}));
        System.out.println(l.findMinMoves(new int[]{0, 3, 0}));
    }

    /**
     * 送到相邻的一台洗衣机。
     *
     * @return
     */
    public int findMinMoves(int[] machines) {
        int total = Arrays.stream(machines).sum();
        int m = machines.length;
        if (total % m != 0) {
            return -1;
        }
        int avg = total / m, ans = 0, curSum = 0;
        for (int i : machines) {
            curSum += (i - avg);
            ans = Math.max(ans, Math.max(Math.abs(curSum), i - avg));
        }
        return ans;
    }

    public int change(int amount, int[] coins) {
        int[] dp = new int[amount + 1];
        dp[0] = 1;
        for (int c : coins) {
            for (int i = 1; i <= amount; i++) {
                if (i - c >= 0) {
                    dp[i] += dp[i - c];
                }
            }
        }
        return dp[amount];

    }
}