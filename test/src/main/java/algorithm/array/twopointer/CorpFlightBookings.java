package algorithm.array.twopointer;


/**
 * @author zhiqungao@tencent.com
 * @date 2021/10/28 下午4:08
 */
public class CorpFlightBookings {
    public static void main(String[] args) {

    }

    /**
     * leetcode 1109 差分，计算当前跟之前的差分
     *
     * @param bookings
     * @param n
     * @return
     */

    public int[] corpFlightBookings(int[][] bookings, int n) {
        int[] ans = new int[n];
        for (int[] booking : bookings) {
            ans[booking[0] - 1] += booking[2];
            if (booking[1] < n) {
                ans[booking[1]] -= booking[2];
            }
        }
        for (int i = 1; i < n; ++i) {
            ans[i] += ans[i - 1];
        }
        return ans;
    }
}
