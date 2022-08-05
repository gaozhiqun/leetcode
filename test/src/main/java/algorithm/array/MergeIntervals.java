package algorithm.array;

import java.util.*;

/**
 * @author zhiqungao@tencent.com
 * @date 2021/3/29 3:14 下午
 */
public class MergeIntervals {
    public static void main(String[] args) {
        MergeIntervals mergeIntervals = new MergeIntervals();
        mergeIntervals.merge(new int[][]{{}});

    }

    public List<int[]> merge(int[][] intervals) {
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] == o2[0] ? Integer.compare(o1[1], o2[1]) : Integer.compare(o1[0], o2[0]);
            }
        });
        List<int[]> result = new ArrayList<>();
        int[] cur = null;
        for (int[] array : intervals) {
            if (cur == null) {
                cur = array;
            } else if (cur[1] <= array[0]) {
                cur = merge(cur, array);
            } else {
                result.add(cur);
                cur = array;
            }
        }
        if (cur != null) {
            result.add(cur);
        }
        return result;
    }

    private int[] merge(int[] a, int[] b) {
        return new int[]{
                Math.min(a[0], b[0]), Math.max(a[1], b[1])
        };
    }

    private String kthSequence(int n, int k) {
        StringBuilder sb = new StringBuilder("");
        List<Integer> nums = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            nums.add(i + 1);
        }
        helper(sb, n, k, nums);
        return sb.toString();
    }

    private void helper(StringBuilder stringBuilder, int m, int k, List<Integer> nums) {
        if (k == 0) {
            return;
        }
        int j = jie(m - 1);
        int newK = k % j;
        int remove = k / j;
        nums.remove(remove);
        helper(stringBuilder, m - 1, newK, nums);
    }

    private int jie(int m) {
        int result = 1;
        for (int i = 1; i <= m; i++) {
            result *= i;
        }
        return result;
    }
}
