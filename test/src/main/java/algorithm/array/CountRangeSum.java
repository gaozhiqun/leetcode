package algorithm.array;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

/**
 * @author zhiqungao@tencent.com
 * @date 2021/6/21 下午6:46
 */
public class CountRangeSum {


    public static void main(String[] args) {

    }

    public int countRangeSum(int[] nums, int lower, int upper) {
        int len = nums.length;
        long s = 0;
        long[] sums = new long[len + 1];
        for (int i = 1; i < nums.length; ++i) {
            s += nums[i];
            sums[i + 1] = s;
        }
        return helper(sums, lower, upper, 0, nums.length - 1);
    }

    private int helper(long[] sums, int lower, int uppper, int l, int r) {
        if (l == r) {
            return 0;
        } else {
            int mid = (l + r) / 2;
            int newL = mid + 1;
            int newR = mid + 1;
            int n1 = helper(sums, lower, uppper, l, mid);
            int n2 = helper(sums, lower, uppper, mid, r);
            int ret = n1 + n2;
            int i = l;
            while (i <= mid) {
                while (newL <= r && sums[newL] - sums[i] < lower) {
                    newL++;
                }
                while (newR <= r && sums[newR] - sums[i] < lower) {
                    newR++;
                }
                ret += newR - newL;
                ++i;
            }
            long[] sorted = new long[newR - newL + 1];
            int p1 = newL, p2 = mid + 1;
            int p = 0;
            while (p1 <= mid || p2 <= newR) {
                if (p1 > mid) {
                    sorted[p++] = sums[p2++];
                } else if (p2 > newR) {
                    sorted[p++] = sums[p1++];
                } else {
                    if (sums[p1] < sums[p2]) {
                        sorted[p++] = sums[p1++];
                    } else {
                        sorted[p++] = sums[p2++];
                    }
                }
            }
            for (int j = 0; j < sorted.length; j++) {
                sums[newL + j] = sorted[j];
            }
            return ret;
        }
    }

    public int countRangeSum2(int[] nums, int lower, int upper) {
        int len = nums.length;
        long s = 0;
        long[] sums = new long[len + 1];
        for (int i = 1; i < nums.length; ++i) {
            s += nums[i];
            sums[i + 1] = s;
        }
        Set<Long> allNumbers = new TreeSet<Long>();
        for (long x : sums) {
            allNumbers.add(x);
            allNumbers.add(x - lower);
            allNumbers.add(x - upper);
        }
        // 利用哈希表进行离散化
        Map<Long, Integer> values = new HashMap<Long, Integer>();
        int idx = 0;
        for (long x : allNumbers) {
            values.put(x, idx);
            idx++;
        }

        SegNode root = build(0, values.size() - 1);
        int ret = 0;
        for (long x : sums) {
            int left = values.get(x - upper), right = values.get(x - lower);
            ret += count(root, left, right);
            insert(root, values.get(x));
        }
        return ret;
    }

//    public int countRangeSum3(int[] nums, int lower, int upper) {
//        int len = nums.length;
//        long s = 0;
//        long[] sums = new long[len + 1];
//        for (int i = 1; i < nums.length; ++i) {
//            s += nums[i];
//            sums[i + 1] = s;
//        }
//
//    }




    public SegNode build(int left, int right) {
        SegNode node = new SegNode(left, right);
        if (left == right) {
            return node;
        }
        int mid = (left + right) / 2;
        node.lchild = build(left, mid);
        node.rchild = build(mid + 1, right);
        return node;
    }

    public int count(SegNode root, int left, int right) {
        if (left > root.hi || right < root.lo) {
            return 0;
        }
        if (left <= root.lo && root.hi <= right) {
            return root.add;
        }
        return count(root.lchild, left, right) + count(root.rchild, left, right);
    }

    public void insert(SegNode root, int val) {
        root.add++;
        if (root.lo == root.hi) {
            return;
        }
        int mid = (root.lo + root.hi) / 2;
        if (val <= mid) {
            insert(root.lchild, val);
        } else {
            insert(root.rchild, val);
        }
    }

    public int countRangeSum3(int[] nums, int lower, int upper) {
        long sum = 0;
        long[] preSum = new long[nums.length + 1];
        for (int i = 0; i < nums.length; ++i) {
            sum += nums[i];
            preSum[i + 1] = sum;
        }

        int lbound = Integer.MAX_VALUE, rbound = Integer.MIN_VALUE;
        for (long x : preSum) {
            lbound = Math.min((int)Math.min(lbound, x), (int)Math.min(x - lower, x - upper));
            rbound = Math.max((int)Math.max(rbound, x), (int)Math.max(x - lower, x - upper));
        }

        SegNode root = new SegNode(lbound, rbound);
        int ret = 0;
        for (long x : preSum) {
            ret += count(root, x - upper, x - lower);
            insert(root, x);
        }
        return ret;
    }

    public int count(SegNode root, long left, long right) {
        if (root == null) {
            return 0;
        }
        if (left > root.hi || right < root.lo) {
            return 0;
        }
        if (left <= root.lo && root.hi <= right) {
            return root.add;
        }
        return count(root.lchild, left, right) + count(root.rchild, left, right);
    }

    public void insert(SegNode root, long val) {
        root.add++;
        if (root.lo == root.hi) {
            return;
        }
        int mid = (root.lo + root.hi) >> 1;
        if (val <= mid) {
            if (root.lchild == null) {
                root.lchild = new SegNode(root.lo, mid);
            }
            insert(root.lchild, val);
        } else {
            if (root.rchild == null) {
                root.rchild = new SegNode(mid + 1, root.hi);
            }
            insert(root.rchild, val);
        }
    }



    class SegNode {
        int lo, hi, add;
        SegNode lchild, rchild;

        public SegNode(int l, int r) {
            lo = l;
            hi = r;
            add = 0;
            lchild = null;
            rchild = null;
        }
    }
}