package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author zhiqungao@tencent.com
 * @date 2021/12/14 上午10:48
 */
public class Leetcode_440_findKthNumber {
    public static void main(String[] args) {
        Leetcode_440_findKthNumber l = new Leetcode_440_findKthNumber();
        System.out.println(l.findKthNumber(13, 2));
        System.out.println(l.findKthNumber(681692778, 351251360));
    }


    public long getCount(int n, long cur) {
        long next = cur + 1, cnt = 0;
        while (cur <= n) {
            cnt += Math.min(n - cur + 1, next - cur);
            cur *= 10;
            next *= 10;
        }
        return cnt;
    }


    public int findKthNumber(int n, int k) {
        long cur = 1;
        while (k > 1) {
            long cnt = getCount(n, cur);
            if (k <= cnt) {
                cur *= 10;
                k -= 1;
            } else {
                cur += 1;
                k -= cnt;
            }
        }
        return (int) cur;
    }

    public long count(int n, long cur) {
        long next = cur + 1, cnt = 0;
        while (cur <= n) {
            cnt += Math.min(n - cur + 1, next - cur);
            cur *= 10;
            next *= 10;
        }
        return cnt;
    }

}
