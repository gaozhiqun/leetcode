package algorithm.bfs;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Queue;

/**
 * @author zhiqungao@tencent.com
 * @date 2021/10/21 下午8:41
 */
public class TallestBillboard {

    public static void main(String[] args) {

    }

    int NINF = Integer.MIN_VALUE / 3;
    Integer[][] memo;

    public int tallestBillboard(int[] rods) {
        int N = rods.length;
        // "memo[n][x]" will be stored at memo[n][5000+x]
        // Using Integer for default value null
        memo = new Integer[N][10001];
        return (int) dp(rods, 0, 5000);
    }

    public int dp(int[] rods, int i, int s) {
        if (i == rods.length) {
            return s == 5000 ? 0 : NINF; //初始条件
        } else if (memo[i][s] != null) {
            return memo[i][s];
        } else {
            int ans = dp(rods, i + 1, s);
            ans = Math.max(ans, dp(rods, i + 1, s - rods[i]));
            ans = Math.max(ans, rods[i] + dp(rods, i + 1, s + rods[i]));
            memo[i][s] = ans;
            return ans;
        }
    }
}



