package leetcode;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Stack;

/**
 * @author zhiqungao@tencent.com
 * @date 2022/1/28 下午4:11
 */
public class Leetcode_858_mirrorReflection {
    public static void main(String[] args) {
        Leetcode_858_mirrorReflection l = new Leetcode_858_mirrorReflection();
        System.out.println(l.mirrorReflection(2, 1));

    }

    public int mirrorReflection(int p, int q) {
        return dfs(0, 0, p, p, q);
    }

    private int dfs(int x, int y, int p, int xs, int ys) {
        x += xs;
        y += ys;
        if (x == p && y == 0) {
            return 0;
        } else if (x == p && y == p) {
            return 1;
        } else if (x == 0 && y == p) {
            return 2;
        } else if (x == p) {
            xs = -xs;
        } else if (y == p) {
            ys = -ys;
        }
        return dfs(x, y, p, xs, ys);
    }

}
