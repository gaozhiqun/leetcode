package leetcode;

import java.util.*;

/**
 * @author zhiqungao@tencent.com
 * @date 2021/12/2 下午9:11
 */
public class Leetcode_334_increasingTriplet {
    public static void main(String[] args) {
        Leetcode_334_increasingTriplet l = new Leetcode_334_increasingTriplet();
        System.out.println(l.increasingTriplet(new int[]{
                5, 1, 6
        }));
        System.out.println(l.increasingTriplet(new int[]{
                20, 100, 10, 12, 5, 13
        }));
        System.out.println(l.increasingTriplet(new int[]{
                5, 4, 3, 2, 1
        }));
        System.out.println(l.increasingTriplet(new int[]{
                1, 2, 3, 4, 5
        }));
    }

    public boolean increasingTriplet(int[] nums) {
        int m = nums.length;
        if (m < 3) {
            return false;
        }
        int[] lmins = new int[m];
        int[] rmaxs = new int[m];
        lmins[0] = Integer.MAX_VALUE;
        rmaxs[m - 1] = Integer.MIN_VALUE;
        for (int i = 1; i < m; ++i) {
            lmins[i] = Math.min(lmins[i - 1], nums[i - 1]);
            rmaxs[m - 1 - i] = Math.max(rmaxs[m - i], nums[m - i]);
        }
        for (int i = 1; i < m; i++) {
            if (lmins[i] < nums[i] && nums[i] < rmaxs[i]) {
                return true;
            }
        }
        return false;
    }

}
