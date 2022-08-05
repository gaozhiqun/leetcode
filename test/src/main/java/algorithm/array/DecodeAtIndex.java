package algorithm.array;

import java.util.Stack;

/**
 * @author zhiqungao@tencent.com
 * @date 2021/10/14 下午7:08
 */
public class DecodeAtIndex {
    public static void main(String[] args) {
        DecodeAtIndex decodeAtIndex = new DecodeAtIndex();
        System.out.println(decodeAtIndex.decodeAtIndex("leet2code3", 10));
        System.out.println(decodeAtIndex.decodeAtIndex("haha22", 5));
        System.out.println(decodeAtIndex.decodeAtIndex("a2345678999999999", 5));
    }

    public String decodeAtIndex(String s, int k) {
        int len = 0;
        int cur = 0;
        Stack<Character> stack = new Stack<>();
        while (len < k && cur < s.length()) {
            char ch = s.charAt(cur);
            if (Character.isLowerCase(ch)) {
                ++len;
            } else {
                len *= (ch - '0');
            }
            stack.push(ch);
            ++cur;
        }
        while (!stack.isEmpty()) {
            Character ch = stack.pop();
            if (k == len) {
                return String.valueOf(ch);
            }
            if (Character.isDigit(ch)) {
                len /= (ch - '0');
                if (k > len) {
                    k %= len;
                }
            } else {
                len--;
            }
        }
        return null;
    }
}
