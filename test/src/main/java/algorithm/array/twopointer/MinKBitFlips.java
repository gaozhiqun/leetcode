package algorithm.array.twopointer;

/**
 * @author zhiqungao@tencent.com
 * @date 2021/10/28 下午5:28
 */
public class MinKBitFlips {
    public static void main(String[] args) {

    }

    public int minBitFlips(int[] nums, int k) {
        int m = nums.length;
        int[] diff = new int[m + 1];
        int ans = 0, rev = 0;
        for (int i = 0; i < m; ++i) {
            rev += diff[i];
            if ((nums[i] + rev) % 2 == 0) {
                if ((i + k) > m) {
                    return -1;
                }
                ++ans;
                ++rev;
                --diff[i + k];
            }
        }
        return ans;
    }
}
