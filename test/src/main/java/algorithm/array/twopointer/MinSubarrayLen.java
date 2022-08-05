package algorithm.array.twopointer;

/**
 * @author zhiqungao@tencent.com
 * @date 2021/10/28 上午11:01
 */
public class MinSubarrayLen {
    public static void main(String[] args) {
        MinSubarrayLen minSubarrayLen = new MinSubarrayLen();
        System.out.println(minSubarrayLen.minSubarrayLen(7,
                new int[]{2, 3, 1, 2, 4, 3}));
    }

    /**
     * leetcode 209 长度最小的子数组
     *
     * @param target
     * @param nums
     * @return
     */
    public int minSubarrayLen(int target, int[] nums) {
        int N = nums.length;
        if (N == 0) {
            return 0;
        }
        int sum = 0;
        int l = 0, r = 0, ans = Integer.MAX_VALUE;
        while (r < N) {
            sum += nums[r];
            while (sum >= target && l <= r) {
                ans = Math.min(ans, r - l + 1);
                sum -= nums[l];
                l++;
            }
            r++;
        }
        return ans == Integer.MAX_VALUE ? 0 : ans;
    }
}
