package leetcode;


import java.util.Stack;

/**
 * @author zhiqungao@tencent.com
 * @date 2021/11/1 下午7:35
 */
public class Leetcode_32_searchRotateArray {

    public static void main(String[] args) {
        Leetcode_32_searchRotateArray l = new Leetcode_32_searchRotateArray();
        System.out.println(l.search(new int[]{3, 1}, 1));
        System.out.println(l.search(new int[]{4, 5, 6, 7, 0, 1, 2}, 0));
        System.out.println(l.search(new int[]{4, 5, 6, 7, 0, 1, 2}, 3));
        System.out.println(l.search(new int[]{1}, 0));

    }

    /**
     * 注意边界问题！！！
     * @param nums
     * @param target
     * @return
     */

    public int search(int[] nums, int target) {
        int l = 0, r = nums.length - 1;
        /**
         * 4,5,6,7,0,1,2
         */
        while (l <= r) {
            int mid = l + (r - l) / 2;
            //1 mid/target 都在小端/大端
            //2 mid 在大端 target 在小端 l=mid+1
            //3 mid 在小端，target 在大端 r=mid-1
            if (target == nums[mid]) {
                return mid;
            } else if (target <= nums[r] && target < nums[l]
                    && nums[mid] >= nums[l] && nums[mid] > nums[r]) {
                l = mid + 1;
            } else if (target > nums[r] && target >= nums[l]
                    && nums[mid] < nums[l] && nums[mid] <= nums[r]) {
                r = mid - 1;
            } else {
                if (target > nums[mid]) {
                    l = mid + 1;
                } else {
                    r = mid - 1;
                }
            }
        }
        return -1;
    }


}
