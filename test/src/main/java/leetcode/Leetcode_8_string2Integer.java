package leetcode;


/**
 * @author zhiqungao@tencent.com
 * @date 2021/10/29 下午2:37
 */
public class Leetcode_8_string2Integer {
    public static void main(String[] args) {
        Leetcode_8_string2Integer l = new Leetcode_8_string2Integer();
        System.out.println(l.myAtoi(""));
        System.out.println(l.myAtoi("4913 with words"));
        System.out.println(l.myAtoi("words and 987"));
        System.out.println(l.myAtoi("-91283472332"));
        System.out.println(l.myAtoi("-42"));
        System.out.println(l.myAtoi(" -42"));
        System.out.println(l.myAtoi(" -"));
        System.out.println(l.myAtoi(" +-12"));


    }

    public int myAtoi(String s) {
        s = s.trim();
        if ("".equals(s)) {
            return 0;
        }
        Integer p = null;
        int ans = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '+' || s.charAt(i) == '-') {
                if (ans != 0 || p != null) {
                    break;
                }
                if (s.charAt(i) == '+') {
                    p = 1;
                } else {
                    p = -1;
                }
            } else if (Character.isDigit(s.charAt(i))) {
                if (p == null) {
                    p = 1;
                }
                if (ans == 0 && s.charAt(i) == '0') {
                    continue;
                }
                int pre = ans;
                ans *= 10;
                ans += (s.charAt(i) - '0');
                if (pre != ans / 10) {
                    if (p == 1) {
                        return Integer.MAX_VALUE;
                    } else {
                        return Integer.MIN_VALUE;
                    }
                }
            } else {
                break;
            }
        }
        return ans * (p == null ? 1 : p);
    }
}
