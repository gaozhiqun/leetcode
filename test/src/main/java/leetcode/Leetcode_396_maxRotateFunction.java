package leetcode;

/**
 * @author zhiqungao@tencent.com
 * @date 2021/12/10 上午11:24
 */
public class Leetcode_396_maxRotateFunction {
    public static void main(String[] args) {
        Leetcode_396_maxRotateFunction l = new Leetcode_396_maxRotateFunction();
        System.out.println(l.maxRotateFunction(new int[]{4, 3, 2, 6}));

    }

    /**
     * 0*nums[0] + 1*nums[0];
     * 1*nums[0] + 2*nums[1]....+0*nums[n-1];
     * f(i) = f(i-1)+ n*nums[i-1];
     *
     * @param nums
     * @return
     */

    public int maxRotateFunction(int[] nums) {
        int sum = 0;
        int ans = 0;
        int temp = 0;
        int m = nums.length;
        for (int i = 0; i < m; ++i) {
            sum += nums[i];
            temp += i * nums[i];
        }
        ans = temp;
        for (int i = m - 1; i > 0; --i) {
            temp = temp + sum - m * nums[i];
            ans = Math.max(temp, ans);
        }
        return ans;
    }

}



