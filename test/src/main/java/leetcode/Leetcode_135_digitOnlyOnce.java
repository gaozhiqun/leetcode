package leetcode;


import java.util.PriorityQueue;

/**
 * @author zhiqungao@tencent.com
 * @date 2021/11/5 下午2:42
 */
public class Leetcode_135_digitOnlyOnce {

    public static void main(String[] args) {
        Leetcode_135_digitOnlyOnce l = new Leetcode_135_digitOnlyOnce();
        System.out.println(l.singleNumber(new int[]{0, 1, 0, 1, 0, 1, 99}));
        System.out.println(l.singleNumber(new int[]{2, 2, 3, 2}));
        System.out.println(l.singleNumber(new int[]{30000, 500, 100, 30000, 100, 30000, 100}));
        /**
         * gas  = [1,2,3,4,5]
         * cost = [3,4,5,1,2]
         */

    }

    /**
     * 1 <= nums.length <= 3 * 104
     * -231 <= nums[i] <= 231 - 1
     * nums 中，除某个元素仅出现 一次 外，其余每个元素都恰出现 三次
     * 位运算，不使用额外的空间
     *
     * @param nums
     * @return
     */

    public int singleNumber(int[] nums) {
        int ans = 0;
        for (int i = 0; i < 32; i++) {
            int cnt = 0, mask = 1 << i;
            for (int num : nums) {
                cnt += (num >> i & 1);
            }
            if (cnt % 3 > 0) {
                ans |= mask;
            }
        }
        return ans;
    }
}