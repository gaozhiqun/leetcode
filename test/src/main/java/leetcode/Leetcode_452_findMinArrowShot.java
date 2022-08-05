package leetcode;

import java.util.*;

/**
 * @author zhiqungao@tencent.com
 * @date 2021/12/14 上午10:48
 */
public class Leetcode_452_findMinArrowShot {
    public static void main(String[] args) {
        Leetcode_452_findMinArrowShot l = new Leetcode_452_findMinArrowShot();
        System.out.println(l.findMinArrowShots(new int[][]{
                {-2147483646, -2147483645}, {2147483646, 2147483647}
        }));
        System.out.println(l.findMinArrowShots(new int[][]{
                {10, 16}, {2, 8}, {1, 6}, {7, 12}
        }));
        System.out.println(l.findMinArrowShots(new int[][]{
                {1, 2}, {3, 4}, {5, 6}, {7, 8}
        }));
        System.out.println(l.findMinArrowShots(new int[][]{
                {1, 2}, {2, 3}, {3, 4}, {4, 5}
        }));
        System.out.println(l.findMinArrowShots(new int[][]{
                {1, 2}
        }));
        System.out.println(l.findMinArrowShots(new int[][]{
                {2, 3}, {2, 3}
        }));

    }


    public int findMinArrowShots(int[][] points) {
        if (points.length == 0) {
            return 0;
        }
        Arrays.sort(points, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return Integer.compare(o1[1], o2[1]);
            }
        });
        int r = points[0][1];
        int ans = 1;
        for (int i = 1; i < points.length; i++) {
            if (r >= points[i][0]) {
                r = Math.min(r, points[i][1]);
            } else {
                ++ans;
                r = points[i][1];
            }
        }
        return ans;
    }

    public String frequencySort(String s) {
        Map<Character, Integer> map = new HashMap<Character, Integer>();
        int length = s.length();
        for (int i = 0; i < length; i++) {
            char c = s.charAt(i);
            int frequency = map.getOrDefault(c, 0) + 1;
            map.put(c, frequency);
        }
        List<Character> list = new ArrayList<Character>(map.keySet());
        Collections.sort(list, (a, b) -> map.get(b) - map.get(a));
        StringBuffer sb = new StringBuffer();
        int size = list.size();
        for (int i = 0; i < size; i++) {
            char c = list.get(i);
            int frequency = map.get(c);
            for (int j = 0; j < frequency; j++) {
                sb.append(c);
            }
        }
        return sb.toString();
    }

    public int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
        Map<Integer, Integer> cnts1 = new HashMap<>();
        Map<Integer, Integer> cnts2 = new HashMap<>();
        for (int i = 0; i < nums1.length; i++) {
            for (int j = 0; j < nums2.length; j++) {
                int sum = nums1[i] + nums2[j];
                cnts1.put(sum, cnts1.getOrDefault(sum, 0) + 1);
            }
        }

        for (int i = 0; i < nums3.length; i++) {
            for (int j = 0; j < nums4.length; j++) {
                int sum = nums3[i] + nums4[j];
                cnts2.put(sum, cnts2.getOrDefault(sum, 0) + 1);
            }
        }
        int ans = 0;

        for (Map.Entry<Integer, Integer> entry : cnts1.entrySet()) {
            int sum = entry.getKey();
            ans += (entry.getValue() * cnts2.getOrDefault(-sum, 0));
        }
        return ans;

    }


    public boolean find132pattern(int[] nums) {
        int n = nums.length;
        Deque<Integer> candidateK = new LinkedList<Integer>();
        candidateK.push(nums[n - 1]);
        int maxK = Integer.MIN_VALUE;

        for (int i = n - 2; i >= 0; --i) {
            if (nums[i] < maxK) {
                return true;
            }
            while (!candidateK.isEmpty() && nums[i] > candidateK.peek()) {
                maxK = candidateK.pop();
            }
            if (nums[i] > maxK) {
                candidateK.push(nums[i]);
            }
        }

        return false;
    }

    class Solution {
        public boolean circularArrayLoop(int[] nums) {
            int n = nums.length;
            for (int i = 0; i < n; i++) {
                if (nums[i] == 0) {
                    continue;
                }
                int slow = i, fast = next(nums, i);
                // 判断非零且方向相同
                while (nums[slow] * nums[fast] > 0 && nums[slow] * nums[next(nums, fast)] > 0) {
                    if (slow == fast) {
                        if (slow != next(nums, slow)) {
                            return true;
                        } else {
                            break;
                        }
                    }
                    slow = next(nums, slow);
                    fast = next(nums, next(nums, fast));
                }
                int add = i;
                while (nums[add] * nums[next(nums, add)] > 0) {
                    int tmp = add;
                    add = next(nums, add);
                    nums[tmp] = 0;
                }
            }
            return false;
        }

        public int next(int[] nums, int cur) {
            int n = nums.length;
            return ((cur + nums[cur]) % n + n) % n; // 保证返回值在 [0,n) 中
        }
    }


    public int poorPigs(int buckets, int minutesToDie, int minutesToTest) {
        int pigs = 0;
        int maxRound = minutesToTest / minutesToDie + 1;
        while (Math.pow(maxRound, pigs) < buckets) {
            pigs++;
        }
        return pigs;
    }

    public boolean canIWin(int maxChoosableInteger, int desiredTotal) {
        if (maxChoosableInteger >= desiredTotal) {
            return true;
        }
        if ((maxChoosableInteger + 1) * maxChoosableInteger / 2 < desiredTotal) {
            return false;
        }

        Boolean[] dp = new Boolean[1 << maxChoosableInteger];
        return dfs(0, dp, maxChoosableInteger, desiredTotal);
    }

    private boolean dfs(int state, Boolean[] dp, int mx, int de) {
        if (dp[state] != null) {
            return dp[state];
        }
        for (int i = 1; i < mx; i++) {
            int cur = 1 << (i - 1);
            if ((cur & state) != 0) {
                continue;
            }
            if (i >= de || !dfs(cur | state, dp, mx, de - i)) {
                return dp[state] = true;
            }
        }
        return dp[state] = false;
    }

}
