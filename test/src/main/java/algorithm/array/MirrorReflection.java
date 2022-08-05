package algorithm.array;

/**
 * @author zhiqungao@tencent.com
 * @date 2021/10/13 下午2:24
 */
public class MirrorReflection {
    public static void main(String[] args) {

    }

    /**
     * leetcode 858 镜面反射
     *
     * @param p
     * @param q
     * @return
     */

    public int mirrorReflection(int p, int q) {
        int min = p * q / gcd(p, q);
        int x = min / p % 2;
        int y = min / q % 2;
        if (x == 1 && y == 0) {
            return 0;
        } else if (x == 1 && y == 1) {
            return 1;
        } else if (x == 0 && y == 1) {
            return 2;
        }
        return -1;
    }

    public int gcd(int p, int q) {
        if (p < 0 || q < 0) {
            return -1;
        }
        if (q == 0) {
            return p;
        }
        while (q != 0) {
            int temp = p % q;
            p = q;
            q = temp;
        }
        return p;
    }


}
