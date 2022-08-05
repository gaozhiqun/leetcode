package leetcode;

import java.util.*;

/**
 * @author zhiqungao@tencent.com
 * @date 2021/11/17 下午8:25
 */
public class Leetcode_719_smallestDistancePair {

    public static void main(String[] args) {
        Leetcode_719_smallestDistancePair l = new Leetcode_719_smallestDistancePair();
    }


    public int smallestDistancePair(int[] nums, int k) {
        Arrays.sort(nums);
        int l = 0, r = nums[nums.length - 1] - nums[0];
        while (l < r) {
            int mid = l + (r - l) / 2;
            int cnt = getCnt(nums, mid);
            if (cnt < k) {
                l = mid + 1;
            } else {
                r = mid;
            }
        }
        return l;
    }

    private int getCnt(int[] nums, int k) {
        int cnt = 0, l = 0;
        for (int r = 0; r < nums.length; ++r) {
            while (nums[r] - nums[l] > k) {
                l++;
            }
            cnt += r - l;
        }
        return cnt;
    }




}