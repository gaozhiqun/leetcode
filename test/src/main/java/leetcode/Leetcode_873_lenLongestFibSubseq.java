package leetcode;

import algorithm.tree.TreeNode;

import java.util.HashSet;
import java.util.Set;

/**
 * @author zhiqungao@tencent.com
 * @date 2022/1/28 下午4:11
 */
public class Leetcode_873_lenLongestFibSubseq {
    public static void main(String[] args) {
        Leetcode_873_lenLongestFibSubseq l = new Leetcode_873_lenLongestFibSubseq();
    }

    /**
     * 输入: arr = [1,2,3,4,5,6,7,8]
     * 输出: 5
     * 解释: 最长的斐波那契式子序列为 [1,2,3,5,8] 。
     * n >= 3
     * 对于所有 i + 2 <= n，都有 X_i + X_{i+1} = X_{i+2}
     */
    public int lenLongestFibSubseq(int[] arr) {
        int ret = 0;
        int N = arr.length;
        Set<Integer> set = new HashSet();
        for (int x : arr) {
            set.add(x);
        }
        for (int i = 0; i < N; ++i) {
            for (int j = i + 1; j < N; ++j) {
                int x = arr[j], y = arr[i] + arr[j];
                int length = 2;
                while (set.contains(y)) {
                    int tmp = y;
                    y += x;
                    x = tmp;
                    ret = Math.max(ret, ++length);
                }
            }
        }
        return ret >= 3 ? ret : 0;
    }


}
