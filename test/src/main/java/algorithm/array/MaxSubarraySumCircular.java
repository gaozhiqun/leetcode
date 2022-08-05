package algorithm.array;

import java.util.Stack;

/**
 * @author zhiqungao@tencent.com
 * @date 2021/10/19 下午7:36
 */
public class MaxSubarraySumCircular {
    public static void main(String[] args) {
        MaxSubarraySumCircular maxSubarraySumCircular = new MaxSubarraySumCircular();
        System.out.println(maxSubarraySumCircular.maxSubArraySumCircular(new int[]{
                1, -1, 3, -2
        }));
        System.out.println(maxSubarraySumCircular.maxSubArraySumCircular(new int[]{
                5, -3, 5
        }));
        System.out.println(maxSubarraySumCircular.maxSubArraySumCircular(new int[]{
                3, -1, 2, -1
        }));
        System.out.println(maxSubarraySumCircular.maxSubArraySumCircular(new int[]{
                3, -2, 2, -3
        }));
        System.out.println(maxSubarraySumCircular.maxSubArraySumCircular(new int[]{
                -2, -3, -1
        }));
    }

    /**
     * sum[j]- sum[i] sum[m-1] -sum[j] + sum[i] = sum[m-1] -(sum[j],sum[i])
     *
     * @param nums
     * @return
     */
    public int maxSubArraySumCircular(int[] nums) {
        int m = nums.length;
        int[] sums = new int[m];
        sums[0] = nums[0];
        int ans = Integer.MIN_VALUE;
        for (int i = 1; i < m; ++i) {
            sums[i] = sums[i - 1] + nums[i];
        }
        Stack<Integer> reduceStack = new Stack<>();
        Stack<Integer> increaseStack = new Stack<>();
        for (int i = 0; i < m; i++) {
            ans = Math.max(ans, sums[i]);
            ans = Math.max(ans, sums[m - 1 - i]);
            while (!reduceStack.isEmpty() && reduceStack.peek() > sums[i]) {
                int temp = reduceStack.pop();
                ans = Math.max(ans, sums[i] - sums[temp]);
            }
            while (!increaseStack.isEmpty() && increaseStack.peek() < sums[m - 1 - i]) {
                int temp = increaseStack.pop();
                ans = Math.max(ans, sums[m - 1] - sums[i] + sums[temp]);
            }
            reduceStack.push(i);
            increaseStack.push(i);
        }
        return ans;
    }
}
