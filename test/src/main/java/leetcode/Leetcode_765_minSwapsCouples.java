package leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author zhiqungao@tencent.com
 * @date 2022/1/13 下午5:35
 */
public class Leetcode_765_minSwapsCouples {
    public static void main(String[] args) {
        Leetcode_765_minSwapsCouples l = new Leetcode_765_minSwapsCouples();
        System.out.println(l.minSwapsCouples(new int[]{0, 2, 1, 3}));
        System.out.println(l.minSwapsCouples(new int[]{0, 2, 1, 3}));
        System.out.println(l.minSwapsCouples(new int[]{3, 2, 0, 1}));
    }

    /**
     * Draw a line from (x, y) to (x+1, y+1) if we see a "1",
     * else to (x+1, y-1). A special substring is just a line that starts and ends at the same y-coordinate,
     * and that is the lowest y-coordinate reached.
     * Call a mountain a special substring with no special prefixes - ie.
     * only at the beginning and end is the lowest y-coordinate reached.
     * If F is the answer function, and S has mountain decomposition M1,M2,M3,...,Mk,
     * then the answer is: reverse_sorted(F(M1), F(M2), ..., F(Mk)).
     * However, you'll also need to deal with the case that S is a mountain, such as 11011000 -> 11100100.
     *
     * @param s
     * @return
     */

    public int minSwapsCouples(int[] row) {
        int m = row.length;
        int d = row.length / 2;
        int[] parent = new int[d];

        for (int i = 0; i < parent.length; i++) {
            parent[i] = i;
        }
        for (int i = 0; i < row.length; i += 2) {
            union(parent, row[i] / 2, row[i + 1] / 2);
        }
        int ret = 0;
        for (int i = 0; i < d; ++i) {
            if (parent[i] == i) {
                ++ret;
            }
        }
        return d - ret;
    }

    private int find(int[] parent, int i) {
        while (i != parent[i]) {
            i = parent[i];
        }
        return i;
    }

    private void union(int[] parent, int i, int j) {
        int p1 = find(parent, i);
        int p2 = find(parent, j);
        parent[p2] = p1;
    }


}
