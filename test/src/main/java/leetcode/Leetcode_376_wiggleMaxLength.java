package leetcode;

import java.util.Arrays;

/**
 * @author zhiqungao@tencent.com
 * @date 2021/12/6 下午8:18
 */
public class Leetcode_376_wiggleMaxLength {
    public static void main(String[] args) {
        Leetcode_376_wiggleMaxLength l = new Leetcode_376_wiggleMaxLength();
        System.out.println(l.wiggleMaxLength(new int[]{1, 7, 4, 9, 2, 5}));

    }


    public int wiggleMaxLength(int[] nums) {
        int m = nums.length;
        if (m == 0) {
            return 0;
        }
        int[] ups = new int[m];
        int[] downs = new int[m];
        ups[0] = 1;
        downs[0] = 1;
        for (int i = 1; i < m; ++i) {
            if (nums[i] < nums[i - 1]) {
                downs[i] = Math.max(downs[i], ups[i - 1] + 1);
                ups[i] = ups[i - 1];
            } else if (nums[i] > nums[i - 1]) {
                ups[i] = Math.max(ups[i], downs[i - 1] + 1);
                downs[i] = downs[i - 1];
            } else {
                ups[i] = ups[i - 1];
                downs[i] = downs[i - 1];
            }
        }
        return Math.max(ups[m - 1], downs[m - 1]);

    }
}



