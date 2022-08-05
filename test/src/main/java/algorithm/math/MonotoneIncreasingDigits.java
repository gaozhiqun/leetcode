package algorithm.math;

/**
 * @author zhiqungao@tencent.com
 * @date 2021/9/7 下午9:01
 */
public class MonotoneIncreasingDigits {
    public static void main(String[] args) {
        MonotoneIncreasingDigits monotoneIncreasingDigits = new MonotoneIncreasingDigits();
        System.out.println(monotoneIncreasingDigits.monotoneIncreasingDigits(10));
        System.out.println(monotoneIncreasingDigits.monotoneIncreasingDigits(332));
        System.out.println(monotoneIncreasingDigits.monotoneIncreasingDigits(12345));
    }

    private int result = 0;

    public int monotoneIncreasingDigits(int n) {
        char[] digits = Integer.toString(n).toCharArray();
        int i = 1;
        while (i < digits.length && digits[i - 1] <= digits[i]) {
            i++;
        }
        if (i < digits.length) {
            while (i > 0 && digits[i - 1] > digits[i]) {
                digits[i - 1] -= 1;
                i--;
            }
            for (i += 1; i < digits.length; i++) {
                digits[i] = '9';
            }
        }
        return Integer.parseInt(new String(digits));
    }

    private void buildNum(int base, int n) {
        if (base > n) {
            return;
        }
        result = Math.max(result, base);
        int last = base % 10;
        if (last == 0) {
            last = 1;
        }
        for (int i = last; i <= 9; ++i) {
            buildNum(base * 10 + i, n);
        }
    }
}
