package leetcode;

import java.util.*;

/**
 * @author zhiqungao@tencent.com
 * @date 2022/1/27 下午2:48
 */
public class Leetcode_839_similarString {
    public static void main(String[] args) {
        Leetcode_839_similarString l = new Leetcode_839_similarString();
//        System.out.println(l.numMagicSquaresInside(new int[][]{
//                {4, 3, 8, 4}, {9, 5, 1, 9}, {2, 7, 6, 2}
//        }));
    }


    public int numSimilarGroups(String[] strs) {
        int m = strs.length;
        int[] parent = new int[m];
        for (int i = 0; i < m; ++i) {
            parent[i] = i;
        }
        for (int i = 0; i < m; ++i) {
            for (int j = i + 1; j < m; ++j) {
                if (check(strs[i], strs[j])) {
                    union(i, j, parent);
                }
            }
        }
        int ret = 0;
        for (int i = 0; i < m; i++) {
            if (parent[i] == i) {
                ret++;
            }
        }
        return ret;

    }

    public boolean check(String a, String b) {
        int num = 0, len = a.length();
        for (int i = 0; i < len; i++) {
            if (a.charAt(i) != b.charAt(i)) {
                num++;
                if (num > 2) {
                    return false;
                }
            }
        }
        return true;
    }

    private void union(int i, int j, int[] parent) {
        int p1 = find(i, parent);
        int p2 = find(j, parent);
        if (p1 == p2) {
            return;
        }
        parent[p2] = p1;
    }

    private int find(int x, int[] parent) {
        while (x != parent[x]) {
            x = parent[x];
        }
        return x;
    }


    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        int m = rooms.size();
        Queue<Integer> queue = new LinkedList<>();
        Set<Integer> set = new HashSet<>();
        queue.offer(0);
        while (!queue.isEmpty()) {
            int cur = queue.poll();
            set.add(cur);
            for (int i : rooms.get(cur)) {
                if (!set.contains(i)) {
                    queue.offer(i);
                }
            }
        }
        return set.size() == m;
    }


}
