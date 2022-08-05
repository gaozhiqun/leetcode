package leetcode;

/**
 * @author zhiqungao@tencent.com
 * @date 2022/6/27 下午2:20
 */
public class Leetcode_1109_corpFlightBookings {

    public int[] corpFlightBookings(int[][] bookings, int n) {
        int[] prefixSum = new int[n + 1];
        int[] ret = new int[n];
        for (int[] booking : bookings) {
            int i = booking[0] - 1;
            int j = booking[1];
            int val = booking[2];
            prefixSum[i] += val;
            prefixSum[j] -= val;
        }
        int sum = 0;
        for (int i = 0; i < n; ++i) {
            sum += prefixSum[i];
            ret[i] = sum;
        }
        return ret;
    }
}
