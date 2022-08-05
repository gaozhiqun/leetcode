package leetcode;

/**
 * @author zhiqungao@tencent.com
 * @date 2021/11/17 下午8:25
 */
public class Leetcode_738_monotoneIncreasingDigits {

    public static void main(String[] args) {
        Leetcode_738_monotoneIncreasingDigits l = new Leetcode_738_monotoneIncreasingDigits();
        System.out.println(l.monotoneIncreasingDigits(12345));
        System.out.println(l.monotoneIncreasingDigits(321));
    }

    private int ret;

    public int monotoneIncreasingDigits(int n) {
        ret = 0;
        buildNum(0, n);
        return ret;
    }

    private void buildNum(int base, int n) {
        if (base > n) {
            return;
        }
        ret = Math.max(ret, base);
        int last = base % 10;
        if (last == 0) {
            last = 1;
        }
        for (int i = last; i <= 9; ++i) {
            buildNum(base * 10 + i, n);
        }
    }


}