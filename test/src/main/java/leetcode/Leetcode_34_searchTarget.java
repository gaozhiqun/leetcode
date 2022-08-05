package leetcode;


import java.util.Arrays;

/**
 * @author zhiqungao@tencent.com
 * @date 2021/11/1 下午7:35
 */
public class Leetcode_34_searchTarget {

    public static void main(String[] args) {
        Leetcode_34_searchTarget l = new Leetcode_34_searchTarget();
        System.out.println(Arrays.toString(l.searchRange(new int[]{5, 7, 7, 8, 8, 10}, 8)));
        System.out.println(Arrays.toString(l.searchRange(new int[]{1}, 1)));
        int[] ans = l.searchRange(new int[]{2, 2}, 1);
        System.out.println(Arrays.toString(ans));

    }

    /**
     * 注意边界问题！！！
     *
     * @param nums
     * @param target
     * @return
     */

    public int[] searchRange(int[] nums, int target) {
        if (nums.length == 0) {
            return new int[]{-1, -1};
        }
        int l = binarySearch(nums, target, true);
        int r = binarySearch(nums, target, false) - 1;
        if (l <= r && r < nums.length && nums[l] == target && nums[r] == target) {
            return new int[]{l, r};
        }
        return new int[]{-1, -1};

    }

    public int binarySearch(int[] nums, int target, boolean lower) {
        int l = 0, r = nums.length - 1;
        int ans = nums.length;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (nums[mid] > target || lower && nums[mid] >= target) { //第一个比他小
                r = mid - 1;
                ans = mid;
            } else {
                l = mid + 1;
            }
        }
        return ans;
    }

}
