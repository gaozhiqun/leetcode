package leetcode;

/**
 * @author zhiqungao@tencent.com
 * @date 2022/1/18 下午3:38
 */
public class Leetcode_780_reachingPoints {
    public static void main(String[] args) {

    }


    public boolean reachingPoints(int sx, int sy, int tx, int ty) {
        return (Math.abs(tx) + Math.abs(ty)) % gcd(sx, sy) == 0;
    }

    public int gcd(int a, int b) {
        while (b != 0) {
            int t = b;
            b = a % b;
            a = t;
        }
        return a;
    }
}
