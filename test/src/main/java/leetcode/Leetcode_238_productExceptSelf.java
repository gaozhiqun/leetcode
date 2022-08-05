package leetcode;

/**
 * @author zhiqungao@tencent.com
 * @date 2021/11/17 下午4:53
 */
public class Leetcode_238_productExceptSelf {
    public static void main(String[] args) {
        Leetcode_238_productExceptSelf l = new Leetcode_238_productExceptSelf();
        System.out.println(l.productExceptSelf(new int[]{
                1, 2, 3, 4
        }));

    }

    public int[] productExceptSelf(int[] nums) {
        int m = nums.length;
        if (m == 1) {
            return new int[]{1};
        }
        int[] l = new int[m];
        l[0] = 1;
        int[] r = new int[m];
        r[m - 1] = 1;
        for (int i = 1; i < nums.length; ++i) {
            l[i] = l[i - 1] * nums[i - 1];
            r[m - i - 1] = r[m - i] * nums[m - i];
        }
        int[] ans = new int[m];
        for (int i = 0; i < m; ++i) {
            ans[i] = l[i] * r[i];
        }
        return ans;
    }
}
