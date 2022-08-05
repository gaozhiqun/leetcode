package leetcode;

/**
 * @author zhiqungao@tencent.com
 * @date 2021/12/14 上午10:48
 */
public class Leetcode_486_predictWinner {

    public static void main(String[] args) {
        Leetcode_486_predictWinner l = new Leetcode_486_predictWinner();
        System.out.println(l.predictTheWinner2(new int[]{
                1, 5, 2
        }));
        System.out.println(l.predictTheWinner2(new int[]{
                1, 5, 233, 7
        }));

    }

    public boolean predictTheWinner(int[] nums) {
        return pick(nums, 0, nums.length - 1) > 0;
    }

    public int pick(int[] nums, int l, int r) {
        if (l == r) {
            return nums[l];
        }
        return Math.max(nums[l] - pick(nums, l + 1, r), nums[r] - pick(nums, l, r - 1));
    }

    public boolean predictTheWinner2(int[] nums) {
        int length = nums.length;
        int[][] dp = new int[length][length];
        for (int i = 0; i < length; i++) {
            dp[i][i] = nums[i];
        }
        for (int i = length - 2; i >= 0; i--) {
            for (int j = i + 1; j < length; j++) {
                dp[i][j] = Math.max(nums[i] - dp[i + 1][j], nums[j] - dp[i][j - 1]);
            }
        }
        return dp[0][length - 1] >= 0;
    }

}
