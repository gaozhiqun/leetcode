package algorithm.sort;

import java.util.Arrays;

/**
 * @author zhiqungao@tencent.com
 * @date 2021/9/7 下午3:20
 */
public class SmallestDistancePair {
    public static void main(String[] args) {

    }

    public int smallestDistancePair(int[] nums, int k) {
        Arrays.sort(nums);
        int l = 0, r = nums.length - 1;
        int min = 0, max = nums[r] - nums[l];
        while (min <= max) {
            int mid = min + (max - min) / 2;
            if (getCount(nums, mid) >= k) {
                max = mid;
            } else {
                min = mid + 1;
            }
        }
        return min;
    }


    private int getCount(int[] nums, int interval) {
        int result = 0;
        for (int i = 0; i < nums.length; i++) {
            result += Arrays.binarySearch(nums, nums[i] + interval) - i;
        }
        return result;
    }


}
