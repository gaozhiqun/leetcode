package leetcode;


/**
 * @author zhiqungao@tencent.com
 * @date 2021/10/29 下午2:37
 */
public class Leetcode_7_integerReverse {
    public static void main(String[] args) {
        Leetcode_7_integerReverse l = new Leetcode_7_integerReverse();
        System.out.println(l.reverse(-123));
        System.out.println(l.reverse(1534236469));

    }

    public int reverse(int x) {
        int p = x > 0 ? 1 : -1;
        int m = Math.abs(x);
        long ans = 0;
        while (m > 0) {
            ans *= 10;
            ans += m % 10;
            m /= 10;
        }
        if (ans > Integer.MAX_VALUE) {
            return 0;
        }
        return p * (int) ans;
    }
}
