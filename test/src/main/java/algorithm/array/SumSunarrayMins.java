package algorithm.array;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

/**
 * @author zhiqungao@tencent.com
 * @date 2021/10/19 上午10:43
 */
public class SumSunarrayMins {
    public static void main(String[] args) {
        SumSunarrayMins s = new SumSunarrayMins();
        System.out.println(s.sumsubarrayMins(new int[]{3, 1, 2, 4}));
    }

    /**
     * 子序列
     *
     * @param arr
     * @return
     */
    public int subSequenceMins(int[] arr) {
        int m = arr.length;
        long ans = 0;
        int mod = 100_000_007;
        Arrays.sort(arr);
        for (int i = 0; i < m; ++i) {
            ans += arr[i] * Math.pow(2, m - i - 1);
            ans %= mod;
        }
        return (int) ans;
    }

    public int sumsubarrayMins(int[] arr) {
        int m = arr.length;
        int ans = 0;
        int mod = 1_000_000_007;
        /**
         * 单调增栈
         */
        Deque<Integer> stackL = new ArrayDeque<>();
        Deque<Integer> stackR = new ArrayDeque<>();
        int[] prev = new int[m];//左边第一个比a[i]小的下标
        int[] next = new int[m];//右边第一个比a[i]小的下标
        //单调增栈，
        for (int i = 0; i < m; i++) {
            while (!stackL.isEmpty() && arr[i] <= arr[stackL.peekLast()]) {
                stackL.removeLast();
            }
            prev[i] = stackL.isEmpty() ? -1 : stackL.peekLast();
            stackL.addLast(i);
        }
        for (int i = m - 1; i >= 0; i--) {
            while (!stackR.isEmpty() && arr[i] < arr[stackR.peekLast()]) {
                stackR.removeLast();
            }
            next[i] = stackR.isEmpty() ? m : stackR.peekLast();
            stackR.addLast(i);
        }
        for (int i = 0; i < m; ++i) {
            ans += (long) (i - prev[i]) * (next[i] - i) * arr[i] % mod;
            ans %= mod;
        }
        return ans;
    }
}


