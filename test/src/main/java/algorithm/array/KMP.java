package algorithm.array;

import java.util.List;
import java.util.PriorityQueue;

/**
 * @author zhiqungao@tencent.com
 * @date 2021/11/19 上午10:13
 */
public class KMP {
    public static void main(String[] args) {
        KMP l = new KMP();
        System.out.println(l.kmp("abcabcabcdeabc", "abcabcabcd"));
        System.out.println(l.kmp("hello", "ll"));
        System.out.println(l.kmp("aaaaa", "aab"));
        System.out.println(l.kmp("mississippi", "issi"));
    }

    public int kmp(String s, String p) {
        if ("".equals(p)) {
            return 0;
        }
        int n = s.length(), m = p.length();
        int[] next = getNext(p);
        for (int i = 0, j = 0; i < n; ++i) {
            if (j > 0 && s.charAt(i) != p.charAt(j)) {
                j = next[j - 1];
            }
            if (s.charAt(i) == p.charAt(j)) {
                j++;
            }
            if (j == m) {
                return i - j + 1;
            }
        }
        return -1;
    }

    public int[] getNext(String p) {
        int m = p.length();
        int[] next = new int[m];
        for (int i = 1, j = 0; i < m; ++i) {
            if (j > 0 && p.charAt(i) != p.charAt(j)) {
                j = next[j - 1];
            }
            if (p.charAt(i) == p.charAt(j)) {
                ++j;
            }
            next[i] = j;
        }
        return next;
    }



    public boolean judgeSquareSum(int c) {
        long l = 0, r = (long) Math.sqrt(c);
        while (l <= r) {
            if (l * l + r * r == c) {
                return true;
            } else if (l * l + r * r < c) {
                ++l;
            } else {
                --r;
            }
        }
        return false;
    }
}
