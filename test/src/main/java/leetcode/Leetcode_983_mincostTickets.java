package leetcode;

import algorithm.tree.TreeNode;

import java.util.Arrays;

/**
 * @author zhiqungao@tencent.com
 * @date 2022/3/16 下午3:17
 */
public class Leetcode_983_mincostTickets {
    public static void main(String[] args) {
        Leetcode_983_mincostTickets l = new Leetcode_983_mincostTickets();
        System.out.println(l.mincostTickets(new int[]{1, 4, 6, 7, 8, 20}, new int[]{2, 7, 15}));
        System.out.println(l.strWithout3a3b(1, 2));
        System.out.println(l.strWithout3a3b(4, 1));
    }


    public int mincostTickets(int[] days, int[] costs) {
        int[] cover = new int[]{1, 7, 30};
        int[] dp = new int[366];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        int cur = 0;
        for (int i = 1; i <= 365; ++i) {
            if (cur < days.length && days[cur] == i) {
                for (int p = 0; p < 3; ++p) {
                    dp[i] = Math.min(dp[i], dp[Math.max(0, i - cover[p])] + costs[p]);
                }
                ++cur;
            } else {
                dp[i] = dp[i - 1];
            }
        }
        return dp[365];
    }

    public String strWithout3a3b(int A, int B) {
        StringBuilder ans = new StringBuilder();

        while (A > 0 || B > 0) {
            boolean writeA = false;
            int L = ans.length();
            if (L >= 2 && ans.charAt(L-1) == ans.charAt(L-2)) {
                if (ans.charAt(L-1) == 'b')
                    writeA = true;
            } else {
                if (A >= B)
                    writeA = true;
            }

            if (writeA) {
                A--;
                ans.append('a');
            } else {
                B--;
                ans.append('b');
            }
        }

        return ans.toString();
    }


}
