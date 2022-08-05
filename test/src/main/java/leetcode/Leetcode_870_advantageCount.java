package leetcode;

import java.util.*;

/**
 * @author zhiqungao@tencent.com
 * @date 2022/1/28 下午4:11
 */
public class Leetcode_870_advantageCount {
    public static void main(String[] args) {
        Leetcode_870_advantageCount l = new Leetcode_870_advantageCount();
        System.out.println(l.advantageCount(new int[]{2, 7, 11, 15}, new int[]{1, 10, 4, 11}));
        System.out.println(l.advantageCount(new int[]{2, 7, 11, 15}, new int[]{1, 10, 4, 11}));

    }

    /**
     * A[i] > B[i]
     *
     * @param nums1
     * @param nums2
     * @return
     */
    public int[] advantageCount(int[] nums1, int[] nums2) {
        int m = nums2.length;
        int[] ret = new int[m];
        Arrays.sort(nums1);
        Map<Integer, Deque<Integer>> indexMap = new HashMap();
        for (int b : nums2) {
            indexMap.put(b, new LinkedList());
        }
        for (int i = 0; i < m; ++i) {
            indexMap.get(nums2[i]).offer(i);
        }
        Arrays.sort(nums2);
        int l = 0, r = m - 1;
        for (int i = m - 1; i >= 0; --i) {
            if (nums1[r] > nums2[i]) {
                ret[indexMap.get(nums2[i]).poll()] = nums1[r--];
            } else {
                ret[indexMap.get(nums2[i]).poll()] = nums1[l++];
            }
        }
        return ret;
    }
}
