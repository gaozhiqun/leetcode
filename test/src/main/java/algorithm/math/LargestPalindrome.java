package algorithm.math;

import javax.imageio.ImageTranscoder;

/**
 * @author zhiqungao@tencent.com
 * @date 2021/8/20 上午11:52
 */
public class LargestPalindrome {

    private static int BASE = 1337;


    public static void main(String[] args) {

    }

    public int largestPalidrome(int n) {
        if (n == 1) {
            return 9;
        }
        int max = (int) Math.pow(10, n) - 1;
        int min = (int) Math.pow(10, n - 1);
        int total = 2 * (int) Math.pow(10, n);

        int a = 2;//a=i+j
        while (a < total) {
            int upper = (int) Math.pow(10, n) - a;
            int lower = reverse(upper);
            return (int)(upper * Math.pow(10, n) + lower);
        }
        return -1;

    }

    int reverse(int m) {
        int n = 0;
        while (m > 0) {
            n += m % 10;
            m /= 10;
        }
        return n;
    }


}
