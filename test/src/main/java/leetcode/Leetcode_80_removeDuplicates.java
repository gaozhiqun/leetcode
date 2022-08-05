package leetcode;


/**
 * @author zhiqungao@tencent.com
 * @date 2021/11/1 下午7:35
 */
public class Leetcode_80_removeDuplicates {

    public static void main(String[] args) {
        Leetcode_80_removeDuplicates l = new Leetcode_80_removeDuplicates();
        System.out.println(l.removeDuplicates(new int[]{1, 1, 1, 2, 2, 2, 3, 3}));
        System.out.println(l.removeDuplicates(new int[]{0, 0, 1, 1, 1, 1, 2, 3, 3}));
        System.out.println(l.removeDuplicates(new int[]{1, 1, 1, 2, 2, 3}));
    }

    public int removeDuplicates(int[] nums) {
        if (nums.length < 3) {
            return nums.length;
        }
        int cnt = 1, cur = nums[0], l = 0, r = nums.length;
        while (l < r && l < nums.length - 1) {
            ++l;
            if (nums[l] == cur) {
                ++cnt;
            }
            if (nums[l] != cur || l == r - 1) {
                if (cnt > 2) {
                    System.arraycopy(nums, l, nums, l - cnt + 2, nums.length - l);
                    r -= (cnt - 2);
                    l -= (cnt - 2);
                }
                cnt = 1;
                cur = nums[l];
            }
        }
        return r;
    }

    public int removeDuplicates2(int[] nums) {
        if (nums.length < 3) {
            return nums.length;
        }
        int slow = 2, fast = 2;
        while (fast < nums.length) {
            if (nums[slow - 2] != nums[fast]) {
                nums[slow++] = nums[fast];
            }
            ++fast;
        }
        return slow;
    }

}
