package algorithm;

import leetcode.Leetcode_28_strStr;

/**
 * @author zhiqungao@tencent.com
 * @date 2022/6/14 下午3:48
 */
public class KmpTest {
    public static void main(String[] args) {
        KmpTest l = new KmpTest();
        System.out.println(l.kmp("ababab", "abababab"));
        System.out.println(l.strStr("abcabcabcdeabc", "abcabcabcd"));
        System.out.println(l.strStr("abcabcabcdeabc", "abcabcabcd"));
        System.out.println(l.strStr("hello", "ll"));
        System.out.println(l.strStr("aaaaa", "aab"));
        System.out.println(l.strStr("mississippi", "issi"));
        /**
         * "mississippi"
         * "issi"
         */

    }


    private int strStr(String l, String s) {
        if ("".equals(l)) {
            return -1;
        }
        int[] next = getNext(s);
        for (int i = 0, j = 0; i < l.length(); ++i) {
            while (j > 0 && l.charAt(i) != s.charAt(j)) {
                j = next[j - 1];
            }
            if (l.charAt(i) == s.charAt(j)) {
                ++j;
            }
            if (j == s.length()) {
                return i - j + 1;
            }
        }
        return -1;

    }

    private int[] getNext(String s) {
        int m = s.length();
        int[] next = new int[m];
        for (int i = 1, j = 0; i < m; ++i) {
            while (j > 0 && s.charAt(i) != s.charAt(j)) {
                j = next[j - 1];
            }
            if (s.charAt(i) == s.charAt(j)) {
                ++j;
            }
            next[i] = j;
        }
        return next;
    }

    /**
     * S 在T中出现多少次
     *
     * @param S
     * @param T
     * @return
     */
    public int kmp(String S, String T) {
        if (S.length() > T.length()) {
            return -1;
        }
        int[] next = getNext(S);
        int ret = 0;
        for (int i = 0, j = 0; i < T.length(); ++i) {
            while (j > 0 && T.charAt(i) != S.charAt(j)) {
                j = next[j - 1];
            }
            if (T.charAt(i) == S.charAt(j)) {
                ++j;
            }
            if (j == S.length()) {
                j = next[j - 1];
                ret++;
            }
        }
        return ret > 0 ? ret : -1;

    }
}

