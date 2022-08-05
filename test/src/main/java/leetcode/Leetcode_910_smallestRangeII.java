package leetcode;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;


public class Leetcode_910_smallestRangeII {
    public static void main(String[] args) {
        Leetcode_910_smallestRangeII l = new Leetcode_910_smallestRangeII();

    }

    public int smallestRangeII(int[] nums, int k) {
        int N = nums.length;
        Arrays.sort(nums);
        int ans = nums[N - 1] - nums[0];

        for (int i = 0; i < nums.length - 1; ++i) {
            int a = nums[i], b = nums[i + 1];
            int high = Math.max(nums[N - 1] - k, a + k);
            int low = Math.min(nums[0] + k, b - k);
            ans = Math.min(ans, high - low);
        }
        return ans;
    }

}
