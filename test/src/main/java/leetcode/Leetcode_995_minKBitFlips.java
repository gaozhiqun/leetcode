package leetcode;

import algorithm.tree.TreeNode;

/**
 * @author zhiqungao@tencent.com
 * @date 2022/3/16 下午3:17
 */
public class Leetcode_995_minKBitFlips {
    public static void main(String[] args) {
        Leetcode_995_minKBitFlips l = new Leetcode_995_minKBitFlips();
    }


    public int minKBitFlips(int[] nums, int k) {
        int N = nums.length;
        int[] diff = new int[N + 1];
        int ans = 0, revCnt = 0;
        for (int i = 0; i < nums.length; ++i) {
            revCnt += diff[i];
            if ((nums[i] + revCnt) % 2 == 0) {
                if (i + k > N) {
                    return -1;
                }
                ++ans;
                ++revCnt;
                --diff[i + k];
            }
        }
        return ans;
    }


}
