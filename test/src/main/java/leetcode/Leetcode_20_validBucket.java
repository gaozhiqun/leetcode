package leetcode;

import java.util.Stack;

/**
 * @author zhiqungao@tencent.com
 * @date 2021/10/29 下午6:14
 */
public class Leetcode_20_validBucket {
    public static void main(String[] args) {
        Leetcode_20_validBucket l = new Leetcode_20_validBucket();
        System.out.println(l.isValid("()"));
    }

    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (char ch : s.toCharArray()) {
            switch (ch) {
                case '(':
                case '[':
                case '{':
                    stack.push(ch);
                    break;
                case ')':
                    if (stack.isEmpty() || !('(' == stack.pop())) {
                        return false;
                    }
                    break;
                case '}':
                    if (stack.isEmpty() || !('{' == stack.pop())) {
                        return false;
                    }
                    break;
                case ']':
                    if (stack.isEmpty() || !('[' == stack.pop())) {
                        return false;
                    }
                    break;
                default:
            }
        }
        return stack.isEmpty();
    }


}

