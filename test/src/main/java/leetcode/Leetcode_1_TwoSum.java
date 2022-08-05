package leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author zhiqungao@tencent.com
 * @date 2021/10/29 上午10:49
 */
public class Leetcode_1_TwoSum {
    public static void main(String[] args) {
        Leetcode_1_TwoSum leetcode_1_twoSum = new Leetcode_1_TwoSum();
        System.out.println(leetcode_1_twoSum.twoSum(new int[]{2, 7, 11, 15}, 9));
    }

    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target - nums[i])) {
                return new int[]{i, map.get(target - nums[i])};
            }
            map.put(nums[i], i);
        }
        return null;
    }
}
