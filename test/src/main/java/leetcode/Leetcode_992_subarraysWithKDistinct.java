package leetcode;

import algorithm.tree.TreeNode;

import java.util.*;

/**
 * @author zhiqungao@tencent.com
 * @date 2022/3/16 下午3:17
 */
public class Leetcode_992_subarraysWithKDistinct {
    public static void main(String[] args) {
        Leetcode_992_subarraysWithKDistinct l = new Leetcode_992_subarraysWithKDistinct();
        System.out.println(l.subarraysWithKDistinct(new int[]{1, 2, 1, 2, 3}, 2));

    }

    public int subarraysWithKDistinct(int[] nums, int k) {
        return atMostKDistinct(nums, k) - atMostKDistinct(nums, k - 1);
    }

    private int atMostKDistinct(int[] A, int K) {
        int N = A.length, l = 0, r = 0, ret = 0, cnt = 0;
        int[] freq = new int[N + 1];
        while (r < N) {
            int cur = A[r];
            if (freq[cur] == 0) {
                ++cnt;
            }
            freq[cur]++;
            ++r;
            while (cnt > K) {
                freq[A[l]]--;
                if (freq[A[l]] == 0) {
                    --cnt;
                }
                ++l;
            }
            ret += r - l;
        }
        return ret;
    }


    public List<Integer> addToArrayForm(int[] num, int k) {
        LinkedList<Integer> ret = new LinkedList<>();
        int i = num.length - 1, carry = 0;
        while (k > 0 || i >= 0) {
            int m;
            if (i >= 0) {
                m = num[i] + k % 10 + carry;
            } else {
                m = k % 10 + carry;
            }
            int n = m % 10;
            carry = m / 10;
            k /= 10;
            --i;
            ret.addFirst(n);
        }
        if (carry != 0) {
            ret.addFirst(carry);
        }
        return ret;
    }
}
