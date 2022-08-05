package leetcode;


import java.util.*;

/**
 * @author zhiqungao@tencent.com
 * @date 2021/12/14 上午10:48
 */
public class Leetcode_526_countArrangement {


    public static void main(String[] args) {
        Leetcode_526_countArrangement l = new Leetcode_526_countArrangement();
    }

    /**
     * perm[i] 能够被 i 整除
     * i 能够被 perm[i] 整除
     */

    public int countArrangement(int n) {
        int[] f = new int[1 << n];
        f[0] = 1;
        for (int mask = 1; mask < (1 << n); mask++) {
            int pos = Integer.bitCount(mask);
            for (int i = 0; i < n; i++) {
                if ((mask & (1 << i)) != 0 && pos % (i + 1) == 0 || (i + 1) % pos == 0) {
                    f[mask] += f[mask ^ (1 << i)];
                }
            }
        }
        return f[(1 << n) - 1];
    }

    /**
     * 找到含有相同数量的 0 和 1 的
     *
     * @param nums
     * @return
     */
    public int findMaxLength(int[] nums) {
        Map<Integer, Integer> cnt = new HashMap<>();
        cnt.put(0, -1);
        int zeroCnt = 0, ans = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                zeroCnt++;
            } else {
                zeroCnt--;
            }
            if (cnt.containsKey(zeroCnt)) {
                ans = Math.max(ans, i - cnt.get(zeroCnt));
            } else {
                cnt.put(zeroCnt, i);
            }
        }
        return ans;
    }

}