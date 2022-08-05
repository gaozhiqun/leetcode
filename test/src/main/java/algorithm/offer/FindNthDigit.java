package algorithm.offer;

/**
 * @author zhiqungao@tencent.com
 * @date 2021/6/10 2:17 下午
 */
public class FindNthDigit {

    public static void main(String[] args) {

    }

    public int findNthDigit(int n) {
        if (n < 10) {
            return n;
        }
        int digit = 10;
        n -= digit;
        int base = 9;
        int length = 2;
        while (n > base * digit * length) {
            n -= base * digit * length;
            digit *= 10;
            length++;
        }
        int k = n / (length) + length * digit;
        // 第几个
        int m = n % length;
        //第几位
        digit = 10;
        while (m > 0) {
            digit *= 10;
            m--;
        }
        return k % digit;
    }
}
