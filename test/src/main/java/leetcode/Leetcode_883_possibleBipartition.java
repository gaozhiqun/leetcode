package leetcode;

import java.util.*;

/**
 * @author zhiqungao@tencent.com
 * @date 2022/2/21 下午4:33
 */
public class Leetcode_883_possibleBipartition {
    public static void main(String[] args) {
        Leetcode_883_possibleBipartition l = new Leetcode_883_possibleBipartition();
    }

    Map<Integer, Integer> color;
    List<Integer>[] nbs;

    public boolean possibleBipartition(int n, int[][] dislikes) {
        nbs = new List[n + 1];
        for (int i = 0; i <= n; ++i) {
            nbs[i] = new ArrayList();
        }
        for (int[] dislike : dislikes) {
            nbs[dislike[0]].add(dislike[1]);
            nbs[dislike[1]].add(dislike[0]);
        }
        color = new HashMap();
        for (int node = 1; node <= n; ++node) {
            if (!color.containsKey(node) && !dfs(node, 0)) {
                return false;
            }
        }
        return true;
    }

    public boolean dfs(int i, int c) {
        if (color.containsKey(i)) {
            return color.get(i) == c;
        }
        color.put(i, c);
        for (int nei : nbs[i]) {
            if (!dfs(nei, c ^ 1)) {
                return false;
            }
        }
        return true;
    }
}
