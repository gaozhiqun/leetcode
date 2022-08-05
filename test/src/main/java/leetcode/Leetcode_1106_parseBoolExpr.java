package leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author zhiqungao@tencent.com
 * @date 2022/6/27 下午1:11
 */
public class Leetcode_1106_parseBoolExpr {
    public static void main(String[] args) {
        Leetcode_1106_parseBoolExpr l = new Leetcode_1106_parseBoolExpr();
        System.out.println(l.parseBoolExpr("|(&(t,f,t),!(t))"));
        System.out.println(l.parseBoolExpr("!(f)"));
        System.out.println(l.parseBoolExpr("|(f,t)"));
        System.out.println(l.parseBoolExpr("&(f,t)"));

    }


    public boolean parseBoolExpr(String expression) {
        Stack<Character> stack = new Stack<>();
        for (char ch : expression.toCharArray()) {
            if (ch == ')') {
                List<Character> chars = new ArrayList<>();
                while (stack.peek() != '(') {
                    chars.add(stack.pop());
                }
                stack.pop();
                char op = stack.pop();
                if (op == '&') {
                    stack.push(and(chars));
                } else if (op == '|') {
                    stack.push(or(chars));
                } else if (op == '!') {
                    stack.push(not(chars));
                }
            } else if (ch == ',') {
                continue;
            } else {
                stack.push(ch);
            }
        }
        return stack.pop() == 'f' ? false : true;
    }


    private Character and(List<Character> chars) {
        for (Character s : chars) {
            if ('f' == s) {
                return 'f';
            }
        }
        return 't';
    }

    private Character or(List<Character> chars) {
        for (Character s : chars) {
            if ('t' == s) {
                return 't';
            }
        }
        return 'f';
    }

    private Character not(List<Character> chars) {
        if (chars.size() > 1) {
            return null;
        }
        return 'f' == chars.get(0) ? 't' : 'f';
    }


}
