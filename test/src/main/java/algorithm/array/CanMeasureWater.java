package algorithm.array;

import java.util.HashSet;
import java.util.Set;

/**
 * @author zhiqungao@tencent.com
 * @date 2021/6/30 下午3:52
 */
public class CanMeasureWater {
    public static void main(String[] args) {
        CanMeasureWater canMeasureWater = new CanMeasureWater();
        canMeasureWater.canMeasureWater(3, 5, 4);
    }

    public boolean canMeasureWater(int m, int n, int target) {
        return helper(0, 0, m, n, target, new HashSet<>());
    }

    private boolean helper(int m, int n, int max1, int max2, int target, Set<String> curPairs) {
        if (m == target || n == target || m + n == target) {
            return true;
        }
        if (curPairs.contains(getKey(m, n))) {
            return false;
        } else {
            curPairs.add(getKey(m, n));
        }
        return helper(Math.min(m + n, max1), 0, max1, max2, target, curPairs) ||
                helper(0, Math.max(m + n, max2), max1, max2, target, curPairs) ||
                helper(0, n, max1, max2, target, curPairs) ||
                helper(m, 0, max1, max2, target, curPairs) ||
                helper(max1, n, max1, max2, target, curPairs) ||
                helper(m, max2, max1, max2, target, curPairs);
    }

    public String getKey(int m, int n) {
        return String.format("%s_%s", m, n);
    }

    public boolean canMeasureWater2(int m, int n, int target) {
        if (m + n < target) {
            return false;
        }
        if (m == 0 || n == 0) {
            return target == 0 || m + n == target;
        }
        return target % gcd(m, n) == 0;
    }


    public int gcd(int x, int y) {
        int remain = x % y;
        while (remain != 0) {
            x = y;
            y = remain;
            remain = x % y;
        }
        return y;
    }
}
