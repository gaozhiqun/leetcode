package leetcode;


import java.util.Stack;

/**
 * @author zhiqungao@tencent.com
 * @date 2021/11/1 下午7:35
 */
public class Leetcode_42_trapWater {

    public static void main(String[] args) {
        Leetcode_42_trapWater l = new Leetcode_42_trapWater();
        System.out.println(l.trap(new int[]{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1}));
        System.out.println(l.trap(new int[]{4, 2, 0, 3, 2, 5}));
        // System.out.println(l.combinationSum(new int[]{2, 3, 6, 7}, 7));
    }

    public int trap(int[] height) {
        int ans = 0;
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < height.length; ++i) {
            while (!stack.isEmpty() && height[stack.peek()] <= height[i]) {
                int pre = stack.pop();
                if (!stack.isEmpty()) {
                    ans += (Math.min(height[i], height[stack.peek()]) - height[pre])
                            * (i - stack.peek() - 1);
                }
            }
            stack.push(i);
        }
        return ans;
    }

}
