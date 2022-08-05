package leetcode;

/**
 * @author zhiqungao@tencent.com
 * @date 2022/4/2 下午7:15
 */
public class Leetcode_1012_numDupDigitsAtMostN {
    public static void main(String[] args) {
        Leetcode_1012_numDupDigitsAtMostN l = new Leetcode_1012_numDupDigitsAtMostN();
        System.out.println(l.numDupDigitsAtMostN(20));
        System.out.println(l.numDupDigitsAtMostN(100));
    }


    /**
     * 阶乘
     *
     * @param n
     * @return
     */
    private int fact(int n) {
        if (n == 1 || n == 0) {
            return 1;
        }
        return n * fact(n - 1);
    }

    /**
     * C(m,n)
     *
     * @param m
     * @param n
     * @return
     */
    int A(int m, int n) {
        return fact(m) / fact(m - n);
    }


    public int numDupDigitsAtMostN(int n) {

        String strN = String.valueOf(n);
        int len = strN.length();
        int[] used = new int[10];
        int total = 0;
        for (int i = 1; i < len; i++) {
            total += 9 * A(9, i - 1);
        }
        for (int i = 0; i < len; ++i) {
            int num = strN.charAt(i) - '0';
            for (int j = (i == 0 ? 1 : 0); j < num; j++) {
                if (used[j] != 0) {
                    continue;
                }
                total += A(10 - 1 - i, len - i - 1);
            }
            if (++used[num] > 1) {
                break;
            }
            if (i == len - 1) {
                total += 1;
            }
        }
        return n - total;
    }


    /**
     * 1
     */
}
