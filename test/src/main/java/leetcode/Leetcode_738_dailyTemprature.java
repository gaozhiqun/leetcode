package leetcode;

import java.util.*;

/**
 * @author zhiqungao@tencent.com
 * @date 2021/11/17 下午8:25
 */
public class Leetcode_738_dailyTemprature {

    public static void main(String[] args) {
        Leetcode_738_dailyTemprature l = new Leetcode_738_dailyTemprature();
        System.out.println(l.deleteAndEarn(new int[]{1, 1, 1, 2, 4, 5, 5, 5, 6}));
        System.out.println(l.deleteAndEarn(new int[]{2, 2, 3, 3, 3, 4}));
        System.out.println(l.dailyTemperatures(new int[]{
                73, 74, 75, 71, 69, 72, 76, 73
        }));
    }

    public int[] dailyTemperatures(int[] temperatures) {
        Deque<Integer> stack = new ArrayDeque<>();
        int[] ret = new int[temperatures.length];
        for (int i = 0; i < temperatures.length; i++) {
            while (!stack.isEmpty() && temperatures[stack.peek()] < temperatures[i]) {
                int pre = stack.pop();
                ret[pre] = i - pre;
            }
            stack.push(i);
        }
        return ret;
    }

    /**
     * 0/1 背包问题
     *
     * @param nums
     * @return
     */
    public int deleteAndEarn(int[] nums) {
        TreeMap<Integer, Integer> cnts = new TreeMap<>();
        for (int i : nums) {
            cnts.put(i, cnts.getOrDefault(i, 0) + 1);
        }
        int idx = 0;
        int[] dp = new int[cnts.size() + 1];
        Map<Integer, Integer> idxMap = new HashMap<>();
        idxMap.put(idx++, -1);
        for (int k : cnts.keySet()) {
            idxMap.put(idx++, k);
        }
        for (int i = 1; i <= cnts.size(); i++) {
            int n = idxMap.get(i);
            int m = cnts.get(n);
            if (idxMap.get(i - 1) != (n - 1)) {
                dp[i] = dp[i - 1] + m * n;
            } else {
                dp[i] = Math.max(dp[i - 2] + m * n, dp[i - 1]);
            }
        }
        return dp[cnts.size()];
    }

}