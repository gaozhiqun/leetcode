package leetcode;


import java.util.HashMap;
import java.util.Map;

/**
 * @author zhiqungao@tencent.com
 * @date 2021/11/5 下午2:42
 */
public class Leetcode_209_minSubArrayLen {

    public static void main(String[] args) {
        Leetcode_209_minSubArrayLen l = new Leetcode_209_minSubArrayLen();
        System.out.println(l.minSubArrayLen(11, new int[]{1, 2, 3, 4, 5}));
        System.out.println(l.minSubArrayLen(4, new int[]{1, 2, 3, 4, 5}));
        System.out.println(l.minSubArrayLen(4, new int[]{1, 4, 4}));
        System.out.println(l.minSubArrayLen(7, new int[]{2, 3, 1, 2, 4, 3}));
        System.out.println(l.minSubArrayLen(11, new int[]{1, 1, 1, 1, 1, 1, 1, 1}));
    }

    public int minSubArrayLen(int target, int[] nums) {
        int l = 0, sum = 0, ans = 100_000_007;
        for (int r = 0; r < nums.length; r++) {
            sum += nums[r];
            while (sum >= target) {
                ans = Math.min(r - l + 1, ans);
                sum -= nums[l++];
            }
        }
        return ans == 100_000_007 ? 0 : ans;
    }


}