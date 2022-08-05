package algorithm.offer;

/**
 * @author zhiqungao@tencent.com
 * @date 2021/6/3 3:29 下午
 */
public class RobotMove {
    public static void main(String[] args) {
        RobotMove robotMove = new RobotMove();
    }


    public int movingCount(int m, int n, int k) {
        int result = 0;
        for (int i = 1; i < k; i++) {
            result += getCount(m, i) * getCount(n, k - i);
        }
        return result;
    }

    private int getCount(int m, int k) {
        if (m / 10 == 0) {
            if (m > k) {
                return m - k;
            }
            return 0;
        }
        int n = m;
        int p = 0;
        while (n > 10) {
            n /= 10;
            p++;
        }
        int left = m % 10;
        int total = 0;
        for (int i = 1; i < n; i++) {
            total += getCount((int) Math.pow(10, p) - 1, k - i);
        }
        total += getCount(left, k - n);
        return total;
    }


}
