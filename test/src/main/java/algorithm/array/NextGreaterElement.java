package algorithm.array;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

/**
 * @author zhiqungao@tencent.com
 * @date 2021/3/8 8:23 下午
 */
public class NextGreaterElement {
    public static void main(String[] args) {
        NextGreaterElement nextGreaterElement = new NextGreaterElement();
        System.out.println(Arrays.asList(nextGreaterElement.nexGreaterElement(new int[]{1, 3, 2, 4})));
    }

    public int[] nexGreaterElement(int[] nums) {
        int n = nums.length;
        int[] ret = new int[n];
        Arrays.fill(ret, -1);
        Deque<Integer> stack = new LinkedList<>();
        for (int i = 0; i < n * 2 - 1; i++) {
            while (!stack.isEmpty() && nums[stack.peek()] < nums[i % n]) {//单调递减栈
                ret[stack.pop()] = nums[i % n];
            }
            stack.push(i % n);
        }
        return ret;
    }
}