package leetcode;

import java.util.*;

/**
 * @author zhiqungao@tencent.com
 * @date 2021/12/14 上午10:48
 */
public class Leetcode_473_maxSqure {

    public static void main(String[] args) {
        Leetcode_473_maxSqure l = new Leetcode_473_maxSqure();
//        System.out.println(l.makesquare(new int[]{1, 1, 2, 2, 2}));
//        System.out.println(l.makesquare(new int[]{3, 3, 3, 3, 4}));
//        System.out.println(l.findMaxForm(new String[]{"10", "0001", "111001", "1", "0"}, 5, 3));
//        System.out.println(l.findMaxForm(new String[]{"10", "0", "1"}, 1, 1));
        System.out.println(l.findRadius(new int[]{1, 2, 3}, new int[]{2}));
        System.out.println(l.findRadius(new int[]{1, 2, 3, 4}, new int[]{1, 4}));
        System.out.println(l.findRadius(new int[]{1, 5}, new int[]{2}));
        System.out.println(l.findRadius(new int[]{1, 5}, new int[]{10}));

    }

    public boolean makesquare(int[] matchsticks) {
        int sum = 0;
        for (int i : matchsticks) {
            sum += i;
        }
        if (sum % 4 != 0) {
            return false;
        }
        int m = sum / 4;
        return dfs(new int[4], 0, matchsticks, m);
    }

    boolean dfs(int[] len, int i, int[] matchsticks, int m) {
        if (i == matchsticks.length) {
            return true;
        }
        for (int k = 0; k < 4; k++) {
            if (len[k] + matchsticks[i] <= m) {
                len[k] += matchsticks[i];
                if (dfs(len, i + 1, matchsticks, m)) {
                    return true;
                }
                len[k] -= matchsticks[i];
            }
        }
        return false;
    }

    public boolean makesquare2(int[] matchsticks) {
        int sum = 0, len = matchsticks.length, size = 1 << len;
        Arrays.sort(matchsticks);
        for (int matchstick : matchsticks) {
            sum += matchstick;
        }
        int target = sum / 4;
        if (sum % 4 != 0 || matchsticks[len - 1] > sum / 4) {
            return false;
        }
        boolean[] dp = new boolean[size];
        int[] currentSum = new int[size];//状态总长
        dp[0] = true;
        for (int i = 0; i < size; i++) {
            if (!dp[i]) {
                continue;
            }
            for (int j = 0; j < len; j++) {
                if ((i & (1 << j)) != 0) {
                    continue;
                }
                int next = i | (1 << j);
                if (dp[next]) {
                    continue;
                }
                if ((currentSum[i] % target) + matchsticks[j] <= target) {
                    currentSum[next] = currentSum[i] + matchsticks[j];
                    dp[next] = true;
                } else {
                    break;
                }
            }

        }
        // 左移的优先级比-要高
        return dp[size - 1];
    }


    public int findMaxForm(String[] strs, int m, int n) {
        int[][] dp = new int[m + 1][n + 1];
        for (String s : strs) {
            int oCnt = count(s, '1');
            int zCnt = count(s, '0');
            for (int j = m; j >= zCnt; j--) {
                for (int k = n; k >= oCnt; k--) {
                    dp[j][k] = Math.max(dp[j][k], dp[j - zCnt][k - oCnt] + 1);
                }
            }
        }
        return dp[m][n];
    }

    private int count(String s, char ch) {
        int ans = 0;
        for (char cur : s.toCharArray()) {
            if (cur == ch) {
                ++ans;
            }
        }
        return ans;
    }


    public int findRadius(int[] houses, int[] heaters) {
        Arrays.sort(houses);
        Arrays.sort(heaters);
        int i = 0, j = 0, ans = 0; // 双指针
        while (i < houses.length) {
            int minDistance = 0;
            if (j == heaters.length - 1) {
                minDistance = Math.abs(heaters[j] - houses[i++]);
            } else {
                int distance1 = Math.abs(heaters[j] - houses[i]);
                int distance2 = Math.abs(heaters[j + 1] - houses[i]);
                if (distance1 >= distance2) {
                    j++;
                } else {
                    minDistance = distance1;
                    i++;
                }
            }
            ans = Math.max(ans, minDistance);
        }
        return ans;
    }

}
