package leetcode;

/**
 * @author zhiqungao@tencent.com
 * @date 2021/12/2 下午9:11
 */
public class Leetcode_330_minPatch {
    public static void main(String[] args) {
        /**
         * [1,2,31,33]
         * 2147483647
         */
        Leetcode_330_minPatch l = new Leetcode_330_minPatch();
        System.out.println(l.minPatches(new int[]{1, 2, 31, 33}, 2147483647));
        System.out.println(l.minPatches(new int[]{1, 3}, 6));
        System.out.println(l.minPatches(new int[]{1, 5, 10}, 20));
        System.out.println(l.minPatches(new int[]{1, 2, 2}, 5));
    }

    /**
     * 给定一个已排序的正整数数组 nums，和一个正整数 n 。从 [1, n] 区间内选取任意个数字补充到 nums 中，使得 [1, n] 区间内的任何数字都可以用 nums 中某几个数字的和来表示。请输出满足上述要求的最少需要补充的数字个数。
     * (1,k) 被覆盖 k+1-> 1,2k+1
     */
    public int minPatches(int[] nums, int n) {
        int ans = 0;
        long cover = 0;
        int idx = 0;
        while (cover < n) {
            while (idx < nums.length && nums[idx] <= cover + 1) {
                cover += nums[idx++];
                if (cover >= n) {
                    return ans;
                }
            }
            cover += cover;
            cover++;
            ans++;
        }
        return ans;
    }
}
