package leetcode;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

/**
 * @author zhiqungao@tencent.com
 * @date 2022/7/6 下午3:34
 */
public class Leetcode_327_countRangeSum {
    public static void main(String[] args) {
        Leetcode_327_countRangeSum l = new Leetcode_327_countRangeSum();
        System.out.println(l.countRangeSum(new int[]{-2, 5, -1}, -2, 2));
    }

    /**
     * rangeSum ->[lower, upper]
     */
    public int countRangeSum(int[] nums, int lower, int upper) {
        int N = nums.length;
        long[] preSums = new long[N + 1];
        for (int i = 1; i <= N; ++i) {
            preSums[i] = preSums[i - 1] + nums[i - 1];
        }
        Set<Long> allNumbers = new TreeSet<>();// 从小到大排序
        for (long preSum : preSums) {
            allNumbers.add(preSum);
            allNumbers.add(preSum - lower);
            allNumbers.add(preSum - upper);
        }

        Map<Long, Integer> idxMap = new HashMap<>();
        int idx = 0;
        for (long num : allNumbers) {
            idxMap.put(num, idx++);
        }
        SegTree root = buildSegTree(0, idxMap.size() - 1);
        int ret = 0;
        for (long preSum : preSums) {
            int left = idxMap.get(preSum - upper), right = idxMap.get(preSum - lower);
            ret += count(root, left, right);
            insert(root, idxMap.get(preSum));
        }
        return ret;


    }

    private void insert(SegTree root, int cur) {
        root.val++;
        if (root.left == root.right) {
            return;
        }
        int mid = (root.left + root.right) / 2;
        if (cur <= mid) {
            insert(root.lchild, cur);
        } else {
            insert(root.rchild, cur);
        }
    }

    private int count(SegTree root, int l, int r) {
        if (l > root.right || r < root.left) {
            return 0;
        }
        if (l <= root.left && root.right <= r) {
            return root.val;
        }
        return count(root.lchild, l, r) + count(root.rchild, l, r);
    }

    private SegTree buildSegTree(int l, int r) {
        SegTree root = new SegTree(l, r);
        if (l == r) {
            return root;
        }
        int mid = l + (r - l) / 2;
        root.lchild = buildSegTree(l, mid);
        root.rchild = buildSegTree(mid + 1, r);
        return root;
    }

    public static class SegTree {
        public SegTree lchild;
        public SegTree rchild;
        public int left;
        public int right;
        public int val;

        public SegTree(int l, int r) {
            this.left = l;
            this.right = r;
            this.val = 0;
        }
    }
}
