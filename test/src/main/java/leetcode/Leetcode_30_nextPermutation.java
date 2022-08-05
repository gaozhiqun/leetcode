package leetcode;

import java.util.*;

/**
 * @author zhiqungao@tencent.com
 * @date 2021/11/1 下午7:35
 */
public class Leetcode_30_nextPermutation {

    public static void main(String[] args) {
        Leetcode_30_nextPermutation l = new Leetcode_30_nextPermutation();
        int[] array = new int[]{3, 2, 1};
        l.nextPermutation(array);
        System.out.println(Arrays.toString(array));
        array = new int[]{1, 1, 5};
        l.nextPermutation(array);
        System.out.println(Arrays.toString(array));
        array = new int[]{1, 1, 5, 4, 3, 2, 1};
        l.nextPermutation(array);
        System.out.println(Arrays.toString(array));
    }

    /**
     * 下一个排列 5/4/3/2/1
     *
     * @param nums
     */
    public void nextPermutation(int[] nums) {
        for (int i = nums.length - 2; i >= 0; --i) {
            int min = i;
            for (int j = i + 1; j < nums.length; ++j) {
                if (nums[j] > nums[i]) {
                    if (min == i || nums[min] > nums[j]) {
                        min = j;
                    }
                }
            }
            if (min > i) {
                swap(nums, min, i);
                Arrays.sort(nums, i + 1, nums.length);
                return;
            }

        }
        int l = 0, r = nums.length - 1;
        while (l < r) {
            swap(nums, l++, r--);
        }
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }


}
