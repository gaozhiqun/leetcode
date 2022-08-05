package leetcode;


/**
 * @author zhiqungao@tencent.com
 * @date 2021/10/29 下午2:37
 */
public class Leetcode_5_longestPalindrome {
    public static void main(String[] args) {
        Leetcode_5_longestPalindrome l = new Leetcode_5_longestPalindrome();
        System.out.println(l.longestPalindrome("babad"));
    }

    public String longestPalindrome(String s) {
        if ("".equals(s)) {
            return "";
        }
        String ans = "" + s.charAt(0);
        for (int i = 0; i < s.length(); i++) {
            String a = find(i, i, s);
            String b = find(i - 1, i, s);
            if (a.length() > ans.length()) {
                ans = a;
            }
            if (b.length() > ans.length()) {
                ans = b;
            }
        }
        return ans;
    }

    private String find(int l, int r, String s) {
        while (l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)) {
            --l;
            ++r;
        }
        return s.substring(l + 1, r);
    }
}
