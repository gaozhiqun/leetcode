package leetcode;


import java.util.Arrays;

/**
 * @author zhiqungao@tencent.com
 * @date 2021/11/1 下午7:35
 */
public class Leetcode_35_searchInsertPos {

    public static void main(String[] args) {
        Leetcode_35_searchInsertPos l = new Leetcode_35_searchInsertPos();
        int ans = l.searchInsert(new int[]{1, 3, 5, 6}, 5);
        System.out.println(ans);
        ans = l.searchInsert(new int[]{1, 3, 5, 6}, 2);
        System.out.println(ans);
        ans = l.searchInsert(new int[]{1, 3, 5, 6}, 7);
        System.out.println(ans);
        ans = l.searchInsert(new int[]{1, 3, 5, 6}, 0);
        System.out.println(ans);
        ans = l.searchInsert(new int[]{1}, 0);
        System.out.println(ans);
    }

    /**
     * 注意边界问题！！！
     * 第一个不小于target的值
     *
     * @param nums
     * @param target
     * @return
     */

    public int searchInsert(int[] nums, int target) {
        if (nums.length == 0 || target < nums[0]) {
            return 0;
        } else if (target > nums[nums.length - 1]) {
            return nums.length;
        }
        int l = 0, ans = nums.length, r = nums.length - 1;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (nums[mid] < target) {
                l = mid + 1;
            } else {
                r = mid - 1;
                ans = mid;
            }
        }
        return ans;
    }
}
