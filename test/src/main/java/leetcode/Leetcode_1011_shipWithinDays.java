package leetcode;

/**
 * @author zhiqungao@tencent.com
 * @date 2022/4/6 上午10:45
 */
public class Leetcode_1011_shipWithinDays {
    public static void main(String[] args) {
        Leetcode_1011_shipWithinDays l = new Leetcode_1011_shipWithinDays();
        System.out.println(l.shipWithinDays(new int[]{3, 2, 2, 4, 1, 4}, 3));
        System.out.println(l.shipWithinDays(new int[]{1, 2, 3, 1, 1}, 4));
    }

    /**
     * 切成days 段，求和最小值
     *
     * @param weights
     * @param days
     * @return
     */
    public int shipWithinDays(int[] weights, int days) {
        int l = 0, r = 0;
        for (int i : weights) {
            r += i;
            l = Math.max(i, l);
        }
        while (l < r) {
            int mid = l + (r - l) / 2;
            int d = getSum(weights, mid);
            if (d > days) {
                l = mid + 1;
            } else {
                r = mid;
            }
        }
        return r;
    }

    private int getSum(int[] weights, int load) {
        int ret = 1, curLoad = 0;
        for (int i : weights) {
            curLoad += i;
            if (curLoad > load) {
                curLoad = i;
                ++ret;
            }
        }
        return ret;
    }


}
