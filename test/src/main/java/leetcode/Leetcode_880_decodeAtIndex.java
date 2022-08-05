package leetcode;

import java.util.Stack;

/**
 * @author zhiqungao@tencent.com
 * @date 2022/2/21 下午4:33
 */
public class Leetcode_880_decodeAtIndex {
    public static void main(String[] args) {

    }

    public String decodeAtIndex(String s, int k) {
        long size = 0;
        int N = s.length();
        for (int i = 0; i < N; ++i) {
            char c = s.charAt(i);
            if (Character.isDigit(c)) {
                size *= c - '0';
            } else {
                size++;
            }
        }
        for (int i = N - 1; i >= 0; --i) {
            char c = s.charAt(i);
            k %= size;
            if (k == 0 && Character.isLetter(c)) {
                return Character.toString(c);
            }
            if (Character.isDigit(c)) {
                size /= c - '0';
            } else {
                size--;
            }
        }
        throw null;
    }


}
