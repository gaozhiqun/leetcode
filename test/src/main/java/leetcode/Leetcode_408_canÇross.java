package leetcode;

import java.util.*;

/**
 * @author zhiqungao@tencent.com
 * @date 2021/12/10 上午11:24
 */
public class Leetcode_408_canÇross {
    public static void main(String[] args) {
        Leetcode_408_canÇross l = new Leetcode_408_canÇross();

        System.out.println(l.canCross(new int[]{
                0, 2
        }));

        System.out.println(l.canCross(new int[]{
                0, 1, 3, 5, 6, 8, 12, 17
        }));
        System.out.println(l.canCross(new int[]{
                0, 1, 2, 3, 4, 8, 9, 11
        }));

    }

    /**
     * k - 1、k 或 k + 1
     * 第一步只能跳跃一个单位
     */
    Map<Integer, Map<Integer, Boolean>> visited;
    Set<Integer> stoneSet;

    public boolean canCross(int[] stones) {
        int m = stones.length;
        int target = stones[m - 1];
        visited = new HashMap<>();
        stoneSet = new HashSet<>();
        for (int i : stones) {
            visited.put(i, new HashMap<>());
            stoneSet.add(i);
        }
        return dfs(0, target, 0);
    }

    private boolean dfs(int cur, int target, int jump) {
        if (cur == target) {
            return true;
        }
        if (visited.get(cur).containsKey(jump)) {
            return visited.get(cur).get(jump);
        }
        boolean ans = false;
        for (int j = -1; j <= 1; ++j) {
            if (jump + j <= 0) {
                continue;
            }
            int next = cur + jump + j;
            if (stoneSet.contains(next)) {
                ans |= dfs(next, target, jump + j);
            }
        }
        visited.get(cur).put(jump, ans);
        return ans;
    }


}



