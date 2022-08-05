package leetcode;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.Stack;
import java.util.TreeMap;

/**
 * @author zhiqungao@tencent.com
 * @date 2021/11/17 下午7:07
 */
public class Leetcode_239_maxSlidingWindow {
    public static void main(String[] args) {
        Leetcode_239_maxSlidingWindow l = new Leetcode_239_maxSlidingWindow();
        System.out.println(l.maxSlidingWindow2(new int[]{-7, -8, 7, 5, 7, 1, 6, 0}, 4));
        System.out.println(l.maxSlidingWindow2(new int[]{1, 3, 1, 2, 0, 5}, 3));
        System.out.println(l.maxSlidingWindow2(new int[]{1, 3, -1, -3, 5, 3, 6, 7}, 3));
    }


    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        if (k > n) {
            return null;
        } else if (k == 1) {
            return nums;
        }
        int[] ans = new int[n - k + 1];
        TreeMap<Integer, Integer> cnts = new TreeMap<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return Integer.compare(o2, o1);
            }
        });
        for (int i = 0; i < nums.length; i++) {
            cnts.put(nums[i], cnts.getOrDefault(nums[i], 0) + 1);
            if (i == k - 1) {
                ans[i - k + 1] = cnts.firstKey();
            } else if (i >= k) {
                int cnt = cnts.get(nums[i - k]);
                --cnt;
                if (cnt == 0) {
                    cnts.remove(nums[i - k]);
                } else {
                    cnts.put(nums[i - k], cnt);
                }
                ans[i - k + 1] = cnts.firstKey();
            }
        }
        return ans;
    }

    public int[] maxSlidingWindow2(int[] nums, int k) {
        LinkedList<int[]> q = new LinkedList<>();
        int n = nums.length;
        if (k > n) {
            return null;
        } else if (k == 1) {
            return nums;
        }
        int[] ans = new int[n - k + 1];
        int j = 0;

        for (int i = 0; i < nums.length; i++) {
            if (i >= k && i - k == q.peekFirst()[0]) {
                q.removeFirst();
            }
            while (!q.isEmpty() && q.peekLast()[1] <= nums[i]) {
                q.removeLast();
            }
            q.addLast(new int[]{i, nums[i]});
            if (i >= k - 1) {
                ans[j++] = q.peekFirst()[1];
            }
        }
        return ans;
    }
}
