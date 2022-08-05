package leetcode;

import java.util.*;

/**
 * @author zhiqungao@tencent.com
 * @date 2021/11/17 下午8:25
 */
public class Leetcode_301_removeInvalidParentheses {
    public static void main(String[] args) {
        Leetcode_301_removeInvalidParentheses l = new Leetcode_301_removeInvalidParentheses();
        System.out.println(l.removeInvalidParentheses("()())()"));
        System.out.println(l.removeInvalidParentheses("(a)())()"));
        System.out.println(l.removeInvalidParentheses(")("));
    }



    /**
     * 删除最小数量的无效括号
     */

    private String s;
    private Set<String> ans;
    private int m;

    public List<String> removeInvalidParentheses(String s) {
        this.s = s;
        this.ans = new HashSet<>();
        this.m = 0;
        dfs(0, 0, new StringBuilder());
        return new ArrayList<>(ans);
    }

    private void dfs(int cur, int n, StringBuilder sb) {
        if (cur == s.length()) {
            if (n == 0) {
                if (sb.length() < m) {
                    return;
                } else if (sb.length() > m) {
                    m = sb.length();
                    ans = new HashSet<>();
                }
                ans.add(sb.toString());
            }
            return;
        }
        if (n < 0) {
            return;
        }
        dfs(cur + 1, n, sb);
        char ch = s.charAt(cur);
        sb.append(ch);
        switch (ch) {
            case '(':
                dfs(cur + 1, n + 1, sb);
                break;
            case ')':
                dfs(cur + 1, n - 1, sb);
                break;
            default:
                dfs(cur + 1, n, sb);
        }
        sb.deleteCharAt(sb.length() - 1);
    }

}
