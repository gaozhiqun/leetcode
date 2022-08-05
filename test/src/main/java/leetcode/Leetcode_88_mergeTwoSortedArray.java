package leetcode;


/**
 * @author zhiqungao@tencent.com
 * @date 2021/11/1 下午7:35
 */
public class Leetcode_88_mergeTwoSortedArray {

    /**
     * 输入：s1 = "great", s2 = "rgeat""abcdefghijklmnopq"
     * "efghijklmnopqcadb"
     *
     * @param args
     */
    public static void main(String[] args) {
        Leetcode_88_mergeTwoSortedArray l = new Leetcode_88_mergeTwoSortedArray();
        int[] array = new int[]{0};
        l.merge(array, 0, new int[]{1}, 1);
        System.out.println(array.toString());
    }

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int i = m - 1, j = n - 1, k = m + n - 1;
        while (i >= 0 && j >= 0) {
            if (nums1[i] < nums2[j]) {
                nums1[k--] = nums2[j--];
            } else {
                nums1[k--] = nums1[i--];
            }
        }
        if (j >= 0) {
            System.arraycopy(nums2, 0, nums1, 0, j + 1);
        }
    }


}
