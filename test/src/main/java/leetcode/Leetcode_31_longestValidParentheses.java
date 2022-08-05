package leetcode;


import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Stack;

/**
 * @author zhiqungao@tencent.com
 * @date 2021/11/1 下午7:35
 */
public class Leetcode_31_longestValidParentheses {

    public static void main(String[] args) {
        Leetcode_31_longestValidParentheses l = new Leetcode_31_longestValidParentheses();
        System.out.println(l.longestValidParentheses3("()(()"));
        System.out.println(l.longestValidParentheses3("(()())"));
        System.out.println(l.longestValidParentheses3(""));
        System.out.println(l.longestValidParentheses3(")()())"));
        System.out.println(l.longestValidParentheses3("(()"));
    }

    public int longestValidParentheses(String s) {
        int m = s.length();
        int[] dp = new int[m + 1];
        for (int l = m - 2; l >= 0; --l) {
            dp[l] = 0;
            if (s.charAt(l) == '(') {
                int slot = 1;
                for (int r = l + 1; r < s.length() && slot > 0; ++r) {
                    if (s.charAt(r) == '(') {
                        ++slot;
                    } else if (s.charAt(r) == ')') {
                        --slot;
                    }
                    if (slot == 0) {
                        dp[l] = dp[r + 1] + (r - l + 1);
                    }
                }
            }
        }
        int ans = 0;
        for (int i : dp) {
            ans = Math.max(ans, i);
        }
        return ans;
    }

    public int longestValidParentheses2(String s) {
        int ans = 0;
        int[] dp = new int[s.length()];
        for (int i = 1; i < s.length(); ++i) {
            if (s.charAt(i) == ')') {
                if (s.charAt(i - 1) == '(') {
                    dp[i] = (i > 2 ? dp[i - 2] : 0) + 2;
                } else if (i - dp[i - 1] > 0 && s.charAt(i - dp[i - 1] - 1) == '(') {
                    dp[i] = dp[i - 1] + (i - dp[i - 1] >= 2 ? dp[i - dp[i - 1] - 2] : 2);
                }
                ans = Math.max(dp[i], ans);
            }
        }
        return ans;
    }

    public int longestValidParentheses3(String s) {
        int ans = 0;
        Stack<Integer> stack = new Stack<>();
        stack.push(-1);
        for (int i = 0; i < s.length(); ++i) {
            if (s.charAt(i) == '(') {
                stack.push(i);
            } else {
                if (!stack.isEmpty()) {
                    stack.pop();
                }
                if (stack.isEmpty()) {
                    stack.push(i);
                }
                ans = Math.max(ans, i - stack.peek());
            }
        }
        return ans;
    }


}
