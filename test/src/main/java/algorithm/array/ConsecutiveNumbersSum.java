package algorithm.array;

/**
 * @author zhiqungao@tencent.com
 * @date 2021/10/8 下午7:37
 */
public class ConsecutiveNumbersSum {
    public static void main(String[] args) {

    }

    public int consecutiveNumbersSum(int N) {
        while ((N & 1) == 0) {
            N >>= 1;
        }
        int ans = 1, d = 3;

        while (d * d <= N) {
            int e = 0;
            while (N % d == 0) {
                N /= d;
                e++;
            }
            ans *= e + 1;
            d += 2;
        }

        if (N > 1) {
            ans <<= 1;
        } ;
        return ans;
    }


}
