package leetcode;


import java.util.Arrays;
import java.util.StringJoiner;

/**
 * @author zhiqungao@tencent.com
 * @date 2021/11/5 下午2:42
 */
public class Leetcode_189_rotateArray {

    public static void main(String[] args) {
        Leetcode_189_rotateArray l = new Leetcode_189_rotateArray();
        int[] array = new int[]{1, 2, 3, 4, 5, 6, 7};
        l.rotate(array, 3);
        System.out.println(Arrays.asList(array));
    }

    public void rotate(int[] nums, int k) {
        int m = nums.length;
        k = k % m;
        if (k > 0) {
            int[] temp = new int[k];
            System.arraycopy(nums, m - k, temp, 0, k);
            System.arraycopy(nums, 0, nums, k, m - k);
            System.arraycopy(temp, 0, nums, 0, k);
        }
    }


}