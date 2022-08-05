package algorithm.dp;

/**
 * @author zhiqungao@tencent.com
 * @date 2021/6/29 下午7:45
 */
public class CountNumbersWithUniqueDigits {
    public static void main(String[] args) {
        CountNumbersWithUniqueDigits countNumbersWithUniqueDigits = new CountNumbersWithUniqueDigits();
        System.out.println(countNumbersWithUniqueDigits.countNumbersWithUniqueDigits(2));
        System.out.println(countNumbersWithUniqueDigits.countNumbersWithUniqueDigits(3));
    }

    public int countNumbersWithUniqueDigits(int n) {
        if (n == 1) {
            return 10;
        } else {
            int cur = 1;
            int base = 9;
            int result = 9;
            while (cur < n) {
                cur++;
                result *= base;
                base--;
            }
            return result + countNumbersWithUniqueDigits(n - 1);
        }
    }
}
