package algorithm.niuke;

/**
 * @author zhiqungao@tencent.com
 * @date 2022/6/19 下午6:41
 */
public class BigIntegerMultiple {
    public static void main(String[] args) {
        BigIntegerMultiple bigIntegerMultiple = new BigIntegerMultiple();
        System.out.println(bigIntegerMultiple.solve("99", "999"));
    }


    public String solve(String s, String t) {
        // write code here
        if ("0".equals(s) || "0".equals(t)) {
            return "0";
        }
        if (t.length() > s.length()) {
            String p = s;
            s = t;
            t = p;
        }
        int m = s.length(), n = t.length();
        int[] ret = new int[m + n + 2];
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                ret[i + j] +=
                        (s.charAt(m - 1 - i) - '0')
                                * (t.charAt(n - 1 - j) - '0');
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i <= m + n; ++i) {
            int carry = ret[i] / 10;
            ret[i + 1] += carry;
            ret[i] %= 10;
            sb.append(ret[i]);
        }
        while (sb.charAt(sb.length() - 1) == '0') {
            sb.deleteCharAt(sb.length() - 1);
        }
        return sb.reverse().toString();
    }

}
