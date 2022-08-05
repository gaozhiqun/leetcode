package leetcode;


import java.util.ArrayList;
import java.util.List;

/**
 * @author zhiqungao@tencent.com
 * @date 2021/11/1 下午7:35
 */
public class Leetcode_41_firstMissingPositive {

    public static void main(String[] args) {
        Leetcode_41_firstMissingPositive l = new Leetcode_41_firstMissingPositive();
        // System.out.println(l.combinationSum(new int[]{2, 3, 6, 7}, 7));
        // System.out.println(l.combinationSum(new int[]{2, 3, 6, 7}, 7));
        System.out.println(l.firstMissingPositive(new int[]{1, 1}));
        System.out.println(l.firstMissingPositive(new int[]{-1, 4, 2, 1, 9, 10}));
        System.out.println(l.firstMissingPositive(new int[]{7, 8, 9, 11, 12}));
        System.out.println(l.firstMissingPositive(new int[]{3, 4, -1, 1}));
    }

    public int firstMissingPositive(int[] nums) {
        int m = nums.length;
        for (int i = 0; i < nums.length; i++) {
            int cur = nums[i];
            while (cur > 0 && cur <= m && cur - 1 != i && nums[cur - 1] != nums[i]) {
                swap(cur - 1, i, nums);
                cur = nums[i];
            }
        }
        for (int i = 0; i < nums.length; ++i) {
            if (nums[i] != (i + 1)) {
                return i + 1;
            }
        }
        return m + 1;
    }

    private void swap(int i, int j, int[] nums) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

}
