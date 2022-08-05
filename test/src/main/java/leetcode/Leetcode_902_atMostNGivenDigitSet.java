package leetcode;

import java.util.*;

/**
 * @author zhiqungao@tencent.com
 * @date 2022/2/22 下午4:38
 */
public class Leetcode_902_atMostNGivenDigitSet {

    public static void main(String[] args) {
        Leetcode_902_atMostNGivenDigitSet leetcode_902_atMostNGivenDigitSet = new Leetcode_902_atMostNGivenDigitSet();
        System.out.println(leetcode_902_atMostNGivenDigitSet.atMostNGivenDigitSet(new String[]{"3", "4", "8"}, 4));
        System.out.println(leetcode_902_atMostNGivenDigitSet.atMostNGivenDigitSet(new String[]{"7"}, 8));
        System.out.println(leetcode_902_atMostNGivenDigitSet.atMostNGivenDigitSet(new String[]{"1", "3", "5", "7"}, 100));
        System.out.println(leetcode_902_atMostNGivenDigitSet.atMostNGivenDigitSet(new String[]{"1", "4", "9"}, 1000000000));
    }

    public int atMostNGivenDigitSet(String[] digits, int n) {
        String num = String.valueOf(n);
        int len = num.length(), q = digits.length;
        int[] dp = new int[len + 1];
        dp[len] = 1;
        for (int i = len - 1; i >= 0; --i) {
            int m = num.charAt(i) - '0';
            for (String digit : digits) {
                if (Integer.parseInt(digit) < m) {
                    dp[i] += Math.pow(q, len - 1 - i);
                } else if (Integer.parseInt(digit) == m) {
                    dp[i] += dp[i + 1];
                }
            }
        }
        for (int i = 1; i < len; ++i) {
            dp[0] += Math.pow(q, i);//加上前缀为0的
        }
        return dp[0];
    }

    private int getSmallerCnt(List<Integer> array, int k) {
        for (int i = 0; i < array.size(); ++i) {
            if (k <= array.get(i)) {
                return i;
            }
        }
        return array.size();
    }

    private int getCnt(int q, int n) {
        if (q == 1) {
            return 1;
        }
        return (int) (Math.pow(q, n) - 1) / (q - 1);
    }


}
