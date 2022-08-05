package algorithm.math;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zhiqungao@tencent.com
 * @date 2021/7/5 下午8:23
 */
public class FindKthNumber {

    public static void main(String[] args) {
        FindKthNumber findKthNumber = new FindKthNumber();
        System.out.println(findKthNumber.findKthNumber(13, 2));

    }
    // 1

    public int findKthNumber2(int n, int k) {
        int remain = k;
        int preFix = 1;
        int next = 1;
        while (remain > 0) {
            if (remain > preFix) {
                remain -= next;
                preFix *= 10;
                next *= 10;
            } else {
                preFix /= 10;
                preFix++;
            }
        }
        return preFix;
    }

    /**
     * 前缀树的应用
     *
     * @param n
     * @param k
     * @return
     */

    public int findKthNumber(int n, int k) {
        if (n < 10) {
            return k;
        }
        int cur = 1;
        int count = 1;
        while (count < k) {
            if (cur * 10 < n) {
                cur *= 10;
                count++;
            } else if ((cur + 1) % 10 == 0) {
                cur /= 10;
                cur++;
            } else {
                cur++;
                count++;
            }
        }
        return cur;
    }

    public int findKthNumber3(int n, int k) {
        long cur = 1;
        k -= 1;

        while (k > 0) {
            int nodes = getNodes(n, cur);
            if (k >= nodes) {
                k -= nodes;
                cur++;      //go right
            } else {
                k -= 1;
                cur *= 10;  //go down
            }
        }

        return (int) cur;
    }

    private int getNodes(int n, long cur) {
        long next = cur + 1;
        long totalNodes = 0;

        while (cur <= n) {
            totalNodes += Math.min(n - cur + 1, next - cur);
            next *= 10;
            cur *= 10;
        }

        return (int) totalNodes;
    }
}
