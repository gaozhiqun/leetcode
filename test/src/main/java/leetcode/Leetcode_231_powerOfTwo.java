package leetcode;

/**
 * @author zhiqungao@tencent.com
 * @date 2021/11/17 下午4:38
 */
public class Leetcode_231_powerOfTwo {
    public static void main(String[] args) {
        Leetcode_231_powerOfTwo l = new Leetcode_231_powerOfTwo();
        System.out.println(l.isPowerOfTwo(15));
        System.out.println(l.isPowerOfTwo(16));
        System.out.println(l.isPowerOfTwo(17));
        System.out.println(l.isPowerOfTwo(-8));

    }

    public boolean isPowerOfTwo(int n) {
        if (n <= 0) {
            return false;
        } else if (n == 1) {
            return true;
        }
        while (n > 1) {
            if (n % 2 != 0) {
                return false;
            }
            n /= 2;
        }
        return true;
    }
}
