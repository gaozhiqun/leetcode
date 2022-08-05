package leetcode;


/**
 * @author zhiqungao@tencent.com
 * @date 2021/11/5 下午2:42
 */
public class Leetcode_152_findMin {

    public static void main(String[] args) {
        Leetcode_152_findMin l = new Leetcode_152_findMin();
        System.out.println(l.findMin(new int[]{2, 1}));
        System.out.println(l.findMin(new int[]{2, 3, 4, 5, 1}));
        System.out.println(l.findMin(new int[]{4, 5, 6, 7, 0, 1, 2}));
        System.out.println(l.findMin(new int[]{0, 1, 2, 4, 5, 6, 7}));
        System.out.println(l.findMin(new int[]{4, 5, 6, 7, 0, 1, 2}));
        System.out.println(l.findMin(new int[]{11, 13, 15, 17}));
        System.out.println(l.findMin(new int[]{17, 11, 13, 15}));
    }

    /**
     * [4,5,6,7,0,1,2]
     *
     * @param nums
     * @return
     */
    public int findMin(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }
        return helper(nums, 0, nums.length - 1);
    }

    private int helper(int[] nums, int l, int r) {
        if (l == r) {
            return nums[l];
        }
        int m = nums.length;
        int mid = l + (r - l) / 2;
        if (nums[mid] < nums[(mid + 1) % m]
                && nums[mid] < nums[(m + mid - 1) % m]) {
            return nums[mid];
        } else if (nums[mid] > nums[(mid + 1) % m]
                && nums[mid] > nums[(m + mid - 1) % m]) {
            return nums[(mid + 1) % m];
        }
        if (nums[mid] > nums[l] && nums[mid] > nums[r]) {
            return helper(nums, mid + 1, r);
        } else {
            return helper(nums, l, mid - 1);
        }
    }


    public int findMinWithRepeatable(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }
        int l = 0, r = nums.length - 1;
        while (l < r) {
            int mid = l + (r - l) / 2;
            if (nums[mid] < nums[r]) {
                r = mid;
            } else if (nums[mid] > nums[r]) {
                l = mid + 1;
            } else {
                r--;
            }
        }
        return nums[l];
    }


    /**
     * --
     * --
     * -
     * -
     * -
     * --
     * -
     * --
     * ----
     * <p>
     * <p>
     * ------------------------------------
     */

    public int findPeakElement(int[] nums) {
        int n = nums.length;
        int left = 0, right = n - 1, ans = -1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (compare(nums, mid - 1, mid) < 0 && compare(nums, mid, mid + 1) > 0) {
                ans = mid;
                break;
            }
            if (compare(nums, mid, mid + 1) < 0) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return ans;
    }

    // 辅助函数，输入下标 i，返回一个二元组 (0/1, nums[i])
    // 方便处理 nums[-1] 以及 nums[n] 的边界情况
    public int[] get(int[] nums, int idx) {
        if (idx == -1 || idx == nums.length) {
            return new int[]{0, 0};
        }
        return new int[]{1, nums[idx]};
    }

    public int compare(int[] nums, int idx1, int idx2) {
        int[] num1 = get(nums, idx1);
        int[] num2 = get(nums, idx2);
        if (num1[0] != num2[0]) {
            return num1[0] > num2[0] ? 1 : -1;
        }
        if (num1[1] == num2[1]) {
            return 0;
        }
        return num1[1] > num2[1] ? 1 : -1;
    }

}