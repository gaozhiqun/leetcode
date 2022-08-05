package leetcode;

import java.util.Arrays;

/**
 * @author zhiqungao@tencent.com
 * @date 2022/3/24 上午10:27
 */
public class Leetcode_945_minIncrementForUnique {

    public static void main(String[] args) {
        Leetcode_945_minIncrementForUnique l = new Leetcode_945_minIncrementForUnique();
        System.out.println(l.minIncrementForUnique(new int[]{3, 2, 1, 2, 1, 7}));
    }

    public int minIncrementForUnique(int[] nums) {
        Arrays.sort(nums);
        int max = nums[0];
        int ret = 0;
        for (int i = 1; i < nums.length; ++i) {
            if (nums[i] > max) {
                max = nums[i];
            } else {
                max++;
                ret += (max - nums[i]);
            }
        }
        return ret;
    }
}
