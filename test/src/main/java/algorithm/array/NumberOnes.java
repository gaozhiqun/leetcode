package algorithm.array;

/**
 * @author zhiqungao@tencent.com
 * @date 2021/4/27 4:08 下午
 */
public class NumberOnes {
    public static void main(String[] args) {

    }

    /**
     * 第N位1出现的次数
     */

    public int countDigitOne(int n) {
        int countr = 0;
        for (long i = 1; i <= n; i *= 10) {
            long divider = i * 10;
            countr += (n / divider) * i + Math.min(Math.max(n % divider - i + 1, 0L), i);
        }
        return countr;
    }


}
