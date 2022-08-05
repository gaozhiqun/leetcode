package leetcode;


import java.util.ArrayList;
import java.util.List;

public class Leetcode_990_equationsPossible {
    public static void main(String[] args) {
        Leetcode_990_equationsPossible l = new Leetcode_990_equationsPossible();
        System.out.println(l.equationsPossible(new String[]{
                "b==a", "a==b"
        }));
        System.out.println(l.equationsPossible(new String[]{
                "a==b", "b==c", "a==c"
        }));
        System.out.println(l.equationsPossible(new String[]{
                "a==b", "b!=c", "c==a"
        }));
        System.out.println(l.equationsPossible(new String[]{
                "c==c", "b==d", "x!=z"
        }));

    }

    public boolean equationsPossible(String[] equations) {
        int[] parent = new int[26];
        for (int i = 0; i < 26; ++i) {
            parent[i] = i;
        }
        List<int[]> equals = new ArrayList<>();
        List<int[]> notEquals = new ArrayList<>();
        for (String e : equations) {
            int[] p = new int[]{e.charAt(0) - 'a', e.charAt(3) - 'a'};
            if ('!' == e.charAt(1)) {
                notEquals.add(p);
            } else {
                equals.add(p);
            }
        }
        for (int[] pair : equals) {
            union(parent, pair[0], pair[1]);
        }
        for (int[] pair : notEquals) {
            if (find(parent, pair[0]) == find(parent, pair[1])) {
                return false;
            }
        }
        return true;
    }

    private void union(int[] parent, int x, int y) {
        int p1 = find(parent, x);
        int p2 = find(parent, y);
        if (p1 != p2) {
            parent[p2] = p1;
        }
    }

    private int find(int[] parent, int x) {
        while (x != parent[x]) {
            x = parent[x];
        }
        return x;
    }


}
