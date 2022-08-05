package leetcode;


/**
 * @author zhiqungao@tencent.com
 * @date 2021/10/29 下午6:14
 */
public class Leetcode_29_2divide {

    public static void main(String[] args) {
        Leetcode_29_2divide l = new Leetcode_29_2divide();
        System.out.println(l.divide(10, 3));
        /**
         * "mississippi"
         * "issi"
         */

    }

    /**
     * 快速除， c=a*b = Ck-1*a*(2^k-1) + Ck-2*a*(2^k-2)....+Ck-3*a*(2^0)
     *
     * @param dividend
     * @param divisor
     * @return
     */

    public int divide(int dividend, int divisor) {
        // 考虑被除数为最小值的情况
        if (dividend == Integer.MIN_VALUE) {
            if (divisor == 1) {
                return Integer.MIN_VALUE;
            }
            if (divisor == -1) {
                return Integer.MAX_VALUE;
            }
        }
        // 考虑除数为最小值的情况
        if (divisor == Integer.MIN_VALUE) {
            return dividend == Integer.MIN_VALUE ? 1 : 0;
        }
        // 考虑被除数为 0 的情况
        if (dividend == 0) {
            return 0;
        }
        boolean positive = dividend > 0 && divisor > 0 || dividend < 0 && divisor < 0;
        int a = dividend > 0 ? dividend : -dividend;
        int b = divisor > 0 ? divisor : -divisor;
        int ans = quickAdd(a, b);
        return positive ? ans : -ans;
    }

    public int quickAdd(int a, int b) {
        if (a < b) {
            return 0;
        }
        int count = 1;
        int tb = b;
        while (tb + tb <= a) {
            tb = tb + tb;
            count = count + count;
        }
        return count + quickAdd(a - tb, b);
    }

}

