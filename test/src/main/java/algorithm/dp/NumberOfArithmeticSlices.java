package algorithm.dp;

import java.util.*;

/**
 * @author zhiqungao@tencent.com
 * @date 2021/7/2 下午2:34
 */
public class NumberOfArithmeticSlices {

    public static void main(String[] args) {
        NumberOfArithmeticSlices numberOfArithmeticSlices = new NumberOfArithmeticSlices();
        System.out.println(numberOfArithmeticSlices.numberOfArithmeticSlicesDp(new int[]{1, 2, 3, 4}));
    }

    public int numberOfArithmeticSlices(int[] nums) {
        int l, mid, result = 0;
        Arrays.sort(nums);
        Set<Integer> numSet = new HashSet<>();
        for (int i : nums) {
            numSet.add(i);
        }
        for (int i = 0; i < nums.length - 2; i++) {
            for (int j = i + 1; j < nums.length - 1; j++) {
                l = nums[i];
                mid = nums[j];
                if (numSet.contains(2 * mid - l)) {
                    result++;
                }
            }
        }
        return result;
    }

    /**
     * dp[j] = dp[j-1] + for(i,k) num[j] -num[k] = 2*num[i];
     *
     * @param nums
     * @return
     */

    public int numberOfArithmeticSlicesDp(int[] nums) {
        if (nums.length < 3) {
            return 0;
        }
        int[] dp = new int[nums.length];
        int sum = 0;
        for (int i = 2; i < nums.length; i++) {
            if (nums[i] + nums[i - 2] == 2 * nums[i - 1]) {
                dp[i] = dp[i - 1] + 1;
                sum += dp[i];
            }
        }
        return sum;
    }

    public int numberOfArithmeticSlicesDp2(int[] nums) {
        int l = nums.length;
        int total = 0;
        Map<Integer, Integer>[] maps = new Map[l];
        for (int i = 0; i < nums.length; i++) {
            maps[i] = new HashMap<>();
            for (int j = 0; j < i; j++) {
                int delta = nums[i] - nums[j];
                int sum = maps[j].getOrDefault(delta, 0);
                int origin = maps[i].getOrDefault(delta, 0);
                maps[i].put(delta, sum + origin + 1);
                total += sum;
            }
        }
        return total;
    }


}
