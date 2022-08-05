package algorithm.dp;

import java.util.Stack;

/**
 * @author zhiqungao@tencent.com
 * @date 2021/3/16 9:11 下午
 */
public class LongestValidateBuckets {
    public static void main(String[] args) {
        LongestValidateBuckets longestValidateBuckets = new LongestValidateBuckets();
        System.out.println(longestValidateBuckets.longestValidateBuckets("()()"));
        System.out.println(longestValidateBuckets.longestValidateBuckets(")()())"));
        System.out.println(longestValidateBuckets.longestValidateBuckets("(()"));
        System.out.println(longestValidateBuckets.longestValidateBuckets("(())"));
    }

    public int longestValidateBuckets(String s) {
        Stack<Integer> stack = new Stack<>();
        int result = 0;
        stack.push(-1);//每一个有效队列的前一个位置
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == '(') {
                stack.push(i);
            } else {
                stack.pop();
                if (stack.isEmpty()) {
                    stack.push(i);
                } else {
                    result = Math.max(result, i - stack.peek());
                }
            }
        }

        return result;
    }

    public int longestValidateBucketsDp(String s) {
        int maxans = 0;
        int[] dp = new int[s.length()];
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == ')') {
                if (s.charAt(i - 1) == '(') {//匹配了最近的括号
                    dp[i] = (i >= 2 ? dp[i - 2] : 0) + 2;
                } else if (i - dp[i - 1] > 0 && s.charAt(i - dp[i - 1] - 1) == '(') {//匹配前一个有效括号
                    dp[i] = dp[i - 1] + ((i - dp[i - 1]) >= 2 ? dp[i - dp[i - 1] - 2] : 0) + 2;
                }
                maxans = Math.max(maxans, dp[i]);
            }
        }
        return maxans;
    }

}


/***
 * ()()(()))
 * 左括号数等于右括号数时
 */