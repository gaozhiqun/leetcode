package leetcode;


import java.util.*;

/**
 * @author zhiqungao@tencent.com
 * @date 2022/6/29 下午9:13
 */
public class Leetcode_1311_watchedVideosByFriends {
    public static void main(String[] args) {
        Leetcode_1311_watchedVideosByFriends l = new Leetcode_1311_watchedVideosByFriends();
        System.out.println(l.printVertically("TO BE OR NOT TO BE"));
    }


    public List<String> watchedVideosByFriends(List<List<String>> watchedVideos, int[][] friends, int id, int level) {
        //bfs找到level好友
        Deque<Integer> q = new ArrayDeque<>();
        q.addLast(id);
        int size = q.size();
        //用于记录防止重复
        Set<Integer> set = new HashSet<>();
        set.add(id);
        while (level > 0) {
            int i = q.pollFirst();
            for (int a : friends[i]) {
                if (!set.contains(a)) {
                    set.add(a);
                    q.addLast(a);
                }
            }
            size--;
            if (size == 0) {
                level--;
                size = q.size();
            }
        }
        //哈希表-记录level朋友观看的视频
        Map<String, Integer> map = new HashMap<>();
        while (!q.isEmpty()) {
            int i = q.pollFirst();
            for (String s : watchedVideos.get(i)) {
                if (map.containsKey(s))
                    map.put(s, map.get(s) + 1);
                else map.put(s, 1);
            }
        }
        List<String> list = new ArrayList<>(map.keySet());
        //排序
        list.sort((a, b) -> {
            if (map.get(a) == map.get(b)) {
                int i = 0;
                while (true) {
                    if (a.charAt(i) != b.charAt(i))
                        return a.charAt(i) - b.charAt(i);
                    else {
                        i++;
                        if (i >= Math.min(a.length(), b.length())) {
                            return a.length() - b.length();
                        }
                    }
                }

            }
            return map.get(a) - map.get(b);
        });
        return list;
    }


    public int[][] matrixBlockSum(int[][] mat, int k) {
        int m = mat.length, n = mat[0].length;
        int[][] sums = new int[m + 1][n + 1];
        int[][] ret = new int[m][n];
        for (int i = 1; i <= m; ++i) {
            for (int j = 1; j <= n; ++j) {
                sums[i][j] += sums[i - 1][j] + sums[i][j - 1]
                        - sums[i - 1][j - 1] + mat[i - 1][j - 1];
            }
        }
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                ret[i][j] = get(sums, m, n, i + k + 1, j + k + 1) - get(sums, m, n, i - k, j + k + 1) - get(sums, m, n, i + k + 1, j - k) + get(sums, m, n, i - k, j - k);
            }
        }
        return ret;
    }

    private int get(int[][] sum, int m, int n, int x, int y) {
        x = Math.max(Math.min(x, m), 0);
        y = Math.max(Math.min(y, n), 0);
        return sum[x][y];
    }


    public List<String> printVertically(String s) {
        String[] words = s.split("\\s");
        int maxLength = 0;
        for (String word : words) {
            maxLength = Math.max(maxLength, word.length());
        }
        StringBuilder[] sbs = new StringBuilder[maxLength];
        for (int i = 0; i < sbs.length; ++i) {
            sbs[i] = new StringBuilder();
        }
        for (int i = 0; i < maxLength; ++i) {
            for (String word : words) {
                if (i < word.length()) {
                    sbs[i].append(word.charAt(i));
                } else {
                    sbs[i].append(" ");
                }
            }
        }
        List<String> ret = new ArrayList<>();
        for (StringBuilder sb : sbs) {
            while (sb.charAt(sb.length() - 1) == ' ') {
                sb.deleteCharAt(sb.length() - 1);
            }
            ret.add(sb.toString());
        }
        return ret;

    }


}
