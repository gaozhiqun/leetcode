package leetcode;

import java.util.List;
import java.util.TreeMap;

/**
 * @author zhiqungao@tencent.com
 * @date 2022/1/17 上午10:53
 */
public class Leetcode_798_bestRotation {
    public static void main(String[] args) {
        Leetcode_798_bestRotation l = new Leetcode_798_bestRotation();
    }


    /**
     * 任何值小于或等于其索引的项都可以记作一分
     * A 的长度最大为 20000。
     * A[i] 的取值范围是 [0, A.length]。
     */


    public int bestRotation(int[] nums) {
        int N = nums.length;
        int[] contributes = new int[N];
        for (int i = 0; i < nums.length; i++) {
            int l = (i - nums[i] + 1 + N) % N;
            int r = (i + 1) % N;
            contributes[l]--;
            contributes[r]++;
            if (l > r) {
                contributes[0]++;
            }
        }
        int ans = 0, best = -N, cur = 0;
        for (int i = 0; i < nums.length; ++i) {
            cur += contributes[i];
            if (cur > best) {
                best = cur;
                ans = i;
            }
        }
        return ans;
    }
}
