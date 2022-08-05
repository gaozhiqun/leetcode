package algorithm.union;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zhiqungao@tencent.com
 * @date 2021/10/27 下午8:37
 */
public class EquationPossible {
    public static void main(String[] args) {
        EquationPossible equationPossible = new EquationPossible();
        System.out.println(equationPossible.equationsPossible(new String[]{
                "a==b", "b!=a"
        }));
        System.out.println(equationPossible.equationsPossible(new String[]{
                "a==b", "b==a"
        }));
        System.out.println(equationPossible.equationsPossible(new String[]{
                "a==b", "b==c", "a==c"
        }));
        System.out.println(equationPossible.equationsPossible(new String[]{
                "a==b", "b!=c", "c==a"
        }));
    }

    public boolean equationsPossible(String[] equations) {
        int[] array = new int[26];
        for (int i = 0; i < 26; ++i) {
            array[i] = i;
        }
        List<String> notEquals = new ArrayList<>();
        for (String s : equations) {
            if ('!' == s.charAt(1)) {
                notEquals.add(s);
                continue;
            }
            int a = s.charAt(0) - 'a';
            int b = s.charAt(3) - 'a';
            union(a, b, array);
        }
        for (String s : notEquals) {
            int a = s.charAt(0) - 'a';
            int b = s.charAt(3) - 'a';
            if (find(a, array) == find(b, array)) {
                return false;
            }
        }
        return true;
    }

    private void union(int x, int y, int[] array) {
        int a = find(x, array);
        int b = find(y, array);
        array[b] = a;
    }

    private int find(int x, int[] array) {
        while (array[x] != x) {
            x = array[x];
        }
        return x;
    }
}
