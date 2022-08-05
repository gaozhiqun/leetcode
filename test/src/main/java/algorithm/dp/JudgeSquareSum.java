package algorithm.dp;

/**
 * @author zhiqungao@tencent.com
 * @date 2021/8/27 下午5:06
 */
public class JudgeSquareSum {
    public static void main(String[] args) {

    }

    public boolean judgeSquareSum(int c) {
        if (c <= 1) {
            return true;
        }
        int sqrt = (int) Math.sqrt(c);
        int l = 0, r = sqrt;
        while (l <= r) {
            long sum = l * l + r * r;
            if (sum == c) {
                return true;
            } else if (sum > c) {
                r--;
            } else {
                l--;
            }
        }
        return false;
    }
}
