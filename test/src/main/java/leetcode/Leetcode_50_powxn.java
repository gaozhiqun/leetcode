package leetcode;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author zhiqungao@tencent.com
 * @date 2021/11/1 下午7:35
 */
public class Leetcode_50_powxn {

    public static void main(String[] args) {
        Leetcode_50_powxn l = new Leetcode_50_powxn();
        System.out.println(l.myPow(0, 0));
        System.out.println(l.myPow(2.10000, 3));
        System.out.println(l.myPow(2.00000, -2));

    }

    public double myPow(double x, int n) {
        if (n == 0) {
            return 1.0;
        }
        if (n % 2 != 0) {
            if (n > 0) {
                return x * myPow(x, n - 1);
            } else {
                return myPow(x, n + 1) / x;
            }
        } else {
            double s = myPow(x, n / 2);
            return s * s;
        }
    }

}
