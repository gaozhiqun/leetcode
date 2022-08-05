package leetcode;


import java.util.Arrays;

/**
 * @author zhiqungao@tencent.com
 * @date 2021/11/1 下午7:35
 */
public class Leetcode_75_sortColors {

    public static void main(String[] args) {
        Leetcode_75_sortColors l = new Leetcode_75_sortColors();
        int[] array = new int[]{2, 0, 2, 1, 1, 0};
        l.sortColors(array);
        System.out.println(array);


    }

    public void sortColors(int[] nums) {
        int l = 0, r = nums.length - 1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                while (l < nums.length && nums[l] == 0) {
                    ++l;
                }
                if (l < i) {
                    swap(i, l, nums);
                }
            }
        }
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 2) {
                while (r >= 0 && nums[r] == 2) {
                    --r;
                }
                if (i < r) {
                    swap(i, r, nums);
                }
            }
        }
    }

    private void swap(int i, int j, int[] nums) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
