package leetcode;


import java.util.*;

/**
 * @author zhiqungao@tencent.com
 * @date 2021/11/5 下午2:42
 */
public class Leetcode_131_partition {

    public static void main(String[] args) {
        Leetcode_131_partition l = new Leetcode_131_partition();
        System.out.println(l.partition("aab"));
        System.out.println(l.partition("a"));
        System.out.println(l.minCut("aab"));
        System.out.println(l.minCut("a"));
        System.out.println(l.minCut("ab"));

    }


    public List<List<String>> partition(String s) {
        if ("".equals(s)) {
            return new ArrayList<>();
        }
        Map<Integer, List<String>> idxPalidromeMap = new HashMap<>();
        int m = s.length();
        for (int i = 0; i < m; ++i) {
            List<String> list = new ArrayList<>();
            idxPalidromeMap.put(i, list);
            spread(s, i, i, idxPalidromeMap);
            spread(s, i, i + 1, idxPalidromeMap);
        }
        List<List<String>> ans = new ArrayList<>();
        List<String> temp = new ArrayList<>();
        bfs(0, m, idxPalidromeMap, temp, ans);
        return ans;
    }

    private void spread(String s, int l, int r, Map<Integer, List<String>> idxPalidromeMap) {
        while (l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)) {
            idxPalidromeMap.get(l).add(s.substring(l, r + 1));
            l--;
            r++;
        }
    }

    private void bfs(int cur, int n, Map<Integer, List<String>> idxPalidromeMap, List<String> temp, List<List<String>> ans) {
        if (cur >= n) {
            ans.add(new ArrayList<>(temp));
            return;
        }
        for (String s : idxPalidromeMap.get(cur)) {
            temp.add(s);
            bfs(cur + s.length(), n, idxPalidromeMap, temp, ans);
            temp.remove(temp.size() - 1);
        }
    }

    //"|a|a|b"
    public int minCut(String s) {
        int m = s.length();
        int[] dp = new int[m + 1];
        Map<Integer, List<Integer>> idxMap = new HashMap<>();
        for (int i = m - 1; i >= 0; --i) {
            List<Integer> list = new ArrayList<>();
            idxMap.put(i, list);
            spreadByR(s, i, i, idxMap);
            spreadByR(s, i, i + 1, idxMap);
        }
        for (int i = 1; i <= m; ++i) {
            dp[i] = i;
            for (int len : idxMap.get(i - 1)) {
                dp[i] = Math.min(dp[i - len] + 1, dp[i]);
            }
        }
        return dp[m] - 1;
    }

    private void spreadByR(String s, int l, int r, Map<Integer, List<Integer>> idxMap) {
        while (l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)) {
            idxMap.get(r).add(r - l + 1);
            l--;
            r++;
        }
    }
}