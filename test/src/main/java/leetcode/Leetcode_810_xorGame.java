package leetcode;

/**
 * @author zhiqungao@tencent.com
 * @date 2021/11/17 下午8:25
 */
public class Leetcode_810_xorGame {

    public static void main(String[] args) {
        Leetcode_810_xorGame l = new Leetcode_810_xorGame();
    }

    /**
     * 1 <= N <= 1000
     * 0 <= nums[i] <= 2^16
     * 按位分组
     */
    public boolean xorGame(int[] nums) {
        int result = 0;
        if (nums.length % 2 == 0) {
            return true;
        }
        for (int i : nums) {
            result ^= i;
        }
        return result == 0;
    }


}