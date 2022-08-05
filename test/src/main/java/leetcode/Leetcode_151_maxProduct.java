package leetcode;


/**
 * @author zhiqungao@tencent.com
 * @date 2021/11/5 下午2:42
 */
public class Leetcode_151_maxProduct {

    public static void main(String[] args) {
        String[] tokens = new String[]{"2", "1", "+", "3", "*"};
        Leetcode_151_maxProduct l = new Leetcode_151_maxProduct();
        System.out.println(l.maxProduct(new int[]{-1, 0, -2}));
        System.out.println(l.maxProduct(new int[]{2, 3, -2, 4}));
    }

    public int maxProduct(int[] nums) {
        return maxProduct(nums, 0, nums.length - 1);
    }

    public int maxProduct(int[] nums, int l, int r) {
        if (l > r) {
            return 0;
        } else if (l == r) {
            return nums[l];
        }
        for (int i = l; i <= r; ++i) {
            if (nums[i] == 0) {
                return Math.max(Math.max(maxProduct(nums, l, i - 1),
                        maxProduct(nums, i + 1, r)), 0);
            }
        }
        long ans = 0;
        long negCnt = 0;
        long temp = 1;
        for (int i = l; i <= r; ++i) {
            temp *= nums[i];
            ans = Math.max(temp, ans);
            if (nums[i] < 0) {
                ++negCnt;
            }
        }
        int i = l;
        while (negCnt % 2 > 0) {
            temp /= nums[i];
            ans = Math.max(temp, ans);
            if (nums[i] < 0) {
                --negCnt;
            }
            ++i;
        }
        return (int) ans;
    }
}