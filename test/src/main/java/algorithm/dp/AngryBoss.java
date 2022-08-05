package algorithm.dp;

/**
 * @author zhiqungao@tencent.com
 * @date 2021/3/16 2:40 下午
 */
public class AngryBoss {

    public int maxSatisfiedCustomer(int[] customers, int[] grumpy, int x) {
        int m = customers.length;
        int result = 0;
        if (x >= customers.length) {
            for (int i : customers) {
                result += i;
            }
            return result;
        }
        int moreStatisfiledCnt = 0;
        int mostSatisfiedCnt = Integer.MIN_VALUE;
        int originCnt = 0;
        for (int i = 0; i < m; i++) {
            if (grumpy[i] == 1) {
                moreStatisfiledCnt += customers[i];
            } else {
                originCnt += customers[i];
            }
            if (i > x && grumpy[i - x] == 1) {
                moreStatisfiledCnt -= customers[i - x];
            }
            mostSatisfiedCnt = Math.max(moreStatisfiledCnt, mostSatisfiedCnt);
        }
        return originCnt + mostSatisfiedCnt;
    }
}
