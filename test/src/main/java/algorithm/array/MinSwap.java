package algorithm.array;

/**
 * @author zhiqungao@tencent.com
 * @date 2021/9/26 下午2:21
 */
public class MinSwap {
    /**
     * 801 使两个数组有序的最小交换次数
     */


    public static void main(String[] args) {

    }

    public int minSwap(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n1 = 0, s1 = 1;
        for (int i = 1; i <= m; ++i) {
            int n2 = Integer.MAX_VALUE, s2 = Integer.MAX_VALUE;
            if (nums1[i] > nums1[i - 1] || nums2[i] > nums2[i - 1]) {
                n2 = Math.min(n2, n1);
                s2 = Math.min(s2, s1 + 1);
            }
            if (nums1[i] > nums2[i - 1] || nums2[i] > nums1[i - 1]) {
                n2 = Math.min(n2, s1);
                s2 = Math.min(s2, n1 + 1);
            }
            n1 = n2;
            s1 = s2;
        }
        return Math.min(n1, s1);
    }

}
