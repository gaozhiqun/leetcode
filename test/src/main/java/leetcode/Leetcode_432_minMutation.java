package leetcode;

import java.util.*;

/**
 * @author zhiqungao@tencent.com
 * @date 2021/12/13 下午2:55
 */
public class Leetcode_432_minMutation {
    public static void main(String[] args) {
        Leetcode_432_minMutation l = new Leetcode_432_minMutation();
        System.out.println(l.minMutation("AAAAACCC", "AACCCCCC", new String[]{
                "AAAACCCC", "AAACCCCC", "AACCCCCC"
        }));
        System.out.println(l.minMutation("AACCGGTT", "AAACGGTA", new String[]{
                "AACCGGTA", "AACCGCTA", "AAACGGTA"
        }));

    }

    /**
     * F = G + H
     * G = 从起点 A 移动到指定方格的移动代价，沿着到达该方格而生成的路径。
     * H = 从指定的方格移动到终点 B 的估算成本
     */
    Map<String, List<String>> nbs;

    public int minMutation(String start, String end, String[] bank) {
        nbs = new HashMap<>();
        nbs.computeIfAbsent(start, f -> new ArrayList<>());
        nbs.computeIfAbsent(end, f -> new ArrayList<>());

        for (String c : bank) {
            nbs.computeIfAbsent(c, f -> new ArrayList<>());
            if (isNeighbor(c, start)) {
                nbs.get(c).add(start);
                nbs.get(start).add(c);
            }
            if (isNeighbor(c, end)) {
                nbs.get(c).add(end);
                nbs.get(end).add(c);
            }
        }
        return dfs(start, end, new HashSet<>());

    }

    private int dfs(String src, String end, Set<String> visited) {
        if (src.equals(end)) {
            return 0;
        }
        visited.add(src);
        int ans = 1000_000_007;
        for (String next : nbs.get(src)) {
            if (!visited.contains(next)) {
                int n = dfs(next, end, visited);
                ans = Math.min(ans, n == 1000_000_007 ? 1000_000_007 : n + 1);
            }
        }
        visited.remove(src);
        return ans;
    }

    private boolean isNeighbor(String s, String r) {
        int d = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) != r.charAt(i)) {
                ++d;
            }
        }
        return d == 1;
    }


}

