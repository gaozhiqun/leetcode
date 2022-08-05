package algorithm.dp;

import java.util.Arrays;

/**
 * @author zhiqungao@tencent.com
 * @date 2021/10/27 下午8:48
 */
public class BrokenCalc {
    public static void main(String[] args) {
        BrokenCalc brokenCalc = new BrokenCalc();
        int ans = brokenCalc.brokenCalc(2, 3);
        System.out.println(ans);
        System.out.println(brokenCalc.brokenCalc(1024, 1));
        System.out.println(brokenCalc.brokenCalc(3, 10));
        System.out.println(brokenCalc.brokenCalc(5, 8));
    }

    public int brokenCalc(int x, int y) {
        int ans = 0;
        while (y > x) {
            if (y % 2 == 0) {
                y /= 2;
            } else {
                ++y;
            }
            ++ans;
        }
        return ans + x - y;
    }


}
