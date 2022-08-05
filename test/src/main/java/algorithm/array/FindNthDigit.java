package algorithm.array;

/**
 * @author zhiqungao@tencent.com
 * @date 2021/7/1 下午8:59
 */
public class FindNthDigit {

    public int findNthDigit(int n) {
        if (n < 10) {
            return n;
        }
        int cur = 9;
        int length = 1;
        while (n > cur * length) {
            n -= cur * length;
            length++;
            cur *= 10;
        }
        int m = n / length;
        int bit = n % length;
        int num = m + (int) Math.pow(10, length) - 1;
        for (int i = 0; i < bit; i++) {
            num /= 10;
        }
        return num % 10;
    }
}
