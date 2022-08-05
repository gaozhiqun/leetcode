package leetcode;

import java.util.List;

/**
 * @author zhiqungao@tencent.com
 * @date 2022/7/8 下午8:14
 */
public class Leetcode_1201_nthUglyNumber {

    public static void main(String[] args) {
        Leetcode_1201_nthUglyNumber l = new Leetcode_1201_nthUglyNumber();
        System.out.println(l.nthUglyNumber(3, 2, 3, 5));
        System.out.println(l.nthUglyNumber(4, 2, 3, 4));
        System.out.println(l.nthUglyNumber(5, 2, 11, 13));
        System.out.println(l.nthUglyNumber(1000000000, 2, 217983653, 336916467));
    }

    long a, b, c;
    long m1, m2, m3, m4;

    public int nthUglyNumber(int n, int a, int b, int c) {
        long l = 0, r = (long) Math.min(a, Math.min(b, c)) * n, ans = 0;

        this.a = a;
        this.b = b;
        this.c = c;
        m1 = mlti(a, b);
        m2 = mlti(a, c);
        m3 = mlti(b, c);
        m4 = mlti(m1, c);
        while (l <= r) {
            long mid = l + (r - l) / 2;
            long cnt = getCnt(mid);
            if (cnt < n) {
                l = mid + 1;
                ans = l;
            } else {
                r = mid - 1;
            }
        }
        return (int) ans;
    }

    private long getCnt(long r) {
        return r / a + r / b + r / c - r / m1 - r / m2 - r / m3 + r / m4;
    }


    long mlti(long a, long b) {
        return a * b / gcd(a, b);
    }


    long gcd(long m, long n) {
        while (n != 0) {
            long temp = m % n;
            m = n;
            n = temp;
        }
        return m;
    }


}

