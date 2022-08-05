package algorithm.offer;

import java.util.Arrays;
import java.util.Stack;

/**
 * @author zhiqungao@tencent.com
 * @date 2021/6/3 5:29 下午
 */
public class ValidateStackSequece {
    public static void main(String[] args) {

        ValidateStackSequece v = new ValidateStackSequece();
        System.out.println(v.validateSequences2(new int[]{1, 2, 3, 4, 5}, new int[]{4, 5, 3, 2, 1}));
    }

    public boolean validateSequences2(int[] pushed, int[] poped) {
        Stack<Integer> stack = new Stack<>();
        int cur = 0;
        for (int i : pushed) {
            stack.push(i);
            while (!stack.isEmpty() && stack.peek() == poped[cur]) {
                stack.pop();
                cur++;
            }
        }
        return stack.isEmpty();
    }

    public boolean validateSequences(int[] pushed, int[] poped) {
        return heler(pushed, poped);
    }

    private boolean heler(int[] pushed, int[] poped) {
        if (pushed.length == 1) {
            return pushed[0] == poped[0];
        }
        if (Arrays.equals(pushed, poped)) {
            return true;
        }
        int[] reverseArray = new int[pushed.length];
        for (int i = 1; i <= pushed.length; i++) {
            reverseArray[i - 1] = poped[poped.length - i];
        }
        if (Arrays.equals(pushed, reverseArray)) {
            return true;
        }
        for (int i = 1; i < pushed.length; i++) {
            int[] pushedL = new int[i];
            int[] popedL = new int[i];
            int[] reversePopL = new int[i];
            int[] pushedR = new int[pushed.length - i];
            int[] popedR = new int[pushed.length - i];
            int[] reversePopR = new int[pushed.length - i];
            System.arraycopy(pushed, 0, pushedL, 0, i);
            System.arraycopy(pushed, i, pushedR, 0, pushed.length - i);

            System.arraycopy(poped, 0, popedL, 0, i);
            System.arraycopy(poped, i, popedR, 0, pushed.length - i);

            System.arraycopy(poped, pushed.length - i, reversePopL, 0, i);
            System.arraycopy(poped, 0, reversePopR, 0, pushed.length - i);
            if (validateSequences(pushedL, popedL) && validateSequences(pushedR, popedR)
                    || validateSequences(pushedL, reversePopL) && validateSequences(pushedR, reversePopR)) {
                return true;
            }

        }
        return false;
    }
}
