package leetcode;

import java.util.Stack;

/**
 * @author zhiqungao@tencent.com
 * @date 2022/6/27 下午6:51
 */
public class Leet_code_1130 {


    /**
     * 将数组中相邻的数两两合并，计算他们的乘积之和，求最小的乘积之和。
     * 输入：arr = [6,2,4]
     * 输出：32
     * 解释：
     * 有两种可能的树，第一种的非叶节点的总和为 36，第二种非叶节点的总和为 32。
     * <p>
     * 24            24
     * /  \          /  \
     * 12   4        6    8
     * /  \               / \
     * 6    2             2   4
     *
     * @param arr
     * @return
     */
    public int mctFromLeafValues(int[] arr) {
        Stack<Integer> stack = new Stack<>();
        stack.push(Integer.MAX_VALUE);//avoid to be empty;
        int ret = 0;
        for (int i : arr) {
            if (stack.isEmpty()) {
                stack.push(i);
            } else {
                while (!stack.isEmpty() && stack.peek() < i) {
                    ret += (stack.pop()) * Math.min(stack.peek(), i);
                }
                stack.push(i);
            }
        }
        while (stack.size() > 2) {
            ret += stack.pop() * stack.peek();
        }
        return ret;
    }
}
