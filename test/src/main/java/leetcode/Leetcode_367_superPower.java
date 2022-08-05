package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author zhiqungao@tencent.com
 * @date 2021/12/6 下午8:18
 */
public class Leetcode_367_superPower {
    public static void main(String[] args) {
        Leetcode_367_superPower l = new Leetcode_367_superPower();

    }

    static final int MOD = 1337;

    public int superPow(int a, int[] b) {
        int ans = 1;
        for (int e : b) {
            ans = (int) ((long) pow(ans, 10) * pow(a, e) % MOD);
        }
        return ans;
    }

    public int pow(int x, int n) {
        int res = 1;
        while (n != 0) {
            if (n % 2 != 0) {
                res = (int) ((long) res * x % MOD);
            }
            x = (int) ((long) x * x % MOD);
            n /= 2;
        }
        return res;
    }

}
