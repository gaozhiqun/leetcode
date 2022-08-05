package segmentTree;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

import static segmentTree.BIT.lowbit;

/**
 * @author zhiqungao@tencent.com
 * @date 2021/11/24 下午4:46
 */
public class CountReversePair {

    public static void main(String[] args) {
        CountReversePair countReversePair = new CountReversePair();
//        System.out.println(countReversePair.reversePairs(new int[]{
//                1, 3, 2, 3, 1
//        }));
        System.out.println(countReversePair.reversePairs(new int[]{
                2147483647, 2147483647, 2147483647, 2147483647, 2147483647, 2147483647
        }));
    }

    int n, ans;
    int[] nums;

    public int reversePairs(int[] nums) {
        this.n = nums.length;
        ans = 0;
        this.nums = nums;
        mergeSort(nums, 0, n - 1);
        return ans;
    }

    private void mergeSort(int[] nums, int l, int r) {
        if (l >= r) {
            return;
        }
        int mid = l + (r - l) / 2;
        mergeSort(nums, l, mid);
        mergeSort(nums, mid + 1, r);
        countThenMerge(l, mid, r);
    }

    private void countThenMerge(int l, int mid, int r) {
        for (int i = l, j = mid + 1; i <= mid; i++) {
            while (j <= r && (long) nums[i] > 2 * (long) nums[j]) {
                ++j;
            }
            ans += (j - mid - 1);
        }
        int[] temp = new int[r - l + 1];
        int i = l, j = mid + 1, p = 0;
        while (i <= mid && j <= r) {
            if (nums[i] < nums[j]) {
                temp[p++] = nums[i++];
            } else {
                temp[p++] = nums[j++];
            }
        }
        while (i <= mid) {
            temp[p++] = nums[i++];
        }
        while (j <= r) {
            temp[p++] = nums[j++];
        }
        System.arraycopy(temp, 0, nums, l, temp.length);
    }

    public int reversePairs2(int[] nums) {
        Set<Long> set = new TreeSet<>();
        for (int i : nums) {
            set.add((long) i);
            set.add((long) i * 2);
        }
        int idx = 0;
        Map<Long, Integer> map = new HashMap<>();
        for (long i : set) {
            map.put(i, idx++);
        }

        BIT bit = new BIT(map.size());
        int ans = 0;
        for (int i = 0; i < nums.length; i++) {
            int left = map.get((long) nums[i] * 2), right = map.size() - 1;
            ans += bit.count(right + 1) - bit.count(left + 1);
            bit.update(map.get((long) nums[i]) + 1);
        }
        return ans;
    }


    public static class BIT {
        private int n;
        private int[] tree;

        public BIT(int n) {
            this.n = n;
            this.tree = new int[n + 1];
        }

        public int lowBit(int x) {
            return x & (-x);
        }

        public void update(int x) {
            while (x <= n) {
                tree[x]++;
                x += lowBit(x);
            }
        }

        public int count(int x) {
            int ret = 0;
            while (x != 0) {
                ret += tree[x];
                x -= lowBit(x);
            }
            return ret;
        }

        void add(int pos, int val) {
            while (pos <= n) {
                tree[pos] += val;
                pos += lowbit(pos);
            }
        }

        public void rangeAdd(int l, int r, int x) {
            add(l, x);
            add(r + 1, -x);
        }
    }
}
