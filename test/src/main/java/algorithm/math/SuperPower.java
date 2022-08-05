package algorithm.math;

/**
 * @author zhiqungao@tencent.com
 * @date 2021/7/1 上午11:04
 */
public class SuperPower {
    public static void main(String[] args) {
        SuperPower superPower = new SuperPower();
        System.out.println(superPower.superPow(2, new int[]{1, 0}));
    }

    public int superPow(int a, int[] b) {
        return helper(a, b, b.length - 1, 1);
    }

    public int helper(int a, int[] b, int cur, int result) {
        if (cur < 0) {
            return result;
        }
        int p1 = power(a, b[cur]);
        int p2 = power(helper(a, b, cur - 1, 1), 10);
        return p1 * p2;
    }

    public int power(int a, int b) {
        int result = 1;
        for (int i = 0; i < b; i++) {
            result *= a;
            result %= 1337;
        }
        return result;
    }

    /**
     * a^200 = （a^2)^100;
     * %1337
     */
}
