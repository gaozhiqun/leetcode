package algorithm.array;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Stack;

/**
 * @author zhiqungao@tencent.com
 * @date 2021/10/20 下午3:05
 */
public class NumSybarrayWithSum {
    public static void main(String[] args) {
        NumSybarrayWithSum numSybarrayWithSum = new NumSybarrayWithSum();
        System.out.println(numSybarrayWithSum.numSubarrayWithSum(new int[]{
                1, 0, 1, 0, 1
        }, 2));
    }

    /**
     * leetcode 930 连续的子数组
     *
     * @param nums
     * @param goal
     * @return
     */

    public int numSubarrayWithSum(int[] nums, int goal) {
        int sum = 0;
        Map<Integer, Integer> cnt = new HashMap<Integer, Integer>();
        int ret = 0;
        for (int num : nums) {
            cnt.put(sum, cnt.getOrDefault(sum, 0) + 1);
            sum += num;
            ret += cnt.getOrDefault(sum - goal, 0);
        }
        return ret;

    }

    public int numSubarrayWithSum2(int[] nums, int goal) {
        int ans = 0, L = -1;
        LinkedList<Integer> pos = new LinkedList<>();
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 1) {
                pos.addLast(i);
                if (pos.size() > goal) {
                    L = pos.pollFirst();
                }
            }
            if (pos.size() == goal) {
                ans += pos.getFirst() - L;
            }
        }
        return ans;
    }

}


