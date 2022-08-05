package algorithm.array;

import java.util.Arrays;

/**
 * @author zhiqungao@tencent.com
 * @date 2021/7/6 下午9:24
 */
public class MinMove {
    public static void main(String[] args) {
        MinMove minMove = new MinMove();
        System.out.println(minMove.minMove(new int[]{1, 2, 3}));

    }

    public int minMove(int[] nums) {
        Arrays.sort(nums);
        int result = 0, l = 0, r = nums.length - 1;
        while (l < r) {
            result += nums[r--] - nums[l++];
        }
        return result;
    }

}
