package algorithm.array;

import java.util.Map;
import java.util.TreeMap;

/**
 * @author zhiqungao@tencent.com
 * @date 2021/8/25 上午11:23
 */
public class ReversePair {
    public static void main(String[] args) {
        ReversePair reversePair = new ReversePair();
        reversePair.reversePair(new int[]{2, 4, 3, 5, 1});

    }

    /**
     * i<j nums[i]>2*nums[j]
     *
     * @param nums
     * @return
     */
    public int reversePair(int[] nums) {
        TreeMap<Long, Integer> countMap = new TreeMap<>();
        int result = 0;
        for (int n : nums) {
            countMap.put((long) n, countMap.getOrDefault((long) n, 0) + 1);
        }
        for (int i = nums.length - 1; i >= 0; --i) {
            int total = countMap.get((long) nums[i]);
            --total;
            if (total == 0) {
                countMap.remove((long) nums[i]);
            } else {
                countMap.put((long) nums[i], total);
            }
            Map<Long, Integer> sortedMap = countMap.tailMap(2 * (long) nums[i] + 1);
            for (int k : sortedMap.values()) {
                result += k;
            }
        }
        return result;
    }

    public int reversePairRecursive(int[] nums, int l, int r) {
        if (l == r) {
            return 0;
        } else {
            int mid = l + (r - l) / 2;
            int n1 = reversePairRecursive(nums, l, mid);
            int n2 = reversePairRecursive(nums, l, mid);
            int ret = n1 + n2;
            int i = l, j = mid + 1;
            while (i <= mid) {
                while (j <= r && (long) nums[i] > 2 * nums[j]) {
                    j++;
                }
                ret += j - mid - 1;
                i++;
            }
            int[] sorted = new int[r - l + 1];
            int p1 = l, p2 = mid + 1;
            int p = 0;
            while (p1 <= mid || p2 <= r) {
                if (p1 > mid) {
                    sorted[p++] = nums[p2++];
                } else if (p2 > r) {
                    sorted[p++] = nums[p1++];
                } else {
                    if (nums[p1] < nums[p2]) {
                        sorted[p++] = nums[p1++];
                    } else {
                        sorted[p++] = nums[p2++];
                    }
                }
            }
            for (int k = 0; k < sorted.length; ++k) {
                nums[l + k] = sorted[k];
            }
            return ret;
        }
    }
}
