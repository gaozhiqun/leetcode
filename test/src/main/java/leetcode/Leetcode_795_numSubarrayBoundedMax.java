package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zhiqungao@tencent.com
 * @date 2022/1/17 上午10:53
 */
public class Leetcode_795_numSubarrayBoundedMax {
    public static void main(String[] args) {
        Leetcode_795_numSubarrayBoundedMax l = new Leetcode_795_numSubarrayBoundedMax();
        System.out.println(l.numSubarrayBoundedMax(new int[]{2, 9, 2, 5, 6}, 2, 8));
        System.out.println(l.numSubarrayBoundedMax(new int[]{2, 1, 4, 3}, 2, 3));
    }

    /**
     * [left, right]
     *
     * @param nums
     * @param left
     * @param right
     * @return
     */
    public int numSubarrayBoundedMax(int[] nums, int left, int right) {
        return count(nums, right) - count(nums, left - 1);
    }

    private int count(int[] nums, int bound) {
        int ans = 0, cur = 0;
        for (int x : nums) {
            cur = x <= bound ? cur + 1 : 0;
            ans += cur;
        }
        return ans;
    }


}
