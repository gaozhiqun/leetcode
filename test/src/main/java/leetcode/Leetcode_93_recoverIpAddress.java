package leetcode;


import java.util.ArrayList;
import java.util.List;

/**
 * @author zhiqungao@tencent.com
 * @date 2021/11/1 下午7:35
 */
public class Leetcode_93_recoverIpAddress {

    /**
     * 10
     */

    public static void main(String[] args) {
        Leetcode_93_recoverIpAddress l = new Leetcode_93_recoverIpAddress();
        System.out.println(l.restoreIpAddresses("0000"));
    }

    public List<String> restoreIpAddresses(String s) {
        if (s.length() < 4) {
            return new ArrayList<>();
        }
        List<String> ans = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        sb.append(s.charAt(0));
        dfs(ans, sb, s, 1, s.charAt(0) - '0', 0);
        return ans;
    }

    private void dfs(List<String> ans, StringBuilder sb, String s, int cur, int temp, int seg) {
        if (seg == 3 && cur == s.length()) {
            ans.add(sb.toString());
            return;
        }
        if (seg > 3 || cur >= s.length()) {
            return;
        }
        int d = s.charAt(cur) - '0';
        sb.append(".");
        sb.append(d);
        dfs(ans, sb, s, cur + 1, d, seg + 1);
        sb.deleteCharAt(sb.length() - 1);
        sb.deleteCharAt(sb.length() - 1);

        if (temp > 0 && temp * 10 + d < 256) {
            sb.append(d);
            dfs(ans, sb, s, cur + 1, temp * 10 + d, seg);
            sb.deleteCharAt(sb.length() - 1);
        }
    }

}
