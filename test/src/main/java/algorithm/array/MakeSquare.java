package algorithm.array;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author zhiqungao@tencent.com
 * @date 2021/7/22 下午4:22
 */
public class MakeSquare {
    public static void main(String[] args) {

    }

    public boolean makeSquare(int[] matches) {
        int total = 0, target;
        for (int match : matches) {
            total += match;
        }
        if (total % 4 != 0) {
            return false;
        }
        target = total / 4;
        int[] edges = new int[4];
        return dfs(edges, 0, target, matches);
    }

    private boolean dfs(int[] edges, int cur, int target, int[] matches) {
        boolean result = false;
        if (cur == matches.length) {
            return true;
        }
        for (int i = 0; i < edges.length; i++) {
            if (edges[i] + matches[cur] <= target) {
                int[] newEdges = new int[4];
                newEdges[i] += matches[cur];
                System.arraycopy(edges, 0, newEdges, 0, edges.length);
                result = result || dfs(newEdges, cur + 1, target, matches);
            }
        }
        return result;
    }
}
