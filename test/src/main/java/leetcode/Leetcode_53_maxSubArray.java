package leetcode;


/**
 * @author zhiqungao@tencent.com
 * @date 2021/11/1 下午7:35
 */
public class Leetcode_53_maxSubArray {

    public static void main(String[] args) {
        Leetcode_53_maxSubArray l = new Leetcode_53_maxSubArray();
        System.out.println(l.maxSubArray(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4}));

    }


    public int maxSubArray(int[] nums) {
        int ans = Integer.MIN_VALUE, sum = 0;
        for (int i : nums) {
            sum += i;
            ans = Math.max(ans, sum);
            if (sum < 0) {
                sum = 0;
            }
        }
        return ans;
    }
}
