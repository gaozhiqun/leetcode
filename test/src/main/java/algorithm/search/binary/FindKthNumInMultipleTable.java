package algorithm.search.binary;

/**
 * @author zhiqungao@tencent.com
 * @date 2021/9/1 下午5:23
 */
public class FindKthNumInMultipleTable {
    /**
     * 乘法表中第K小的数字
     * 这道题肯定要用二分查找，问题是，怎么查找
     *
     * @param args
     */
    public static void main(String[] args) {
        FindKthNumInMultipleTable findKthNumInMultipleTable = new FindKthNumInMultipleTable();
        System.out.println(findKthNumInMultipleTable.findKthNum(3, 3, 5));
    }

    public int findKthNum(int m, int n, int k) {
        long l = 1, r = n * (long) m;
        while (l < r) {
            long mid = l + (r - l) / 2;
            int cnt = getCounts(mid, m, n);
            if (cnt >= k) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        return (int) l;
    }

    public int getCounts(long mid, int m, int n) {
        int cnt = 0;
        for (int i = 1; i <= m; ++i) {
            cnt += Math.min(mid / i, n);
        }
        return cnt;
    }
}
