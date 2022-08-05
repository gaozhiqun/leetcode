package algorithm.array;

import java.util.Stack;

/**
 * @author zhiqungao@tencent.com
 * @date 2021/8/26 下午7:11
 */
public class FindUnsortedArray {
    public static void main(String[] args) {
        FindUnsortedArray findUnsortedArray = new FindUnsortedArray();
        System.out.println(findUnsortedArray.findUnSortedSubarray(new int[]{2, 6, 4, 8, 10, 9, 15}));
    }

    public int findUnSortedSubarray(int[] array) {
        if (array.length < 1) {
            return 0;
        }
        Stack<Integer> stack = new Stack<>();
        int l = array.length - 1, r = 0;
        for (int i = 0; i < array.length; i++) {
            while (!stack.isEmpty() && array[stack.peek()] > array[i]) {
                int peek = stack.pop();
                l = Math.min(peek, l);
                r = Math.max(r, i);
            }
            stack.push(i);
        }
        return r - l + 1;
    }
}
