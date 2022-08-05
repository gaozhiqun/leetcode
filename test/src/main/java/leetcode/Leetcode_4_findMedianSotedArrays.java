package leetcode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author zhiqungao@tencent.com
 * @date 2021/10/29 上午11:47
 */
public class Leetcode_4_findMedianSotedArrays {

    public static void main(String[] args) {
        Leetcode_4_findMedianSotedArrays l = new Leetcode_4_findMedianSotedArrays();
        System.out.println(l.findMedianSortedArrays(new int[]{1}, new int[]{1}));
        System.out.println(l.findMedianSortedArrays(new int[]{1, 3}, new int[]{2}));
        System.out.println(l.findMedianSortedArrays(new int[]{1, 2}, new int[]{3, 4}));
        System.out.println(l.findMedianSortedArrays(new int[]{}, new int[]{1}));
        System.out.println(l.findMedianSortedArrays(new int[]{2}, new int[]{}));
        System.out.println(l.findMedianSortedArrays(new int[]{0, 0}, new int[]{0, 0}));
    }

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length, n = nums2.length, i = 0, j = 0;
        int l = 0, r = 0, k = 0, li, lr;
        if ((m + n) % 2 == 0) {
            li = (m + n) / 2;
            lr = (m + n) / 2 + 1;
        } else {
            li = lr = (m + n) / 2 + 1;
        }
        if (nums1.length == 0) {
            l = nums2[li - 1];
            r = nums2[lr - 1];
        } else if (nums2.length == 0) {
            l = nums1[li - 1];
            r = nums1[lr - 1];
        } else {
            while (k < lr) {
                int next;
                ++k;
                if (i < m && j < n) {
                    if (nums1[i] < nums2[j]) {
                        next = nums1[i++];
                    } else {
                        next = nums2[j++];
                    }
                } else if (i < m) {
                    next = nums1[i++];
                } else {
                    next = nums2[j++];
                }
                if (k == li) {
                    l = next;
                }
                if (k == lr) {
                    r = next;
                }
            }
        }
        return ((double) l + r) / 2;
    }
}
