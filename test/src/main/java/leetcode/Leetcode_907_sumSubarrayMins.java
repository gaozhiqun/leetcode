package leetcode;

import java.util.Arrays;
import java.util.Stack;

/**
 * @author zhiqungao@tencent.com
 * @date 2022/2/25 下午2:49
 */
public class Leetcode_907_sumSubarrayMins {

    public static void main(String[] args) {
        Leetcode_907_sumSubarrayMins l = new Leetcode_907_sumSubarrayMins();
        System.out.println(l.sumSubarrayMins(new int[]{3, 1, 2, 4}));
        System.out.println(l.sumSubarrayMins(new int[]{11, 81, 94, 43, 3}));
        System.out.println(l.sumSubarrayMins(new int[]{71, 55, 82, 55}));
    }

    public int sumSubarrayMins(int[] arr) {
        int MOD = 1_000_000_007;
        int N = arr.length;
        int[] nextSmaller = new int[N];
        int[] preSmaller = new int[N];
        Arrays.fill(nextSmaller, N);
        Arrays.fill(preSmaller, -1);
        Stack<Integer> minStack = new Stack<>();
        for (int i = 0; i < N; ++i) {
            while (!minStack.isEmpty() && arr[minStack.peek()] >= arr[i]) {
                nextSmaller[minStack.pop()] = i;
            }
            minStack.push(i);
        }
        minStack.clear();
        for (int i = N - 1; i >= 0; --i) {
            while (!minStack.isEmpty() && arr[minStack.peek()] > arr[i]) {
                preSmaller[minStack.pop()] = i;
            }
            minStack.push(i);
        }
        int ret = 0;
        for (int i = 0; i < N; ++i) {
            ret += ((long)arr[i] * (i - preSmaller[i]) * (nextSmaller[i] - i)) % MOD;
            ret %= MOD;
        }
        return ret;
    }


}
