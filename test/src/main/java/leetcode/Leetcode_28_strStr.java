package leetcode;


/**
 * @author zhiqungao@tencent.com
 * @date 2021/10/29 下午6:14
 */
public class Leetcode_28_strStr {

    public static void main(String[] args) {
        Leetcode_28_strStr l = new Leetcode_28_strStr();
        System.out.println(l.strStr("abcabcabcdeabc", "abcabcabcd"));
        System.out.println(l.strStr("hello", "ll"));
        System.out.println(l.strStr("aaaaa", "aab"));
        System.out.println(l.strStr("mississippi", "issi"));
        /**
         * "mississippi"
         * "issi"
         */

    }

    public int strStr(String haystack, String needle) {
        if ("".equals(needle)) {
            return 0;
        }
        int n = haystack.length(), m = needle.length();
        int[] next = getNext(needle);
        for (int i = 0, j = 0; i < n; ++i) {
            while (j > 0 && haystack.charAt(i) != needle.charAt(j)) {
                j = next[j - 1];
            }
            if (haystack.charAt(i) == needle.charAt(j)) {
                ++j;
            }
            if (j == m) {
                return i - j + 1;
            }
        }
        return -1;
    }

    private int[] getNext(String p) {
        int m = p.length();
        int[] next = new int[m];
        for (int i = 1, j = 0; i < m; ++i) {
            while (j > 0 && p.charAt(i) != p.charAt(j)) {
                j = next[j - 1];
            }
            if (p.charAt(i) == p.charAt(j)) {
                ++j;
            }
            next[i] = j;
        }
        return next;
    }


}

