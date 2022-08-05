/**
 * @author zhiqungao@tencent.com
 * @date 2021/1/26 8:03 下午
 */
public class TopKthElement {
    public static void main(String[] args) {
        TopKthElement topKthElement = new TopKthElement();
        System.out.println(topKthElement.findKthElement(new int[]{10, 10, 9, 9, 8, 7, 5, 6, 4, 3, 4, 2}, 3));
    }

    public int findKthElement(int[] nums, int k) {
        k = nums.length - k;
        int l = 0, h = nums.length - 1;
        while (l < h) {
            int j = partition(nums, l, h);
            if (j == k) {
                break;
            } else if (j < k) {
                l = j + 1;
            } else {
                h = j - 1;
            }
        }
        return nums[k];
    }

    /**
     *基于快排
     * @param a
     * @param l
     * @param r
     * @return
     */

    public int partition(int[] a, int l, int r) {
        int i = l;
        int j = r + 1;
        while (i < j) {
            while (++i < r && a[i] <= a[l]) ;
            while (--j > l && a[j] > a[l]) ;
            swap(a, i, j);
        }
        swap(a, l, j);
        return j;
    }

    public void swap(int[] a, int l, int r) {
        int temp = a[l];
        a[l] = a[r];
        a[r] = temp;
    }
}
