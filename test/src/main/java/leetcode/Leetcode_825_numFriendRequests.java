package leetcode;


import java.util.*;

/**
 * @author zhiqungao@tencent.com
 * @date 2021/11/17 下午8:25
 */
public class Leetcode_825_numFriendRequests {

    public static void main(String[] args) {
        Leetcode_825_numFriendRequests l = new Leetcode_825_numFriendRequests();
    }

    public int numFriendRequests(int[] ages) {
        int n = ages.length;
        Arrays.sort(ages);
        int left = 0, right = 0, ans = 0;
        for (int age : ages) {
            if (age < 15) {
                continue;
            }
            while (ages[left] <= 0.5 * age + 7) {
                ++left;
            }
            while (right + 1 < n && ages[right + 1] <= age) {
                ++right;
            }
            ans += right - left;
        }
        return ans;
    }

    public int maxProfitAssignment(int[] difficulty, int[] profit, int[] worker) {
        int N = difficulty.length;
        int[][] jobs = new int[N][2];
        for (int i = 0; i < N; ++i) {
            jobs[i][0] = profit[i];
            jobs[i][1] = difficulty[i];
        }
        Arrays.sort(jobs, (o1, o2) -> {
            return o1[1] - o2[1];//难度由低到高
        });
        Arrays.sort(worker);
        int ans = 0, i = 0, best = 0;
        for (int skill : worker) {
            while (i < N && skill >= jobs[i][1]) {
                best = Math.max(best, jobs[i++][0]);
            }
            ans += best;
        }
        return ans;
    }
}