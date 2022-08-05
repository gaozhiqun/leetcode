package leetcode;

/**
 * @author zhiqungao@tencent.com
 * @date 2022/6/28 上午10:12
 */
public class Leetcode_1909_canBeIncreasing {

    public boolean canBeIncreasing(int[] nums) {
        int cnt = 0;
        for (int i = 1; i < nums.length; ++i) {
            if (nums[i] > nums[i - 1]) {
                continue;
            } else {
                ++cnt;
                if (i == 1 || nums[i - 2] < nums[i]) {
                    nums[i - 1] = nums[i];
                } else {
                    nums[i] = nums[i - 1];
                }
            }
        }
        return cnt <= 1;
    }

}
