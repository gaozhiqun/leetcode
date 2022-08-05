package leetcode;


import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author zhiqungao@tencent.com
 * @date 2021/10/29 下午6:14
 */
public class Leetcode_22_generateParenthesis {
    public static void main(String[] args) {
        Leetcode_22_generateParenthesis l = new Leetcode_22_generateParenthesis();
        List<String> ans = l.generateParenthesis(3);
        for (String s : ans) {
            System.out.println(s);
        }
    }

    public List<String> generateParenthesis(int n) {
        Set<String> ans = new HashSet<>();
        dfs(new StringBuilder(), 0, 0, n, ans);
        return new ArrayList<>(ans);
    }

    private void dfs(StringBuilder builder, int cur, int slot, int n, Set<String> ans) {
        if (cur == n) {
            for (int i = 0; i < slot; ++i) {
                builder.append(')');
            }
            ans.add(builder.toString());
            for (int i = 0; i < slot; ++i) {
                builder.deleteCharAt(builder.length() - 1);
            }
            return;
        }
        if (slot < n) {
            builder.append('(');
            dfs(builder, cur + 1, slot + 1, n, ans);
            builder.deleteCharAt(builder.length() - 1);
        }
        for (int i = 1; i <= slot; i++) {
            builder.append(')');
        }
        for (int i = slot; i > 0; --i) {
            dfs(builder, cur, slot - i, n, ans);
            builder.deleteCharAt(builder.length() - 1);
        }
    }


}

