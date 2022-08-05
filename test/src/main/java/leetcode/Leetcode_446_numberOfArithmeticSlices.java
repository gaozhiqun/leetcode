package leetcode;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author zhiqungao@tencent.com
 * @date 2021/12/14 上午10:48
 */
public class Leetcode_446_numberOfArithmeticSlices {
    public static void main(String[] args) {
        Leetcode_446_numberOfArithmeticSlices l = new Leetcode_446_numberOfArithmeticSlices();
        System.out.println(l.numberOfArithmeticSlices(new int[]{2, 4, 6, 8, 10}));
        System.out.println(l.numberOfArithmeticSlices(new int[]{7, 7, 7, 7, 7}));
    }

    /**
     * 至少有三个元素 ，并且任意两个相邻元素之差相同
     * 等差子序列
     */


    public int numberOfArithmeticSlices(int[] nums) {
        int ans = 0;
        int m = nums.length;
        Map<Long, Integer>[] f = new Map[m];
        for (int i = 0; i < m; ++i) {
            f[i] = new HashMap<Long, Integer>();
            for (int j = 0; j < i; ++j) {
                long d = 1L * nums[i] - nums[j];
                int cnt = f[j].getOrDefault(d, 0);
                ans += cnt;
                f[i].put(d, f[i].getOrDefault(d, 0) + cnt + 1);
            }
        }
        return ans;
    }


}
