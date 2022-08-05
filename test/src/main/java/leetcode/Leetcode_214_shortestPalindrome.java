package leetcode;


import java.util.*;

/**
 * @author zhiqungao@tencent.com
 * @date 2021/11/5 下午2:42
 */
public class Leetcode_214_shortestPalindrome {

    public static void main(String[] args) {
        Leetcode_214_shortestPalindrome l = new Leetcode_214_shortestPalindrome();
        System.out.println(l.shortestPalindrome("abcd"));
        System.out.println(l.shortestPalindrome(""));
        System.out.println(l.shortestPalindrome("aacecaaa"));
    }

    public String shortestPalindrome(String s) {
        if (s.length() < 2 || isPalindrome(s, 0, s.length() - 1)) {
            return s;
        }
        for (int i = s.length() - 1; i > 0; --i) {
            StringBuilder sb = new StringBuilder();
            sb.append(s, i, s.length()).reverse().append(s);
            if (isPalindrome(sb.toString(), 0, sb.length() - 1)) {
                return sb.toString();
            }
        }
        return "";
    }


    private boolean isPalindrome(String s, int l, int r) {
        while (l < r) {
            if (s.charAt(l) != s.charAt(r)) {
                return false;
            }
            ++l;
            --r;
        }
        return true;
    }


}