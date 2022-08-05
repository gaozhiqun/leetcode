package algorithm.array;

import java.util.Stack;

/**
 * @author zhiqungao@tencent.com
 * @date 2021/10/19 下午8:52
 */
public class MinAddToMakeValid {
    public static void main(String[] args) {
        MinAddToMakeValid minAddToMakeValid = new MinAddToMakeValid();
        System.out.println(minAddToMakeValid.minAddToMakeValid("()))(("));
    }

    public int minAddToMakeValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (char ch : s.toCharArray()) {
            if (stack.isEmpty()) {
                stack.push(ch);
            } else if (ch == ')' && stack.peek() == '(') {
                stack.pop();
            } else {
                stack.push(ch);
            }
        }
        return stack.size();
    }

    public int minAddToMakeValid2(String s) {
        int ans = 0, l = 0;
        for (char ch : s.toCharArray()) {
            if (ch == '(') {
                ++l;
            } else {
                --l;
                if (l < 0) {
                    ++ans;
                    ++l;
                }
            }
        }
        return ans + l;
    }
}
