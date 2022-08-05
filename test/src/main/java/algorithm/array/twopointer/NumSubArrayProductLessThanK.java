package algorithm.array.twopointer;

/**
 * @author zhiqungao@tencent.com
 * @date 2021/10/28 上午11:43
 */
public class NumSubArrayProductLessThanK {
    public static void main(String[] args) {
        NumSubArrayProductLessThanK numSubArrayProductLessThanK = new NumSubArrayProductLessThanK();
        System.out.println(numSubArrayProductLessThanK.numSubArrayProductLessThanK(new int[]{10, 5, 2, 6}, 100));
    }

    public int numSubArrayProductLessThanK(int[] nums, int k) {
        int product = 1, l = 0, r = 0, N = nums.length, ans = 0;
        while (r < N) {
            product *= nums[r];
            while (product >= k) {
                product /= nums[l];
                ++l;
            }
            ans += r - l + 1;
            r++;
        }
        return ans;
    }

}
