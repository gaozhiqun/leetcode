package leetcode;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @author zhiqungao@tencent.com
 * @date 2022/6/26 下午9:07
 */
public class Leetcode_1098_smallestSubsequence {

    public static void main(String[] args) {
        String s2 = "cdadabcc";
        String s1 = "cbacdcbc";
        Leetcode_1098_smallestSubsequence l = new Leetcode_1098_smallestSubsequence();
        System.out.println(l.smallestSubsequence(s2));
        System.out.println(l.smallestSubsequence(s1));
    }


    public String smallestSubsequence(String s) {
        int[] cnts = new int[26];
        boolean[] used = new boolean[26];
        StringBuilder ret = new StringBuilder();
        for (char ch : s.toCharArray()) {
            ++cnts[ch - 'a'];
        }
        for (char ch : s.toCharArray()) {
            --cnts[ch - 'a'];
            if (used[ch - 'a']) {
                continue;
            }
            while (ret.length() > 0 && ret.charAt(ret.length() - 1) > ch) {
                if (cnts[ret.charAt(ret.length() - 1) - 'a'] > 0) {
                    used[ret.charAt(ret.length() - 1) - 'a'] = false;
                    ret.deleteCharAt(ret.length() - 1);
                } else {
                    break;
                }
            }
            used[ch - 'a'] = true;
            ret.append(ch);
        }
        return ret.toString();
    }


    public void duplicateZeros(int[] arr) {
        for (int i = 0; i < arr.length - 1; ++i) {
            if (arr[i] == 0) {
                System.arraycopy(arr, i + 1, arr, i + 2, arr.length - i - 2);
                arr[i + 1] = 0;
                i = i + 1;
            }
        }
    }

}
