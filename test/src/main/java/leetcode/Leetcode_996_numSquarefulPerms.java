package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author zhiqungao@tencent.com
 * @date 2022/3/17 下午7:11
 */
public class Leetcode_996_numSquarefulPerms {

    public static void main(String[] args) {

    }

    int N;
    Map<Integer, Integer> cntsMap;
    Map<Integer, List<Integer>> nbMap;

    public int numSquarefulPerms(int[] nums) {
        N = nums.length;
        cntsMap = new HashMap<>();
        nbMap = new HashMap<>();
        for (int i : nums) {
            cntsMap.put(i, cntsMap.getOrDefault(i, 0) + 1);
        }
        List<Integer> keys = new ArrayList<>(cntsMap.keySet());
        for (int x : cntsMap.keySet()) {
            nbMap.put(x, new ArrayList());

        }

        for (int x : cntsMap.keySet()) {
            for (int y : cntsMap.keySet()) {
                int r = (int) (Math.sqrt(x + y) + 0.5);
                if (r * r == x + y) {
                    nbMap.get(x).add(y);
                }
            }
        }
        int ans = 0;
        for (int x : cntsMap.keySet()) {
            ans += dfs(x, N - 1);
        }
        return ans;
    }

    private int dfs(int x, int todo) {
        cntsMap.put(x, cntsMap.get(x) - 1);
        int ans = 1;
        if (todo != 0) {
            ans = 0;
            for (int y : nbMap.get(x)) {
                if (cntsMap.get(y) != 0) {
                    ans += dfs(y, todo - 1);
                }
            }
        }
        cntsMap.put(x, cntsMap.get(x) + 1);
        return ans;
    }
}
