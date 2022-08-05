package algorithm;

import java.util.Arrays;

/**
 * @author zhiqungao@tencent.com
 * @date 2021/3/5 7:03 下午
 */
public class BitCounter {
    public static void main(String[] args) {
        BitCounter bitCounter = new BitCounter();
        // System.out.println(bitCounter.bitCounter(2));
        System.out.println(bitCounter.bitCounter(5));
    }

    public int[] bitCounter(int n) {
        int[] result = new int[n + 1];
        result[0] = 0;
        int k = 0;
        int j = 0;
        for (int i = 1; i <= n; i++) {
            result[i] = result[j++] + 1;
            if (j == Math.pow(2, k)) {
                j = 0;
                ++k;
            }
        }
        return result;
    }
}
