package leetcode;

import java.util.*;

/**
 * @author zhiqungao@tencent.com
 * @date 2022/7/8 下午8:56
 */
public class Leetcode_1202_smallestStringWithSwaps {
    public static void main(String[] args) {
        Leetcode_1202_smallestStringWithSwaps l = new Leetcode_1202_smallestStringWithSwaps();
        List<List<Integer>> list = new ArrayList<>();
        list.add(Arrays.asList(0, 3));
        list.add(Arrays.asList(1, 2));
        list.add(Arrays.asList(0, 2));
        System.out.println(l.smallestStringWithSwaps("dcab", list));
    }


    public String smallestStringWithSwaps(String s, List<List<Integer>> pairs) {
        int m = s.length();
        int[] parent = new int[m];
        for (int i = 0; i < m; ++i) {
            parent[i] = i;
        }
        for (List<Integer> list : pairs) {
            union(parent, list.get(0), list.get(1));
        }
        Map<Integer, LinkedList<Integer>> map = new HashMap<>();
        for (int i = 0; i < m; ++i) {
            int p = find(parent, i);
            LinkedList<Integer> list = map.computeIfAbsent(p, f -> new LinkedList<>());
            list.addLast(i);
        }
        for (LinkedList<Integer> list : map.values()) {
            Collections.sort(list, Comparator.comparingInt(s::charAt));
        }

        char[] ret = new char[m];
        for (int i = 0; i < m; ++i) {
            int p = find(parent, i);
            ret[i] = s.charAt(map.get(p).pollFirst());
        }
        return new String(ret);
    }


    private void union(int[] parent, int i, int j) {
        int a = find(parent, i);
        int b = find(parent, j);
        if (a < b) {
            parent[b] = a;
        } else {
            parent[a] = b;
        }
    }

    private int find(int[] parent, int i) {
        while (i != parent[i]) {
            i = parent[i];
        }
        return i;
    }
}
