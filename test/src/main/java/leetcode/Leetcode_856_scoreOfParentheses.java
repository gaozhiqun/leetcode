package leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * @author zhiqungao@tencent.com
 * @date 2022/1/28 下午4:11
 */
public class Leetcode_856_scoreOfParentheses {
    public static void main(String[] args) {
        Leetcode_856_scoreOfParentheses l = new Leetcode_856_scoreOfParentheses();

    }

    public int scoreOfParentheses(String S) {
        Stack<Integer> stack = new Stack();
        stack.push(0);
        for (char c : S.toCharArray()) {
            if (c == '(') {
                stack.push(0);
            } else {
                int v = stack.pop();
                int w = stack.pop();
                stack.push(w + Math.max(2 * v, 1));
            }
        }
        return stack.pop();
    }


}
