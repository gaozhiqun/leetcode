package algorithm.array;

import java.util.Stack;

/**
 * @author zhiqungao@tencent.com
 * @date 2021/7/6 下午8:16
 */
public class Find132Pattern {
    public static void main(String[] args) {
        Find132Pattern find132Pattern = new Find132Pattern();
        System.out.println(find132Pattern.find132pattern(new int[]{1, 2, 3, 4}));
        System.out.println(find132Pattern.find132pattern(new int[]{3, 1, 4, 2}));
        System.out.println(find132Pattern.find132pattern(new int[]{-1, 3, 2, 0}));
    }

    /**
     * 维护单调增栈
     *
     * @param nums
     * @return
     */
    public boolean find132pattern(int[] nums) {
        Stack<Integer> stack = new Stack<>();
        int n = nums.length;
        stack.push(nums[n - 1]);
        int max = Integer.MIN_VALUE; //后者为单调增栈
        for (int i = n - 2; i >= 0; i--) {
            if (nums[i] < max) {
                return true;
            }
            while (!stack.isEmpty() && nums[i] > stack.peek()) {
                max = stack.pop();
            }
            if (nums[i] > max) {
                stack.push(nums[i]);
            }
        }
        return false;
    }
}
