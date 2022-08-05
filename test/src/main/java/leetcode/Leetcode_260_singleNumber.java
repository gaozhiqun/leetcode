package leetcode;

import java.util.Arrays;

/**
 * @author zhiqungao@tencent.com
 * @date 2021/11/17 下午8:25
 */
public class Leetcode_260_singleNumber {
    public static void main(String[] args) {
        Leetcode_260_singleNumber l = new Leetcode_260_singleNumber();

    }

    public int[] singleNumber(int[] nums) {
        int temp = nums[0];
        for (int i = 1; i < nums.length; ++i) {
            temp ^= nums[i];
        }
        int lsb = (temp == Integer.MIN_VALUE ? temp : temp & (-temp));
        int a = 0, b = 0;
        /**
         * x & -x 取出 xx 的二进制表示中最低位那个 11
         */
        for (int i : nums) {
            if ((i & lsb) != 0) {
                a ^= i;
            } else {
                b ^= i;
            }
        }
        return new int[]{a, b};
    }

}
