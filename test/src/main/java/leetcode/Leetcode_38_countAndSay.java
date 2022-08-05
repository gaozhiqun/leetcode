package leetcode;


import java.util.Arrays;
import java.util.LinkedList;

/**
 * @author zhiqungao@tencent.com
 * @date 2021/11/1 下午7:35
 */
public class Leetcode_38_countAndSay {

    public static void main(String[] args) {
        Leetcode_38_countAndSay l = new Leetcode_38_countAndSay();
        System.out.println(l.countAndSay(2));
        System.out.println(l.countAndSay(3));
        System.out.println(l.countAndSay(4));
        System.out.println(l.countAndSay(5));
    }

    /**
     * 第一项是数字 1
     * 描述前一项，这个数是 1 即 “ 一 个 1 ”，记作 "11"
     * 描述前一项，这个数是 11 即 “ 二 个 1 ” ，记作 "21"
     * 描述前一项，这个数是 21 即 “ 一 个 2 + 一 个 1 ” ，记作 "1211"
     * 描述前一项，这个数是 1211 即 “ 一 个 1 + 一 个 2 + 二 个 1 ” ，记作 "111221"
     *
     */

    /**
     * 1.     1
     * 2.     11
     * 3.     21
     * 4.     1211
     * 5.     111221
     *
     * @param n
     * @return
     */
    public String countAndSay(int n) {
        if (n == 1) {
            return "1";
        }
        String pre = countAndSay(n - 1);
        return cnt(pre);
    }

    private String cnt(String s) {
        int cnt = 1;
        char ch = s.charAt(0);
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= s.length(); ++i) {
            if (i == s.length()) {
                sb.append(cnt);
                sb.append(ch);
                break;
            } else if (ch != s.charAt(i)) {
                sb.append(cnt);
                sb.append(ch);
                ch = s.charAt(i);
                cnt = 1;
            } else {
                ++cnt;
            }
        }
        return sb.toString();
    }
}
