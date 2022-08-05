package algorithm.dp;

import java.util.HashMap;
import java.util.Map;

/**
 * @author zhiqungao@tencent.com
 * @date 2021/8/25 下午8:26
 */
public class CheckSubarraySum {

    public static void main(String[] args) {
        CheckSubarraySum checkSubarraySum = new CheckSubarraySum();
        System.out.println(checkSubarraySum.checkSubarraySum(new int[]{23, 2, 4, 6, 7}, 6));

    }

    /**
     * 前缀和 + Map
     *
     * @param nums
     * @param k
     * @return
     */
    public boolean checkSubarraySum(int[] nums, int k) {
        int m = nums.length;
        if (m < 2) {
            return false;
        }
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        int remainder = 0;
        for (int i = 0; i < m; ++i) {
            remainder = (remainder + nums[i]) % k;
            if (map.containsKey(remainder)) {
                int pre = map.get(remainder);
                if (i - pre >= 2) {
                    return true;
                }
            } else {
                map.put(remainder, i);
            }
        }
        return false;
    }

}
