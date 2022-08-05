package leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author zhiqungao@tencent.com
 * @date 2022/3/23 下午4:14
 */
public class Leetcode_930_numSubarraysWithSum {
    public static void main(String[] args) {
        Leetcode_930_numSubarraysWithSum l = new Leetcode_930_numSubarraysWithSum();
        System.out.println(l.numSubarraysWithSum(new int[]{0, 0, 0, 0, 0}, 0));
        System.out.println(l.numSubarraysWithSum(new int[]{1, 0, 1, 0, 1}, 2));
    }

    public int numSubarraysWithSum(int[] nums, int goal) {
        Map<Integer, Integer> sums = new HashMap<>();
        int sum = 0, ret = 0;
        for (int i : nums) {
            sum += i;
            if (sum == goal) {
                ++ret;
            }
            ret += sums.getOrDefault(sum - goal, 0);
            sums.put(sum, sums.getOrDefault(sum, 0) + 1);
        }
        return ret;
    }
}
