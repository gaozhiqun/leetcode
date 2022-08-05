package algorithm.stack;

import java.util.Stack;

/**
 * @author zhiqungao@tencent.com
 * @date 2021/10/21 下午5:10
 */
public class ValidateStackSequeces {
    public static void main(String[] args) {
        ValidateStackSequeces validateStackSequeces = new ValidateStackSequeces();
        System.out.println(validateStackSequeces.validateStackSequeces(
                new int[]{1, 2, 3, 4, 5}, new int[]{4, 5, 3, 2, 1}
        ));
        System.out.println(validateStackSequeces.validateStackSequeces(
                new int[]{1, 2, 3, 4, 5}, new int[]{2, 1, 4, 5, 3}
        ));
        System.out.println(validateStackSequeces.validateStackSequeces(
                new int[]{1, 2, 3, 4, 5}, new int[]{4, 3, 5, 1, 2}
        ));
    }

    public boolean validateStackSequeces(int[] push, int[] poped) {
        int i = 0, j = 0, L = push.length;
        Stack<Integer> stack = new Stack<>();
        while (i < L && j < L) {
            stack.push(push[i++]);
            while (!stack.isEmpty() && stack.peek() == poped[j]) {
                stack.pop();
                j++;
            }
        }
        return j == poped.length;
    }
}
