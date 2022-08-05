package algorithm.huawei;

import java.util.Scanner;

/**
 * @author zhiqungao@tencent.com
 * @date 2022/6/22 下午8:56
 */
public class Triplet {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            System.out.println(solve(scanner.nextDouble()));
        }
    }

    public static double solve(double n) {
        double x0 = n;
        double x1 = (2 * x0 + n / x0 / x0) / 3;
        while (true) {
            x0 = x1;
            x1 = (2 * x0 + n / x0 / x0) / 3;
            if (Math.abs(x1 - x0) < 0.01) {
                break;
            }
        }
        return x1;
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
