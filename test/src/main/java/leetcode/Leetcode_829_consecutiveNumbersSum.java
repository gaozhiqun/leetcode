package leetcode;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author zhiqungao@tencent.com
 * @date 2021/11/17 下午8:25
 */
public class Leetcode_829_consecutiveNumbersSum {

    public static void main(String[] args) {
        Leetcode_829_consecutiveNumbersSum l = new Leetcode_829_consecutiveNumbersSum();
//        System.out.println(l.largestIsland(new int[][]{{1, 1}, {1, 1}}));
    }

    /**
     * 分别统计每个字符组成的字符串
     *
     * @param s
     * @return
     */
    /**
     * 在 2N = k(2x + k + 1)2N=k(2x+k+1) 中，我们可以发现 k < 2x + k + 1k<2x+k+1，因此有 k < \sqrt{2N}k<
     * 2N
     * ​
     *  ，即我们只需要枚举 1 \leq k \leq \lfloor \sqrt{2N} \rfloor1≤k≤⌊
     * 2N
     * ​
     *  ⌋ 即可，此时通过枚举可以通过本题。
     *
     * @param N
     * @return
     */
    public int consecutiveNumbersSum(int N) {
        while ((N & 1) == 0) N >>= 1;
        int ans = 1, d = 3;

        while (d * d <= N) {
            int e = 0;
            while (N % d == 0) {
                N /= d;
                e++;
            }
            ans *= e + 1;
            d += 2;
        }

        if (N > 1) ans <<= 1;
        return ans;
    }
}