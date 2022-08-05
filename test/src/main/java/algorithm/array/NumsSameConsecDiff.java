package algorithm.array;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zhiqungao@tencent.com
 * @date 2021/10/25 下午4:53
 */
public class NumsSameConsecDiff {
    public static void main(String[] args) {
        NumsSameConsecDiff numsSameConsecDiff = new NumsSameConsecDiff();
        System.out.println(numsSameConsecDiff.numsSameConsecDiff(2, 0));
        System.out.println(numsSameConsecDiff.numsSameConsecDiff(2, 1));
    }

    public int[] numsSameConsecDiff(int n, int k) {
        List<Integer> result = new ArrayList<>();
        for (int i = 1; i < 10; ++i) {
            bfs(result, n, k, i, 1);
        }
        int t = 0;
        int[] ans = new int[result.size()];
        for (int x : result) {
            ans[t++] = x;
        }
        return ans;
    }

    private void bfs(List<Integer> result, int n, int k, int cur, int m) {
        if (m == n) {
            result.add(cur);
            return;
        }
        if (k == 0) {
            bfs(result, n, k, cur * 10 + cur % 10, m + 1);
        } else {
            int r = cur % 10;
            if (r + k < 10) {
                bfs(result, n, k, cur * 10 + r + k, m + 1);
            }
            if (r - k >= 0) {
                bfs(result, n, k, cur * 10 + r - k, m + 1);
            }
        }
    }

}
