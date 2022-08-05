package leetcode;


import java.util.*;

/**
 * @author zhiqungao@tencent.com
 * @date 2021/12/14 上午10:48
 */
public class Leetcode_525_checkSubarraySum {


    public static void main(String[] args) {
        Leetcode_525_checkSubarraySum l = new Leetcode_525_checkSubarraySum();
        System.out.println(l.checkSubarraySum(new int[]{23, 2, 4, 6, 7}, 6));
        System.out.println(l.checkSubarraySum(new int[]{23, 2, 6, 4, 7}, 13));
        System.out.println(l.checkSubarraySum(new int[]{5, 0, 0, 0}, 3));
        System.out.println(l.checkSubarraySum(new int[]{1, 2, 12}, 6));
    }

    public boolean checkSubarraySum(int[] nums, int k) {
        int m = nums.length;
        if (m < 2) {
            return false;
        }
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        map.put(0, -1);
        int remainder = 0;
        for (int i = 0; i < m; i++) {
            remainder = (remainder + nums[i]) % k;
            if (map.containsKey(remainder)) {
                int prevIndex = map.get(remainder);
                if (i - prevIndex >= 2) {
                    return true;
                }
            } else {
                map.put(remainder, i);
            }
        }
        return false;
    }


}