package leetcode;


import algorithm.tree.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author zhiqungao@tencent.com
 * @date 2021/11/5 下午2:42
 */
public class Leetcode_199_robbry {

    public static void main(String[] args) {
        Leetcode_199_robbry l = new Leetcode_199_robbry();
        System.out.println(l.rob(new int[]{2, 7, 9, 3, 1}));
        System.out.println(l.rob2(new int[]{1, 2, 3, 1}));
        System.out.println(l.rob2(new int[]{2, 3, 2}));

    }

    /**
     * 1,2,3,1
     *
     * @param nums
     * @return
     */
    public int rob(int[] nums) {
        int m = nums.length;
        int[] rob = new int[m + 1];
        rob[0] = 0;
        rob[1] = nums[0];
        for (int i = 2; i <= m; ++i) {
            rob[i] = Math.max(rob[i - 2] + nums[i - 1], rob[i - 1]);
        }
        return rob[m];
    }

    /**
     * 环形 rob[0] rob[]
     *
     * @param nums
     * @return
     */
    public int rob2(int[] nums) {
        int m = nums.length;
        int[] robStart = new int[m + 1]; //抢第一家
        int[] robNoStart = new int[m + 1]; // 不抢第一家
        robStart[1] = nums[0];
        robNoStart[1] = 0;
        for (int i = 2; i <= m; ++i) {
            if (i == m) {
                robStart[i] = robStart[i - 1];
            } else {
                robStart[i] = Math.max(robStart[i - 2] + nums[i - 1], robStart[i - 1]);
            }
            robNoStart[i] = Math.max(robNoStart[i - 2] + nums[i - 1], robNoStart[i - 1]);
        }
        return Math.max(robStart[m], robNoStart[m]);
    }

}