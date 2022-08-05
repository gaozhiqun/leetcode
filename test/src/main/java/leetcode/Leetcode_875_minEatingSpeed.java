package leetcode;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @author zhiqungao@tencent.com
 * @date 2022/1/28 下午4:11
 */
public class Leetcode_875_minEatingSpeed {

    public static void main(String[] args) {
        Leetcode_875_minEatingSpeed l = new Leetcode_875_minEatingSpeed();
    }


    /**
     * H 小时内吃掉所有香蕉的最小速度 K
     */
    public int minEatingSpeed(int[] piles, int h) {
        int N = piles.length;
        if (N > h) {
            return -1;
        }
        int l = 1, r = 1_000_000_000;
        while (l < r) {
            int mid = l + (r - l) / 2;
            int m = getHour(piles, mid);
            if (m > h) {
                l = mid + 1;
            } else {
                r = mid;
            }
        }
        return l;
    }

    private int getHour(int[] piles, int k) {
        int ret = 0;
        for (int i : piles) {
            ret += i % k == 0 ? i / k : i / k + 1;
        }
        return ret;
    }



}
