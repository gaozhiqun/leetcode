package leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * @author zhiqungao@tencent.com
 * @date 2022/3/29 上午10:29
 */
public class Leetcode_975_oddEvenJump {
    public static void main(String[] args) {
        Leetcode_975_oddEvenJump l = new Leetcode_975_oddEvenJump();
        System.out.println(l.maxTurbulenceSize(new int[]{9,4,2,10,7,8,8,1,9}));
        System.out.println(l.oddEvenJumps(new int[]{2, 3, 1, 1, 4}));
        System.out.println(l.oddEvenJumps(new int[]{10, 13, 12, 14, 15}));
        System.out.println(l.oddEvenJumps(new int[]{5, 1, 3, 4, 2}));
    }

    /**
     * 2 个不同的起始索引（i = 3, i = 4）出发，通过一定数量的跳跃到达数组末尾。
     * A[j] 是可能的最小值。
     */
    public int oddEvenJumps(int[] arr) {
        int N = arr.length;
        int[] nextBigger = new int[N + 1];
        Arrays.fill(nextBigger, N);
        int[] nextSmaller = new int[N + 1];
        Arrays.fill(nextSmaller, N);
        Stack<Integer> stack = new Stack<>();

        Integer[] idxI = new Integer[N];
        Integer[] idxD = new Integer[N];
        for (int i = 0; i < N; i++) {
            idxI[i] = idxD[i] = i;
        }
        Arrays.sort(idxI, (i1, i2) -> {
            if (arr[i1] - arr[i2] != 0) {
                return arr[i1] - arr[i2];
            } else {
                return i1 - i2;
            }
        });//单调增
        Arrays.sort(idxD, (i1, i2) -> {
            if (arr[i1] - arr[i2] != 0) {
                return -arr[i1] + arr[i2];
            } else {
                return i1 - i2;
            }
        });//单调减

        boolean[] oddJump = new boolean[N + 1];//奇数跳 nextBigger A[i]<=A[j];
        boolean[] evenJump = new boolean[N + 1];//偶数跳 nextSmaller A[i]>=A[j];
        evenJump[N - 1] = true;
        oddJump[N - 1] = true;
        for (int i = 0; i < N; ++i) {
            int idx = idxI[i];//单调增
            while (!stack.isEmpty() && arr[stack.peek()] <= arr[idx]) {
                nextBigger[stack.pop()] = idx;
            }
            stack.push(idx);
        }
        stack.clear();
        for (int i = 0; i < N; ++i) {
            int idx = idxI[i];//单调减
            while (!stack.isEmpty() && arr[stack.peek()] >= arr[idx]) {
                nextSmaller[stack.pop()] = idx;
            }
            stack.push(idx);
        }
        int ret = 0;
        for (int i = N - 2; i >= 0; --i) {
            oddJump[i] = evenJump[nextBigger[i]];
            evenJump[i] = oddJump[nextSmaller[i]];
            if (oddJump[i]) {
                ++ret;
            }
        }
        return ret + 1;
    }


    public int largestPerimeter(int[] nums) {
        Arrays.sort(nums);
        int N = nums.length;
        for (int i = N - 1; i >= 3; --i) {
            if (nums[i - 1] + nums[i - 2] > nums[i]) {
                return nums[i - 1] + nums[i - 2] + nums[i];
            }
        }
        return 0;
    }


    public int[] sortedSquares(int[] nums) {
        int N = nums.length;
        int[] ret = new int[N];
        int i = 0;
        int r = 0;
        while (r < N && nums[r] < 0) {
            ++r;
        }
        int l = r - 1;
        while (l >= 0 && r < N) {
            if (nums[l] * nums[l] > nums[r] * nums[r]) {
                ret[i++] = nums[r] * nums[r];
                ++r;
            } else {
                ret[i++] = nums[l] * nums[l];
                --l;
            }
        }
        while (l >= 0) {
            ret[i++] = nums[l] * nums[l];
            --l;
        }
        while (r < N) {
            ret[i++] = nums[r] * nums[r];
            ++r;
        }
        return ret;
    }


    public int maxTurbulenceSize(int[] arr) {
        int N = arr.length;
        int[] ups = new int[N];
        Arrays.fill(ups, 1);
        int[] downs = new int[N];
        Arrays.fill(downs, 1);
        int ret = 1;
        for (int i = N - 2; i >= 0; --i) {
            if (arr[i] < arr[i + 1]) {
                ups[i] = downs[i + 1] + 1;
                ret = Math.max(ret, ups[i]);
            } else if (arr[i] > arr[i + 1]) {
                downs[i] = ups[i + 1] + 1;
                ret = Math.max(ret, downs[i]);
            }
        }
        return ret;
    }

    /**
     * 若 i <= k < j ：
     * 当 k 为奇数时， A[k] > A[k+1]，且
     * 当 k 为偶数时，A[k] < A[k+1]；
     * 或 若 i <= k < j ：
     * 当 k 为偶数时，A[k] > A[k+1] ，且
     * 当 k 为奇数时， A[k] < A[k+1]。
     */

}
