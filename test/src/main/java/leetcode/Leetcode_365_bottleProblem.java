package leetcode;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

/**
 * @author zhiqungao@tencent.com
 * @date 2021/12/6 下午8:18
 */
public class Leetcode_365_bottleProblem {
    public static void main(String[] args) {

    }


    public boolean canMeasureWater(int x, int y, int z) {
        if (x + y < z) {
            return false;
        }
        if (x == 0 || y == 0) {
            return z == 0 || x + y == z;
        }
        return z % gcd(x, y) == 0;
    }

    private int gcd(int m, int n) {
        while (n != 0) {
            int temp = m % n;
            m = n;
            n = temp;
        }
        return m;
    }
}
