package algorithm.dp;

import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

/**
 * @author zhiqungao@tencent.com
 * @date 2021/10/13 下午7:54
 */
public class NthMagicalNumber {
    public static void main(String[] args) {

    }

    public int nthMagicalNumber(int n, int a, int b) {
        int mod = 1000_000_007;
        Set<Long> set = new HashSet<>();
        int cur = 0;
        long i = 1, j = 1;
        while (cur++ < n - 1) {
            if (i * a > j * b && !set.contains(j * b)) {
                set.add(j * b);
                ++j;
            } else {
                set.add(i * a);
                ++i;
            }
        }
        return (int) (Math.min(i * a, j * b) % mod);

    }

    public int nthMagicalNumber2(int n, int a, int b) {
        int mod = 1000_000_007;
        int l = a / gcd(a, b) * b;//最小公倍数
        int m = l / a + l / b - 1;
        int q = n / m, r = n % m;// 增加多少个最大公倍数，减去
        long ans = q * l % mod;
        if (r == 0) {
            return (int) ans;//恰好是第n个最大公倍数
        }
        int[] heads = new int[]{a, b};
        for (int i = 0; i < r - 1; ++i) {
            if (heads[0] < heads[1]) {
                heads[0] += a;
            } else {
                heads[1] += b;
            }
        }
        ans += Math.min(heads[0], heads[1]);
        return (int) ans % mod;
    }

    public int gcd(int a, int b) {
        while (b != 0) {
            int temp = a % b;
            a = b;
            b = temp;
        }
        return a;
    }
}
