package leetcode;

import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

/**
 * @author zhiqungao@tencent.com
 * @date 2021/11/17 下午8:25
 */
public class Leetcode_264_missingNum {
    public static void main(String[] args) {
        Leetcode_264_missingNum l = new Leetcode_264_missingNum();
        System.out.println(l.missingNumber(new int[]{
                9, 6, 4, 2, 3, 5, 7, 0, 1
        }));
        System.out.println(l.missingNumber(new int[]{
                3, 0, 1
        }));
        System.out.println(l.missingNumber(new int[]{
                0
        }));
        System.out.println(l.missingNumber(new int[]{
                0, 1
        }));

    }

    /**
     * 丑数 就是只包含质因数 2、3 和/或 5 的正整数。
     *
     * @param n
     * @return
     */

    public int missingNumber(int[] nums) {
        int m = nums.length;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == i || nums[i] == m) {
                continue;
            }
            int cur = i;
            while (nums[cur] != cur && nums[cur] != m) {
                int temp = nums[cur];
                nums[cur] = nums[temp];
                nums[temp] = temp;
            }
        }
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != i) {
                return i;
            }
        }
        return m;

    }


}
