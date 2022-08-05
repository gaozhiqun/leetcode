package algorithm.array;

import java.util.HashSet;
import java.util.Set;

/**
 * @author zhiqungao@tencent.com
 * @date 2021/4/14 9:23 下午
 */
public class LongestSubArray {
    /**
     * 最长连续子序列 并查集
     */

    public int longestSubArray(int[] array) {
        Set<Integer> set = new HashSet<>();
        for (int i : array) {
            set.add(i);
        }
        int result = 0;
        for (int i : set) {
            if (!set.contains(i - 1)) {
                int cur = i;
                int temp = 1;
                while (set.contains(cur + 1)) {
                    cur += 1;
                    temp += 1;
                }
                result = Math.max(result, temp);
            }
        }
        return result;
    }

}
