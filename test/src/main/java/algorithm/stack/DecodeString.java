package algorithm.stack;

import java.util.Stack;

/**
 * @author zhiqungao@tencent.com
 * @date 2021/7/1 下午7:54
 */
public class DecodeString {
    public static void main(String[] args) {

    }

    /**
     * 3[a[2[bc]]]
     *
     * @param s
     * @return
     */

    public String decodeString(String s) {
        StringBuilder curBuilder = new StringBuilder();
        Stack<String> stack = new Stack<>();
        int num = 0;
        for (char cur : s.toCharArray()) {
            if (cur >= '0' && cur <= 9) {
                num *= 10;
                num += Integer.valueOf(cur);

            } else if (cur == '[') {
                stack.push(String.valueOf(num));
                num = 0;
            }
            if (cur == ']') {

            }
        }
        return null;
    }
}
