package leetcode;

/**
 * @author zhiqungao@tencent.com
 * @date 2022/1/28 下午4:11
 */
public class Leetcode_878_nthMagicNum {

    public static void main(String[] args) {
        Leetcode_878_nthMagicNum l = new Leetcode_878_nthMagicNum();
    }

    /**
     * 如果正整数可以被 A 或 B 整除，那么它是神奇的。
     *
     * @return
     */
    public int nthMagicalNumber(int n, int a, int b) {
        int MOD = 1_000_000_007;
        int L = a / gcd(a, b) * b;
        long lo = 0;
        long hi = (long) 1e15;
        while (lo < hi) {
            long mi = lo + (hi - lo) / 2;
            // If there are not enough magic numbers below mi...
            if (mi / a + mi / b - mi / L < n) {
                lo = mi + 1;
            } else {
                hi = mi;
            }
        }
        return (int) (lo % MOD);
    }

    public int gcd(int x, int y) {
        if (x == 0) {
            return y;
        }
        return gcd(y % x, x);
    }


}
