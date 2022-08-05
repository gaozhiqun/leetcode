package segmentTree;

import algorithm.tree.TreeNode;

import java.util.*;

/**
 * @author zhiqungao@tencent.com
 * @date 2021/11/24 下午2:29
 */
public class CountRangeSum {



    public int countRangeSum(int[] nums, int lower, int upper) {
        int n = nums.length;
        long[] preSums = new long[n + 1];
        for (int i = 1; i <= n; ++i) {
            preSums[i] += preSums[i - 1] + nums[i - 1];
        }
        Set<Long> allNumbers = new TreeSet<>();// 从小到大排序
        for (long preSum : preSums) {
            allNumbers.add(preSum);
            allNumbers.add(preSum - lower);
            allNumbers.add(preSum - upper);
        }
        Map<Long, Integer> map = new HashMap<>();
        int idx = 0;
        for (long v : allNumbers) {
            map.put(v, idx++);
        }
        SegNode root = buildSegTree(0, map.size() - 1);
        int ret = 0;
        for (long preSum : preSums) {
            int left = map.get(preSum - upper), right = map.get(preSum - lower);
            ret += count(root, left, right);
            insert(root, map.get(preSum));
        }
        return ret;

    }


    private void insert(SegNode root, int cur) {
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

    private int count(SegNode root, int l, int r) {
        if (l > root.right || r < root.left) {
            return 0;
        }
        if (l <= root.left && root.right <= r) {
            return root.val;
        }
        return count(root.lchild, l, r) + count(root.rchild, l, r);
    }

    private SegNode buildSegTree(int l, int r) {
        SegNode root = new SegNode(l, r);
        if (l == r) {
            return root;
        }
        int mid = l + (r - l) / 2;
        root.lchild = buildSegTree(l, mid);
        root.rchild = buildSegTree(mid + 1, r);
        return root;
    }

    public static class SegNode {
        public SegNode lchild;
        public SegNode rchild;
        public int left;
        public int right;
        public int val;

        public SegNode(int l, int r) {
            this.left = l;
            this.right = r;
            this.val = 0;
        }
    }
}