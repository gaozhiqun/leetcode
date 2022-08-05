package leetcode;


import algorithm.tree.TreeNode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * @author zhiqungao@tencent.com
 * @date 2021/12/14 上午10:48
 */
public class Leetcode_560_subarraySum {


    public static void main(String[] args) {
        Leetcode_560_subarraySum leetcode_560_subarraySum = new Leetcode_560_subarraySum();
        System.out.println(leetcode_560_subarraySum.subarraySum(new int[]{-1, -1, 1}, 0));
        System.out.println(leetcode_560_subarraySum.subarraySum(new int[]{1}, 0));
        System.out.println(leetcode_560_subarraySum.subarraySum(new int[]{1, 1, 1}, 2));
        System.out.println(leetcode_560_subarraySum.subarraySum(new int[]{1, 2, 3}, 3));

    }

    public int subarraySum(int[] nums, int k) {
        Map<Integer, Integer> preSumCnts = new HashMap<>();
        int sum = 0, ans = 0;
        for (int i : nums) {
            sum += i;
            if (sum == k) {
                ++ans;
            }
            ans += preSumCnts.getOrDefault(sum - k, 0);
            preSumCnts.put(sum, preSumCnts.getOrDefault(sum, 0) + 1);
        }
        return ans;
    }

}