package leetcode;

/**
 * @author zhiqungao@tencent.com
 * @date 2022/7/6 下午8:01
 */
public class Leetocde_1191_kConcatenationMaxSum {
    public static void main(String[] args) {

    }


    public int kConcatenationMaxSum(int[] arr, int k) {
        int sum1 = 0, sum2 = 0, ret = 0;
        int mod = 1_000_000_007;
        for (int i = 0; i < Math.min(2, k) * arr.length; ++i) {
            if (i < arr.length) {
                sum1 = (sum1 + arr[i]) % mod;
                if (i == arr.length - 1 && sum1 > 0) {
                    ret = Math.max(ret, (int) ((long) k * sum1 % mod));
                    ret = Math.max(ret, (int) ((long) (sum2 + (k - 1) * sum1) % mod));
                }
            }
            sum2 = (sum2 + arr[i % arr.length]) % mod;
            if (sum2 < 0) {
                sum2 = 0;
            }
            ret = Math.max(sum2, ret);
            ret = Math.max(ret, (int) ((long) (sum2 + (k - 2) * sum1) % mod));
        }
        return ret;
    }
}
