package algorithm.array;

import java.util.Arrays;
import java.util.Stack;

/**
 * @author zhiqungao@tencent.com
 * @date 2021/6/11 4:16 下午
 */
public class DailyTemperatures {

    public static void main(String[] args) {


    }

    //单调递减栈
    public int[] dailyTemperatures(int[] array) {
        int[] result = new int[array.length];
        Arrays.fill(result, 0);
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < array.length; i++) {
            while (!stack.isEmpty() && array[stack.peek()] < array[i]) {
                int pre = stack.pop();
                result[pre] = i - pre;
            }
            stack.push(i);
        }
        return result;
    }

}
