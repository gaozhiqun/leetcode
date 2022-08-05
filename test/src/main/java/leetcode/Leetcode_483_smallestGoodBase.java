package leetcode;

/**
 * @author zhiqungao@tencent.com
 * @date 2021/12/14 上午10:48
 */
public class Leetcode_483_smallestGoodBase {

    public static void main(String[] args) {
        Leetcode_483_smallestGoodBase l = new Leetcode_483_smallestGoodBase();

    }


    /**
     * 对于给定的整数 n, 如果n的k（k>=2）进制数的所有数位全为1，则称 k（k>=2）是 n 的一个好进制。
     * 以字符串的形式给出 n, 以字符串的形式返回 n 的最小好进制。
     *
     * @param n
     * @return
     */

    public String smallestGoodBase(String n) {
        long nVal = Long.parseLong(n);
        int mMax = (int) Math.floor(Math.log(nVal) / Math.log(2));
        for (int m = mMax; m > 1; m--) {
            int k = (int) Math.pow(nVal, 1.0 / m);
            long mul = 1, sum = 1;
            for (int i = 0; i < m; i++) {
                mul *= k;
                sum += mul;
            }
            if (sum == nVal) {
                return Integer.toString(k);
            }
        }
        return Long.toString(nVal - 1);

    }


}
