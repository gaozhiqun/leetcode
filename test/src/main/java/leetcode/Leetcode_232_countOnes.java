package leetcode;

/**
 * @author zhiqungao@tencent.com
 * @date 2021/11/17 下午4:53
 */
public class Leetcode_232_countOnes {
    public static void main(String[] args) {

    }

    /**
     * <=n 的1 出现的次数
     *
     * @param n
     * @return
     */
    public int countDigitOne(int n) {
        long mulk = 1;
        int ans = 0;
        for (int k = 0; n >= mulk; ++k) {
            ans += (n / (mulk * 10)) * mulk + Math.min(Math.max(n % (mulk * 10) - mulk + 1, 0), mulk);
            mulk *= 10;
        }
        return ans;
    }
}
