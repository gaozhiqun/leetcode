package leetcode;

import algorithm.tree.TreeNode;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;


/**
 * @author zhiqungao@tencent.com
 * @date 2021/12/14 上午10:48
 */
public class Leetcode_509_fib {

    public static void main(String[] args) {
        Leetcode_509_fib l = new Leetcode_509_fib();
    }

    public int fib(int n) {
        if (n == 0) {
            return 0;
        } else if (n == 1) {
            return 1;
        }
        int[] dp = new int[n + 1];
        dp[1] = 1;
        for (int i = 2; i <= n; ++i) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }
}