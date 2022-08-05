package leetcode;


import java.util.*;

/**
 * @author zhiqungao@tencent.com
 * @date 2021/11/5 下午2:42
 */
public class Leetcode_127_longestConsecutive {
    public static void main(String[] args) {
        Leetcode_127_longestConsecutive l = new Leetcode_127_longestConsecutive();
        System.out.println(l.longestConsecutive(new int[]{100, 4, 200, 1, 3, 2}));
        System.out.println(l.longestConsecutive(new int[]{0, 3, 7, 2, 5, 8, 4, 6, 0, 1}));
    }

    /**
     * 输入：nums = [100,4,200,1,3,2]
     * O(n) 的算法
     * 0 <= nums.length <= 105
     * -109 <= nums[i] <= 109
     */

    public int longestConsecutive(int[] nums) {
        int ans = 0;
        if (nums.length == 0) {
            return 0;
        }
        Map<Integer, Boolean> indexMap = new HashMap<>();
        for (int i : nums) {
            indexMap.put(i, true);
        }
        for (int i : nums) {
            int l = i, r = i + 1;
            while (indexMap.getOrDefault(l, false)) {
                indexMap.put(l, false);
                --l;
            }
            while (indexMap.getOrDefault(r, false)) {
                indexMap.put(r, false);
                ++r;
            }
            ans = Math.max(r - l - 1, ans);
        }
        return ans;
    }

}
