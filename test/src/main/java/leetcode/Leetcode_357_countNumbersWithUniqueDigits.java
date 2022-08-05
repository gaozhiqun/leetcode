package leetcode;

import java.util.*;

/**
 * @author zhiqungao@tencent.com
 * @date 2021/12/2 下午9:11
 */
public class Leetcode_357_countNumbersWithUniqueDigits {
    public static void main(String[] args) {
        Leetcode_357_countNumbersWithUniqueDigits l = new Leetcode_357_countNumbersWithUniqueDigits();
        System.out.println(l.countNumbersWithUniqueDigits(2));
        System.out.println(l.countNumbersWithUniqueDigits(3));
    }

    public int countNumbersWithUniqueDigits(int n) {
        if (n == 1) {
            return 10;
        } else if (n > 10) {
            return 0;
        }
        int ans = 9;
        int base = 9;
        for (int i = 1; i < n; i++) {
            ans *= base--;
        }
        return ans + countNumbersWithUniqueDigits(n - 1);
    }

}
