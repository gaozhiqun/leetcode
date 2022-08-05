package algorithm.huawei;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author zhiqungao@tencent.com
 * @date 2022/6/24 下午5:41
 */
public class Match {

    public static void main(String[] args) {
        System.out.println(split("l \"b:\\\" /kzv /yar"));
        Scanner in = new Scanner(System.in);
        int p = Integer.parseInt(in.nextLine());
        String s = in.nextLine();
        List<String> list = split(s);
        System.out.println(list.size());
        for (String si : list) {
            System.out.println(si);
        }
    }


    public static List<String> split(String s) {
        List<String> args = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        boolean foundQuote = false;
        for (char c : s.toCharArray()) {
            if (c == '\"') {
                if (sb.length() > 0) {
                    args.add(sb.toString());
                    sb = new StringBuilder();
                }
                foundQuote = !foundQuote;
            } else if (c == ' ') {
                if (foundQuote) {
                    sb.append(c);
                } else {
                    if (sb.length() > 0) {
                        args.add(sb.toString());
                        sb = new StringBuilder();
                    }
                }
            } else {
                sb.append(c);
            }
        }
        if (sb.length() > 0) {
            args.add(sb.toString());
        }
        return args;
    }


    /**
     * *：匹配0个或以上的字符（注：能被*和?匹配的字符仅由英文字母和数字0到9组成，下同）
     * ？：匹配1个字符
     */
    public static boolean match(String p, String s) {
        p = p.toLowerCase();
        s = s.toLowerCase();
        int m = s.length();
        int n = p.length();
        boolean[][] dp = new boolean[m + 1][n + 1];
        dp[0][0] = true;
        for (int j = 1; j <= n; j++) {
            if (p.charAt(j - 1) == '*') {
                dp[0][j] = true;
            } else {
                break;
            }
        }
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                if (p.charAt(j) == '*') {
                    dp[i + 1][j + 1] = dp[i + 1][j] || dp[i][j] || dp[i][j + 1]; //0 OR 1
                } else if (p.charAt(j) == '?' && (Character.isDigit(s.charAt(i))
                        || Character.isAlphabetic(s.charAt(i)))
                        || s.charAt(i) == p.charAt(j)) {
                    dp[i + 1][j + 1] = dp[i][j];
                }
            }
        }
        return dp[m][n];
    }
}
