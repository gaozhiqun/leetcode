package leetcode;


import java.util.ArrayList;
import java.util.List;

/**
 * @author zhiqungao@tencent.com
 * @date 2021/11/1 下午7:35
 */
public class Leetcode_70_climbStairs {

    public static void main(String[] args) {
        Leetcode_70_climbStairs l = new Leetcode_70_climbStairs();
        System.out.println(l.climbStairs(2));
        System.out.println(l.climbStairs(3));
        //System.out.println(l.fullJustify(new String[]{"What", "must", "be", "acknowledgment", "shall", "be"}, 16));
        //System.out.println(l.fullJustify(new String[]{"Science", "is", "what", "we", "understand", "well", "enough", "to", "explain", "to", "a", "computer.", "Art", "is", "everything", "else", "we", "do"}, 20));

    }

    public int climbStairs(int n) {
        if (n == 0 || n == 1) {
            return 1;
        }
        int[] dp = new int[n + 1];
        dp[0] = dp[1] = 1;
        for (int i = 2; i <= n; ++i) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }


}
