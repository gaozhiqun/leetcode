package leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author zhiqungao@tencent.com
 * @date 2022/1/13 下午5:35
 */
public class Leetcode_761_countPrimeSetBits {
    public static void main(String[] args) {
        Leetcode_761_countPrimeSetBits l = new Leetcode_761_countPrimeSetBits();
    }

    /**
     * 1 的位数为质数
     *
     * @param L
     * @param R
     * @return
     */
    public int countPrimeSetBits(int L, int R) {
        int ans = 0;
        for (int x = L; x <= R; ++x) {
            if (isSmallPrime(Integer.bitCount(x))) {
                ans++;
            }
        }
        return ans;
    }

    private boolean isSmallPrime(int x) {
        return (x == 2 || x == 3 || x == 5 || x == 7 ||
                x == 11 || x == 13 || x == 17 || x == 19);
    }
}
