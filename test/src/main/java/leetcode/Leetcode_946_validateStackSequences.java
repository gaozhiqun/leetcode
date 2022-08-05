package leetcode;

import java.util.Stack;

/**
 * @author zhiqungao@tencent.com
 * @date 2022/3/24 下午4:34
 */
public class Leetcode_946_validateStackSequences {
    public static void main(String[] args) {
        Leetcode_946_validateStackSequences l = new Leetcode_946_validateStackSequences();
        System.out.println(l.validateStackSequences(new int[]{1, 2, 3, 4, 5}, new int[]{4, 5, 3, 2, 1}));
        System.out.println(l.validateStackSequences(new int[]{1, 2, 3, 4, 5}, new int[]{4, 3, 5, 1, 2}));

    }

    public boolean validateStackSequences(int[] pushed, int[] popped) {
        Stack<Integer> stack = new Stack<>();
        int j = 0;
        for (int i = 0; i < pushed.length; ++i) {
            stack.push(pushed[i]);
            while (!stack.isEmpty() && stack.peek() == popped[j]) {
                ++j;
                stack.pop();
            }
        }
        return stack.empty();
    }
}
