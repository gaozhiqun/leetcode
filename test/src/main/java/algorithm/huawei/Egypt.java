package algorithm.huawei;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author zhiqungao@tencent.com
 * @date 2022/6/25 下午12:15
 */
public class Egypt {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextLine()) {
            System.out.println(in.nextLine());
        }
    }


    public static List<String> egypt(String digit) {
        String[] digits = digit.split("/");
        int p = Integer.parseInt(digits[0]);
        int q = Integer.parseInt(digits[1]);
        List<String> ret = new ArrayList<>();
        int gcd = gcd(p, q);
        p /= gcd;
        q /= gcd;
        while (p != 1) {
            int m = (q / p) + 1;
            ret.add(String.format("1/%s", m));
            p = (m * p - q);
            q = m * q;
            gcd = gcd(p, q);
            p /= gcd;
            q /= gcd;
        }
        ret.add(String.format("%s/%s", p, q));
        return ret;
    }


    public static int gcd(int x, int y) {
        while (y != 0) {
            int temp = x % y;
            x = y;
            y = temp;
        }
        return x;
    }
}

