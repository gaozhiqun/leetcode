package algorithm.dp;

import java.util.Arrays;
import java.util.Stack;

/**
 * @author zhiqungao@tencent.com
 * @date 2021/10/25 下午8:14
 */
public class OddEvenJumps {
    public static void main(String[] args) {
        OddEvenJumps oddEvenJumps = new OddEvenJumps();
        System.out.println(oddEvenJumps.oddEventJumps(new int[]{10, 13, 12, 14, 15}));
        System.out.println(oddEvenJumps.oddEventJumps(new int[]{2, 3, 1, 1, 4}));
        System.out.println(oddEvenJumps.oddEventJumps(new int[]{5, 1, 3, 4, 2}));
    }

    public int oddEventJumps(int[] arr) {
        int m = arr.length;
        int[] oddJumps = new int[m];
        int[] eventJumps = new int[m];
        Arrays.fill(oddJumps, -1);
        Arrays.fill(eventJumps, -1);
        oddJumps[m - 1] = 0; //下一个最小
        eventJumps[m - 1] = 0; //下一个更大
        Stack<Integer> increaseStack = new Stack<>();
        Stack<Integer> decreaseStack = new Stack<>();
        for (int i = 0; i < m; ++i) {
            while (!increaseStack.isEmpty() && arr[increaseStack.peek()] <= arr[i]) {
                eventJumps[increaseStack.pop()] = i;
            }
            while (!decreaseStack.isEmpty() && arr[decreaseStack.peek()] >= arr[i]) {
                oddJumps[decreaseStack.pop()] = i;
            }
            increaseStack.push(i);
            decreaseStack.push(i);
        }
        boolean[] odd = new boolean[m];
        boolean[] even = new boolean[m];
        for (int i = m - 1; i >= 0; --i) {
            if (i == m - 1) {
                odd[i] = true;
                even[i] = true;
            }
            if (oddJumps[i] > 0) {
                even[i] = odd[oddJumps[i]];
            }
            if (eventJumps[i] > 0) {
                odd[i] = even[eventJumps[i]];
            }
        }

        int ans = 0;
        for (boolean n : odd) {
            if (n) {
                ++ans;
            }
        }
        return ans;
    }

}
